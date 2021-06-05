package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.types.UserType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserTypeForm {
    private Long id;
    private UserType user_type; // Client or Professional

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }
}
