package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "opening_hours_beauty_salon")
public class OpeningHoursBeautySalonModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime initial_hour; // Formatar para HH:mm

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime final_hour; // Formatar para HH:mm

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BeautySalonModel beauty_salon;

//    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<WeekdayModel> weekday;

    public OpeningHoursBeautySalonModel() {
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

    public BeautySalonModel getBeauty_salon() {
        return beauty_salon;
    }

    public void setBeauty_salon(BeautySalonModel beauty_salon) {
        this.beauty_salon = beauty_salon;
    }

    public List<WeekdayModel> getWeekday() {
        return weekday;
    }

    public void setWeekday(List<WeekdayModel> weekday) {
        this.weekday = weekday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpeningHoursBeautySalonModel)) return false;
        OpeningHoursBeautySalonModel that = (OpeningHoursBeautySalonModel) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(initial_hour, that.initial_hour) && Objects.equals(final_hour, that.final_hour) && Objects.equals(beauty_salon, that.beauty_salon) && Objects.equals(weekday, that.weekday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, initial_hour, final_hour, beauty_salon, weekday);
    }
}
