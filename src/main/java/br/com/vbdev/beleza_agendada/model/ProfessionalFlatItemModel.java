package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "professional_flat_item")
public class ProfessionalFlatItemModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProfessionalPlanModel professional_plan;
    private Date initial_date;
    private Date final_date;
    private boolean active;

    public ProfessionalFlatItemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfessionalPlanModel getProfessional_plan() {
        return professional_plan;
    }

    public void setProfessional_plan(ProfessionalPlanModel professional_plan) {
        this.professional_plan = professional_plan;
    }

    public Date getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(Date initial_date) {
        this.initial_date = initial_date;
    }

    public Date getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessionalFlatItemModel)) return false;
        ProfessionalFlatItemModel that = (ProfessionalFlatItemModel) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(professional_plan, that.professional_plan) && Objects.equals(initial_date, that.initial_date) && Objects.equals(final_date, that.final_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professional_plan, initial_date, final_date, active);
    }
}
