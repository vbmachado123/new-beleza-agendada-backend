package br.com.vbdev.beleza_agendada.model.form;

public class PlanForm {

    private Long id;

    private String description;
    private double value;
    private String time_course; //periodo

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTime_course() {
        return time_course;
    }

    public void setTime_course(String time_course) {
        this.time_course = time_course;
    }
}
