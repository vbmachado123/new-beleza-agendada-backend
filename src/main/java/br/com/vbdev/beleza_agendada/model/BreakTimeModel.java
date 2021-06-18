package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "break_time")
public class BreakTimeModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime initial_hour; // Formatar para HH:mm

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime final_hour; // Formatar para HH:mm

    public BreakTimeModel() {
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public DateTime getInitial_hour() {
        return initial_hour;
    }

    public void setInitial_hour(DateTime initial_hour) {
        this.initial_hour = initial_hour;
    }

    public DateTime getFinal_hour() {
        return final_hour;
    }

    public void setFinal_hour(DateTime final_hour) {
        this.final_hour = final_hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BreakTimeModel)) return false;
        BreakTimeModel that = (BreakTimeModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getInitial_hour(), that.getInitial_hour()) && Objects.equals(getFinal_hour(), that.getFinal_hour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getUser(), getInitial_hour(), getFinal_hour());
    }
}
