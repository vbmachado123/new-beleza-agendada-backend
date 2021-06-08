package br.com.vbdev.beleza_agendada.model.form;

import java.util.Date;
import java.util.List;

public class OpenHoursBeautySalonForm {

    private Long id;

    private String description;

    private String initial_hour; // Formatar para HH:mm
    private String final_hour; // Formatar para HH:mm

//    private BeautySalonForm beauty_salon;

    private List<WeekdayForm> weekday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInitial_hour() {
        return initial_hour;
    }

    public void setInitial_hour(String initial_hour) {
        this.initial_hour = initial_hour;
    }

    public String getFinal_hour() {
        return final_hour;
    }

    public void setFinal_hour(String final_hour) {
        this.final_hour = final_hour;
    }

    public List<WeekdayForm> getWeekday() {
        return weekday;
    }

    public void setWeekday(List<WeekdayForm> weekday) {
        this.weekday = weekday;
    }
}
