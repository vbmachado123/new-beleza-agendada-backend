package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "agenda_item")
public class ScheduleItemModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    //@JoinColumn(name = "id")
    private ScheduleModel schedule;
    private String note; // Observação
    private boolean available; // Disponivel

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime hour; // horário
    /**
     * Primeiro item não é dependente de ninguém, é isolado
     * todos posteriores recebem o id do item agendado (principal)
     * */
    private Long dependencyId; // Refere-se ao id de ScheduleItem
    private boolean reschedule;
    private boolean executed;
    private boolean active;

    public ScheduleItemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(Long dependencyId) {
        this.dependencyId = dependencyId;
    }

    public boolean isReschedule() {
        return reschedule;
    }

    public void setReschedule(boolean reschedule) {
        this.reschedule = reschedule;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }

    public DateTime getHour() {
        return hour;
    }

    public void setHour(DateTime hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleItemModel)) return false;
        ScheduleItemModel that = (ScheduleItemModel) o;
        return isAvailable() == that.isAvailable() && isReschedule() == that.isReschedule() && isExecuted() == that.isExecuted() && isActive() == that.isActive() && Objects.equals(getId(), that.getId()) && Objects.equals(getSchedule(), that.getSchedule()) && Objects.equals(getNote(), that.getNote()) && Objects.equals(getHour(), that.getHour()) && Objects.equals(getDependencyId(), that.getDependencyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSchedule(), getNote(), isAvailable(), getHour(), getDependencyId(), isReschedule(), isExecuted(), isActive());
    }
}
