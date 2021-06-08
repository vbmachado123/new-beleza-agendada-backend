package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.converter.BeautySalonConverter;
import br.com.vbdev.beleza_agendada.model.*;
import br.com.vbdev.beleza_agendada.model.form.BeautySalonForm;
import br.com.vbdev.beleza_agendada.model.form.OpenHoursBeautySalonForm;
import br.com.vbdev.beleza_agendada.model.form.WeekdayForm;
import br.com.vbdev.beleza_agendada.repository.*;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.swing.text.MaskFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BeautySalonService {

    @Autowired
    private BeautySalonRepository beautySalonRepository;
    private BeautySalonModel beautySalonModel = new BeautySalonModel();

    @Autowired
    private AddressRepository addressRepository;
    private AddressModel addressModel = new AddressModel();

    @Autowired
    private SalonPermissionRepository permissionRepository;

    @Autowired
    private OpeningHoursBeautySalonRepository openingHoursBeautySalonRepository;
    private OpeningHoursBeautySalonModel openingHoursBeautySalonModel = new OpeningHoursBeautySalonModel();

    @Autowired
    private WeekdayRepository weekdayRepository;
    private WeekdayModel weekdayModel;

    public String createBeautySalon(BeautySalonForm salonForm) {
        String cnpjFormatado = cnpjFormated(salonForm.getCnpj());
        salonForm.setCnpj(cnpjFormatado);

        List<SalonPermissionModel> permission = new ArrayList<>();
        permission.add(permissionRepository.getOne(3L));

        beautySalonModel = BeautySalonConverter.toModel(salonForm);
        addressRepository.save(beautySalonModel.getAddress());
        beautySalonModel.setPassword(passwordEncoder(salonForm.getPassword()));

        beautySalonModel.setAccountNonExpired(true);
        beautySalonModel.setAccountNonExpired(true);
        beautySalonModel.setCredentialsNonExpired(true);
        beautySalonModel.setEnabled(true);
        beautySalonModel.setSalon_permissions(permission);
        beautySalonModel.setAccountNonLocked(true);

        createOpeningHoursBeautySalon(salonForm);

        BeautySalonModel salonCreated = beautySalonRepository.save(beautySalonModel);
        salonCreated.setQrCode(generateQrCode(salonCreated.getId()));
//        beautySalonRepository.save(salonCreated); // Criando o Qr Code do salão
        try {
            beautySalonRepository.update(salonCreated.getQrCode(), salonCreated.getId());
        } catch (Exception e) {
            beautySalonRepository.save(salonCreated);
        }

        return salonCreated.getQrCode();
    }

    private void createOpeningHoursBeautySalon(BeautySalonForm salonForm) {

        List<OpenHoursBeautySalonForm> openHours = salonForm.getOpenHoursBeautySalonFormList();

        for(OpenHoursBeautySalonForm ohbsf : openHours) {

            openingHoursBeautySalonModel.setBeauty_salon(beautySalonModel);
            openingHoursBeautySalonModel.setInitial_hour(convertToHour(ohbsf.getInitial_hour()));
            openingHoursBeautySalonModel.setFinal_hour(convertToHour(ohbsf.getFinal_hour()));
            openingHoursBeautySalonModel.setDescription(ohbsf.getDescription());

            List<WeekdayForm> weekdayForms = ohbsf.getWeekday();
            List<WeekdayModel> weekdayModels = new ArrayList<>();

            for(WeekdayForm form : weekdayForms) {

                weekdayModel = weekdayRepository.getOne(form.getWeekday());
                weekdayModels.add(weekdayModel);
            }

            openingHoursBeautySalonModel.setWeekday(weekdayModels);
            openingHoursBeautySalonRepository.save(openingHoursBeautySalonModel);

        }
    }

    private DateTime convertToHour(String hour) {

        LocalTime time = new LocalTime(hour);

        ReadableInstant instant = new DateTime();

        DateTime date = time.toDateTime(instant).minusHours(3);

//        System.out.println(time.getHourOfDay() + ":" + time.getMinuteOfHour() );
        System.out.println(date.getHourOfDay() + ":" + date.getMinuteOfHour());

        return date;
    }

    private String passwordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(password);
        return result;
    }

    /**
     * @description: O CNPJ provavelmente virá formatado, porém caso não, essa função existe
     * */
    private String cnpjFormated(String cnpj) {
        String formatted = "";
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            formatted = mask.valueToString(cnpj);

            if(cnpj != formatted)
                return formatted;
        } catch (ParseException e) {
            e.printStackTrace();
            formatted = cnpj;
            //O cnpj já virá formatado, mas pra facilitar essa função existe
        }
        return formatted;
    }

    private String generateQrCode(Long id) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);

        String qrCode = "#SAL" + year + id.toString();
        System.out.println(qrCode);
        return qrCode;
    }

    public BeautySalonForm findById(Long id) {

    return null;

    }
}
