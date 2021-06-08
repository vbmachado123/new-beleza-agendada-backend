package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.types.Month;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MonthForm {
    private Long id;

    private Month month;

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
}
