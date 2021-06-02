package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "attendance") //atendimento
public class AttendanceModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ScheduleItemModel agenda_item;
    private ServiceCatalogModel service_catalog;
    private Date initial_hour;
    private Date final_hour;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PaymentMethodModel paymentMethod;
    private double assessment;
    private double value; // Preço

    public AttendanceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleItemModel getAgenda_item() {
        return agenda_item;
    }

    public void setAgenda_item(ScheduleItemModel agenda_item) {
        this.agenda_item = agenda_item;
    }

    public ServiceCatalogModel getService_catalog() {
        return service_catalog;
    }

    public void setService_catalog(ServiceCatalogModel service_catalog) {
        this.service_catalog = service_catalog;
    }

    public Date getInitial_hour() {
        return initial_hour;
    }

    public void setInitial_hour(Date initial_hour) {
        this.initial_hour = initial_hour;
    }

    public Date getFinal_hour() {
        return final_hour;
    }

    public void setFinal_hour(Date final_hour) {
        this.final_hour = final_hour;
    }

    public PaymentMethodModel getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodModel paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceModel)) return false;
        AttendanceModel that = (AttendanceModel) o;
        return Double.compare(that.assessment, assessment) == 0 && Double.compare(that.value, value) == 0 && Objects.equals(id, that.id) && Objects.equals(agenda_item, that.agenda_item) && Objects.equals(service_catalog, that.service_catalog) && Objects.equals(initial_hour, that.initial_hour) && Objects.equals(final_hour, that.final_hour) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agenda_item, service_catalog, initial_hour, final_hour, paymentMethod, assessment, value);
    }
}
