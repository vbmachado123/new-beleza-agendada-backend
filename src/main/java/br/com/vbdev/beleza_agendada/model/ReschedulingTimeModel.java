package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rescheduling_time")
public class ReschedulingTimeModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date schedules;

    public ReschedulingTimeModel() {
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

    public Date getSchedules() {
        return schedules;
    }

    public void setSchedules(Date schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReschedulingTimeModel)) return false;
        ReschedulingTimeModel that = (ReschedulingTimeModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getSchedules(), that.getSchedules());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getSchedules());
    }
}
