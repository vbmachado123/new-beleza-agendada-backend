package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.ProfessionalPlanModel;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class ProfessionalFlasItemForm {

    private Long id;

    private ProfessionalPlanForm professional_plan;

    private DateTime initial_date;

    private DateTime final_date;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfessionalPlanForm getProfessional_plan() {
        return professional_plan;
    }

    public void setProfessional_plan(ProfessionalPlanForm professional_plan) {
        this.professional_plan = professional_plan;
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
