package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.model.MonthModel;
import br.com.vbdev.beleza_agendada.model.WeekdayModel;
import br.com.vbdev.beleza_agendada.model.types.Month;
import br.com.vbdev.beleza_agendada.model.types.Weekday;
import br.com.vbdev.beleza_agendada.repository.MonthRepository;
import br.com.vbdev.beleza_agendada.repository.WeekdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingsService {

    @Autowired
    private WeekdayRepository weekdayRepository;

    private List<WeekdayModel> weekdays;

    @Autowired
    private MonthRepository monthRepository;

    private List<MonthModel> months;

    public List<WeekdayModel> addWeekday() {
        weekdays = new ArrayList<>();
        addWeekdayList();

        for(WeekdayModel day : weekdays) {
            System.out.println(day.getWeekday());
            weekdayRepository.save(day);
        }

        return weekdays;
    }

    private void addWeekdayList() {
        List<Weekday> days = new ArrayList<>();
        days.add(Weekday.sunday);
        days.add(Weekday.monday);
        days.add(Weekday.third);
        days.add(Weekday.wednesday);
        days.add(Weekday.thursday);
        days.add(Weekday.friday);
        days.add(Weekday.saturday);
        for(Weekday e : days) {
            //System.out.println(day.getWeekday());
            //weekdayModel.setWeekday(e);
            weekdays.add(new WeekdayModel(e));
        }
    }

    public List<MonthModel> addMonths() {
        months = new ArrayList<>();
        addMonthList();

        for(MonthModel month : months) {
            System.out.println(month.getMonth());
            monthRepository.save(month);
        }

        return months;
    }

    private void addMonthList() {
        List<Month> m = new ArrayList<>();
        m.add(Month.january);
        m.add(Month.february);
        m.add(Month.march);
        m.add(Month.april);
        m.add(Month.may);
        m.add(Month.june);
        m.add(Month.july);
        m.add(Month.august);
        m.add(Month.september);
        m.add(Month.october);
        m.add(Month.november);
        m.add(Month.december);

        for(Month x : m)
            months.add(new MonthModel(x));

    }
}
