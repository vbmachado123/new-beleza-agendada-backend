package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "professional_plan")
public class ProfessionalPlanModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PlanModel plan;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime initial_date; //Data inicial do plano

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime final_date; //Data final (vencimento) do plano
    private boolean active;

    public ProfessionalPlanModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PlanModel getPlan() {
        return plan;
    }

    public void setPlan(PlanModel plan) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessionalPlanModel)) return false;
        ProfessionalPlanModel that = (ProfessionalPlanModel) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(plan, that.plan) && Objects.equals(initial_date, that.initial_date) && Objects.equals(final_date, that.final_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, plan, initial_date, final_date, active);
    }
}
