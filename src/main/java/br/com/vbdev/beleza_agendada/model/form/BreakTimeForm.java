package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.UserModel;

public class BreakTimeForm {

    private Long id;

    private String description;

    private UserForm user;

    private String initial_hour; // Formatar para HH:mm

    private String final_hour; // Formatar para HH:mm

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

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    }

    public String getInitial_hour() {
        return initial_hour;
    }

    public void setInitial_hour(String initial_hour) {
        this.initial_hour = initial_hour;
    }

    public String getFinal_hour() {
        return final_hour;
    }

    public void setFinal_hour(String final_hour) {
        this.final_hour = final_hour;
    }
}
