package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "plan")
public class PlanModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double value;
    private String time_course; //periodo

    public PlanModel() {
    }

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTime_course() {
        return time_course;
    }

    public void setTime_course(String time_course) {
        this.time_course = time_course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanModel)) return false;
        PlanModel planModel = (PlanModel) o;
        return Double.compare(planModel.value, value) == 0 && Objects.equals(id, planModel.id) && Objects.equals(description, planModel.description) && Objects.equals(time_course, planModel.time_course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, time_course);
    }
}
