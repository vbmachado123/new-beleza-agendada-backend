package br.com.vbdev.beleza_agendada.model;

import br.com.vbdev.beleza_agendada.model.types.Month;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "month")
public class MonthModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Month month; // Mês

    public MonthModel() {
    }

    public MonthModel(Month month) {
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthModel)) return false;
        MonthModel that = (MonthModel) o;
        return id.equals(that.id) && month == that.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month);
    }
}
