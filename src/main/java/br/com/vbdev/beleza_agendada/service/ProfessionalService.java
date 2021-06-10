package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.model.*;
import br.com.vbdev.beleza_agendada.model.form.BreakTimeForm;
import br.com.vbdev.beleza_agendada.model.form.ProfessionalPlanForm;
import br.com.vbdev.beleza_agendada.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.vbdev.beleza_agendada.util.ConvertHour.convertToHour;

@Service
public class ProfessionalService {

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

    @Autowired
    private MonthRepository monthRepository;
    private MonthModel month;

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

    public BreakTimeForm create_breakTime(BreakTimeForm form) {

        userModel = userRepository.findByUsername(form.getUser().getEmail());

        breakTimeModel.setDescription(form.getDescription());
        breakTimeModel.setUser(userModel);

        breakTimeModel.setInitial_hour(convertToHour(form.getInitial_hour()));
        breakTimeModel.setFinal_hour(convertToHour(form.getFinal_hour()));

        breakTimeRepository.save(breakTimeModel);

        return form;
    }

    public ProfessionalPlanForm create_professional_plan(ProfessionalPlanForm form) {

        return form;
    }
}
