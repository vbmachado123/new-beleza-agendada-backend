package br.com.vbdev.beleza_agendada.model.form;

import br.com.vbdev.beleza_agendada.model.types.LoginType;

import java.util.Date;

public class UserForm {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date birth_date;
    private LoginType logintype;

    private AddressForm address;

    private UserTypeForm userType;
    private String image_path;

    private String salonCode;

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

    public LoginType getLogintype() {
        return logintype;
    }

    public void setLogintype(LoginType logintype) {
        this.logintype = logintype;
    }

    public AddressForm getAddress() {
        return address;
    }

    public void setAddress(AddressForm address) {
        this.address = address;
    }

    public UserTypeForm getUserType() {
        return userType;
    }

    public void setUserType(UserTypeForm userType) {
        this.userType = userType;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getSalonCode() {
        return salonCode;
    }

    public void setSalonCode(String salonCode) {
        this.salonCode = salonCode;
    }
}
