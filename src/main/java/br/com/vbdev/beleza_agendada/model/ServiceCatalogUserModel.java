package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "service_catalog_user")
public class ServiceCatalogUserModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServiceCatalogModel service_catalog;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ScheduleTimeModel scheduling_time;

    private double value;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProfessionalUserModel professional_user;

    private int multiplier_time_schedule; // Quantos tempos da agenda o serviço ocupa

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ReschedulingTimeModel rescheduling_time;

    public ServiceCatalogUserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceCatalogModel getService_catalog() {
        return service_catalog;
    }

    public void setService_catalog(ServiceCatalogModel service_catalog) {
        this.service_catalog = service_catalog;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ProfessionalUserModel getProfessional_user() {
        return professional_user;
    }

    public void setProfessional_user(ProfessionalUserModel professional_user) {
        this.professional_user = professional_user;
    }

    public int getMultiplier_time_schedule() {
        return multiplier_time_schedule;
    }

    public void setMultiplier_time_schedule(int multiplier_time_schedule) {
        this.multiplier_time_schedule = multiplier_time_schedule;
    }

    public ReschedulingTimeModel getRescheduling_time() {
        return rescheduling_time;
    }

    public void setRescheduling_time(ReschedulingTimeModel rescheduling_time) {
        this.rescheduling_time = rescheduling_time;
    }

    public ScheduleTimeModel getScheduling_time() {
        return scheduling_time;
    }

    public void setScheduling_time(ScheduleTimeModel scheduling_time) {
        this.scheduling_time = scheduling_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceCatalogUserModel)) return false;
        ServiceCatalogUserModel that = (ServiceCatalogUserModel) o;
        return Double.compare(that.getValue(), getValue()) == 0 && getMultiplier_time_schedule() == that.getMultiplier_time_schedule() && Objects.equals(getId(), that.getId()) && Objects.equals(getService_catalog(), that.getService_catalog()) && Objects.equals(getScheduling_time(), that.getScheduling_time()) && Objects.equals(getProfessional_user(), that.getProfessional_user()) && Objects.equals(getRescheduling_time(), that.getRescheduling_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getService_catalog(), getScheduling_time(), getValue(), getProfessional_user(), getMultiplier_time_schedule(), getRescheduling_time());
    }
}
