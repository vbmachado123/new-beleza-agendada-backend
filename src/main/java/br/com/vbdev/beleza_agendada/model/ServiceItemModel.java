package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "service_item") //atendimento
public class ServiceItemModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<AttendanceModel> attendance;
    private String image_path; // Caminho Fotos do serviço

    public ServiceItemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AttendanceModel> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<AttendanceModel> attendance) {
        this.attendance = attendance;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceItemModel)) return false;
        ServiceItemModel that = (ServiceItemModel) o;
        return Objects.equals(id, that.id) && Objects.equals(attendance, that.attendance) && Objects.equals(image_path, that.image_path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attendance, image_path);
    }
}
