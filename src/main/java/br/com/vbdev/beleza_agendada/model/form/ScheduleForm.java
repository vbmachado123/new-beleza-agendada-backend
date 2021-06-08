package br.com.vbdev.beleza_agendada.model.form;

import java.util.List;

public class ScheduleForm {

    private Long id;

    private UserForm user;

    private MonthForm month; // mes ano

    private List<BreakTimeForm> break_time;

    private List<OpenHoursBeautySalonForm> opening_hours_beauty_salon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    }

    public MonthForm getMonth() {
        return month;
    }

    public void setMonth(MonthForm month) {
        this.month = month;
    }

    public List<BreakTimeForm> getBreak_time() {
        return break_time;
    }

    public void setBreak_time(List<BreakTimeForm> break_time) {
        this.break_time = break_time;
    }

    public List<OpenHoursBeautySalonForm> getOpening_hours_beauty_salon() {
        return opening_hours_beauty_salon;
    }

    public void setOpening_hours_beauty_salon(List<OpenHoursBeautySalonForm> opening_hours_beauty_salon) {
        this.opening_hours_beauty_salon = opening_hours_beauty_salon;
    }
}
