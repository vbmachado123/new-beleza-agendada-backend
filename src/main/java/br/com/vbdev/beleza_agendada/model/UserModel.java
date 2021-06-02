package br.com.vbdev.beleza_agendada.model;


import br.com.vbdev.beleza_agendada.model.types.LoginType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date birth_date;
    @Enumerated(EnumType.STRING)
    private LoginType logintype;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName = "id")
    private AddressModel address;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName = "id")
    private UserTypeModel userType;
    private String login;
    private String image_path;

    public UserModel() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public UserTypeModel getUserType() {
        return userType;
    }

    public void setUserType(UserTypeModel userType) {
        this.userType = userType;
    }

    public LoginType getLogintype() {
        return logintype;
    }

    public void setLogintype(LoginType logintype) {
        this.logintype = logintype;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(getId(), userModel.getId()) && Objects.equals(getName(), userModel.getName()) && Objects.equals(getEmail(), userModel.getEmail()) && Objects.equals(getPassword(), userModel.getPassword()) && Objects.equals(getPhone(), userModel.getPhone()) && Objects.equals(getBirth_date(), userModel.getBirth_date()) && getLogintype() == userModel.getLogintype() && Objects.equals(getAddress(), userModel.getAddress()) && Objects.equals(getUserType(), userModel.getUserType()) && Objects.equals(getLogin(), userModel.getLogin()) && Objects.equals(getImage_path(), userModel.getImage_path());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getPhone(), getBirth_date(), getLogintype(), getAddress(), getUserType(), getLogin(), getImage_path());
    }
}
