package br.com.vbdev.beleza_agendada.model.form;

import org.joda.time.DateTime;

public class ProfessionalPlanForm {

    private Long id;

    private UserForm user;

    private PlanForm plan;

    private DateTime initial_date; //Data inicial do plano

    private DateTime final_date; //Data final (vencimento) do plano

    private boolean active;

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

    public PlanForm getPlan() {
        return plan;
    }

    public void setPlan(PlanForm plan) {
        this.plan = plan;
    }

    public DateTime getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(DateTime initial_date) {
        this.initial_date = initial_date;
    }

    public DateTime getFinal_date() {
        return final_date;
    }

    public void setFinal_date(DateTime final_date) {
        this.final_date = final_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
