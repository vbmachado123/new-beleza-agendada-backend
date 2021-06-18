package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.converter.UserConverter;
import br.com.vbdev.beleza_agendada.model.*;
import br.com.vbdev.beleza_agendada.model.form.ScheduleForm;
import br.com.vbdev.beleza_agendada.repository.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private UserRepository userRepository;
    private UserModel userModel = new UserModel();

    @Autowired
    private BeautySalonRepository beautySalonRepository;
    private BeautySalonModel beautySalonModel = new BeautySalonModel();

    @Autowired
    private ScheduleRepository scheduleRepository;
    private ScheduleModel scheduleModel = new ScheduleModel();

    @Autowired
    private ScheduleTimeRepository scheduleTimeRepository;
    private ScheduleTimeModel scheduleTimeModel = new ScheduleTimeModel();

    @Autowired
    private OpeningHoursBeautySalonRepository openingHoursBeautySalonRepository;
    private OpeningHoursBeautySalonModel openingHoursBeautySalonModel
            = new OpeningHoursBeautySalonModel();

    private List<OpeningHoursBeautySalonModel> openingHoursBeautySalonModelList = new ArrayList<>();

    @Autowired
    private MonthRepository monthRepository;
    private MonthModel month = new MonthModel();

    @Autowired
    private ProfessionalUserRepository professionalUserRepository;
    private ProfessionalUserModel professionalUserModel = new ProfessionalUserModel();

    @Autowired
    private BreakTimeRepository breakTimeRepository;
    private BreakTimeModel breakTimeModel = new BreakTimeModel();

    @Autowired
    private ScheduleItemRepository scheduleItemRepository;
    private ScheduleItemModel scheduleItemModel = new ScheduleItemModel();

    @Autowired
    private ProfessionalPlanRepository professionalPlanRepository;
    private ProfessionalPlanModel professionalPlanModel = new ProfessionalPlanModel();

    public ScheduleForm create_schedule(ScheduleForm form) {

        // Criar a agenda com os horários e talz
        userModel = UserConverter.toModel(form.getUser());
        scheduleModel.setUser(userModel);

        openingHoursBeautySalonModelList
                = openingHoursBeautySalonRepository.findByBeautySalon(beautySalonModel);

        scheduleModel.setOpening_hours_beauty_salon(openingHoursBeautySalonModelList);

        // Criar Item Agenda
        create_scheduleItens(scheduleModel);

        // Recuperar os meses
        createScheduleForMounth();

        scheduleRepository.save(scheduleModel);
        return form;
    }

    private void createScheduleForMounth() {

        DateTime dateTime = new DateTime();

        dateTime.monthOfYear();
        dateTime.yearOfEra();

    }

    private void create_scheduleItens(ScheduleModel schedule) {

        List<ScheduleItemModel> scheduleItemModels = new ArrayList<>();
        boolean finished = false;

        DateTime hourInitial = new DateTime(openingHoursBeautySalonModel.getInitial_hour());
        DateTime firstHour = hourInitial;

        do {

            scheduleItemModel = new ScheduleItemModel();
            scheduleItemModel.setSchedule(schedule);
            scheduleItemModel.setActive(true);
            scheduleItemModel.setNote("Horário Disponível");
            scheduleItemModel.setReschedule(false);
            scheduleItemModel.setExecuted(false);

            /** Recuperar o Horário de Funcionamento do salão
             * Verificar o horário inicial
             * ir somando 30 minutos dentro do periodo de initial_hour e final_hour
             * */

            DateTime hour = new DateTime();
            if (!hourInitial.isEqual(firstHour))
                hour = new DateTime(hourInitial).plusMinutes(30);

            if (hour.isAfter(openingHoursBeautySalonModel.getFinal_hour())
                    || hour.isEqual(openingHoursBeautySalonModel.getFinal_hour()))
                finished = true;

            scheduleItemModel.setHour(hour);

            hourInitial = hour;

        } while (!finished);

        scheduleItemModels.add(scheduleItemModel);

        scheduleItemRepository.save(scheduleItemModel);

    }
}
