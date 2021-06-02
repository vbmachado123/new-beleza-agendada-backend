package br.com.vbdev.beleza_agendada.model;

import br.com.vbdev.beleza_agendada.model.types.Weekday;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "weekday")
public class WeekdayModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Weekday weekday;

    public WeekdayModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekdayModel)) return false;
        WeekdayModel that = (WeekdayModel) o;
        return Objects.equals(id, that.id) && weekday == that.weekday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekday);
    }
}
