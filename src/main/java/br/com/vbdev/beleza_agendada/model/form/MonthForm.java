package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.types.Month;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MonthForm {
    private Long id;

    private Month month;

    private int year;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
