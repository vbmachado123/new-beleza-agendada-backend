package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "schedule")
public class ScheduleModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private MonthModel month; // mes ano

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BreakTimeModel> break_time;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<OpeningHoursBeautySalonModel> opening_hours_beauty_salon;

    public ScheduleModel() {
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

    public MonthModel getMonth() {
        return month;
    }

    public void setMonth(MonthModel month) {
        this.month = month;
    }

    public List<BreakTimeModel> getBreak_time() {
        return break_time;
    }

    public void setBreak_time(List<BreakTimeModel> break_time) {
        this.break_time = break_time;
    }

    public List<OpeningHoursBeautySalonModel> getOpening_hours_beauty_salon() {
        return opening_hours_beauty_salon;
    }

    public void setOpening_hours_beauty_salon(List<OpeningHoursBeautySalonModel> opening_hours_beauty_salon) {
        this.opening_hours_beauty_salon = opening_hours_beauty_salon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleModel)) return false;
        ScheduleModel that = (ScheduleModel) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(month, that.month) && Objects.equals(break_time, that.break_time) && Objects.equals(opening_hours_beauty_salon, that.opening_hours_beauty_salon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, month, break_time, opening_hours_beauty_salon);
    }
}
