package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.converter.BeautySalonConverter;
import br.com.vbdev.beleza_agendada.model.AddressModel;
import br.com.vbdev.beleza_agendada.model.BeautySalonModel;
import br.com.vbdev.beleza_agendada.model.OpeningHoursBeautySalonModel;
import br.com.vbdev.beleza_agendada.model.form.BeautySalonForm;
import br.com.vbdev.beleza_agendada.repository.AddressRepository;
import br.com.vbdev.beleza_agendada.repository.BeautySalonRepository;
import br.com.vbdev.beleza_agendada.repository.OpeningHoursBeautySalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Service
public class BeautySalonService {

    @Autowired
    private BeautySalonRepository beautySalonRepository;
    private BeautySalonModel beautySalonModel = new BeautySalonModel();

    @Autowired
    private AddressRepository addressRepository;
    private AddressModel addressModel = new AddressModel();

    @Autowired
    private OpeningHoursBeautySalonRepository openingHoursBeautySalonRepository;
    private OpeningHoursBeautySalonModel openingHoursBeautySalonModel = new OpeningHoursBeautySalonModel();

    public Long createBeautySalon(BeautySalonForm salonForm) {
        String cnpjFormatado = cnpjFormated(salonForm.getCnpj());
        salonForm.setCnpj(cnpjFormatado);

        beautySalonModel = BeautySalonConverter.toModel(salonForm);
        addressRepository.save(beautySalonModel.getAddress());

        BeautySalonModel salonCreated = beautySalonRepository.save(beautySalonModel);
        salonCreated.setQrCode(generateQrCode(salonCreated.getId()));
        beautySalonRepository.save(salonCreated);

        return salonCreated.getId();
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
        String qrCode = "#SAL2021" + id.toString();
        System.out.println(qrCode);
        return qrCode;
    }

    public BeautySalonForm findById(Long id) {

    return null;

    }
}
