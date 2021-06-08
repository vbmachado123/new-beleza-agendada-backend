package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "change_schedule")
public class ChangeScheduleModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ActionModel action;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ScheduleItemModel> schedule_item;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServiceCatalogUserModel service_catalog_user;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime request_date; //dataHora da solicitação
    private String reason;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user;

    public ChangeScheduleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActionModel getAction() {
        return action;
    }

    public void setAction(ActionModel action) {
        this.action = action;
    }

    public List<ScheduleItemModel> getSchedule_item() {
        return schedule_item;
    }

    public void setSchedule_item(List<ScheduleItemModel> schedule_item) {
        this.schedule_item = schedule_item;
    }

    public ServiceCatalogUserModel getService_catalog_user() {
        return service_catalog_user;
    }

    public void setService_catalog_user(ServiceCatalogUserModel service_catalog_user) {
        this.service_catalog_user = service_catalog_user;
    }

    public DateTime getRequest_date() {
        return request_date;
    }

    public void setRequest_date(DateTime request_date) {
        this.request_date = request_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeScheduleModel)) return false;
        ChangeScheduleModel that = (ChangeScheduleModel) o;
        return Objects.equals(id, that.id) && Objects.equals(action, that.action) && Objects.equals(schedule_item, that.schedule_item) && Objects.equals(service_catalog_user, that.service_catalog_user) && Objects.equals(request_date, that.request_date) && Objects.equals(reason, that.reason) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, schedule_item, service_catalog_user, request_date, reason, user);
    }
}
