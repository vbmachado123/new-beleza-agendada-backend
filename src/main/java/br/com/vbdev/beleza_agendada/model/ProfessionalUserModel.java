package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "professional_user")
public class ProfessionalUserModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BeautySalonModel beauty_salon;

    private String qrCode;

    public ProfessionalUserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public BeautySalonModel getBeauty_salon() {
        return beauty_salon;
    }

    public void setBeauty_salon(BeautySalonModel beauty_salon) {
        this.beauty_salon = beauty_salon;
    }


    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessionalUserModel)) return false;
        ProfessionalUserModel that = (ProfessionalUserModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getBeauty_salon(), that.getBeauty_salon()) && Objects.equals(getQrCode(), that.getQrCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getBeauty_salon(), getQrCode());
    }
}
