package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "beauty_salon")
public class BeautySalonModel  implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String email;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AddressModel address;
    private String description; // Breve descrição do salão
    private String login;
    private String password;
    private String qr_code; //Código de associação do salão
    private String image_path; // Logo Image

    public BeautySalonModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
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
        if (!(o instanceof BeautySalonModel)) return false;
        BeautySalonModel that = (BeautySalonModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCnpj(), that.getCnpj()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getQr_code(), that.getQr_code()) && Objects.equals(getImage_path(), that.getImage_path());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCnpj(), getEmail(), getAddress(), getDescription(), getLogin(), getPassword(), getQr_code(), getImage_path());
    }
}
