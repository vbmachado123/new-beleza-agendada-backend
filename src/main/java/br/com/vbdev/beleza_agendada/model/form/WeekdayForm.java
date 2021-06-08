package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.types.Weekday;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class WeekdayForm {

    private Long weekday;

//    private Weekday weekday;

    public Long getWeekday() {
        return weekday;
    }

    public void setWeekday(Long weekday) {
        this.weekday = weekday;
    }


//    public Weekday getWeekday() {
//        return weekday;
//    }
//
//    public void setWeekday(Weekday weekday) {
//        this.weekday = weekday;
//    }
}
