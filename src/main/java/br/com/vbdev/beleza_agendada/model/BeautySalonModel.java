package br.com.vbdev.beleza_agendada.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "beauty_salon")
public class BeautySalonModel  implements Serializable, UserDetails {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AddressModel address;

    private String description; // Breve descrição do salão
    private String qrCode; //Código de associação do salão
    private String image_path; // Logo Image

    @Column(name = "user_name", unique = true, updatable = true)
    private String userName;

    @Column(name = "beauty_salon_name")
    private String beautySalonName;

    @Column(name = "password")
    private String password;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(name = "beauty_salon_permission", joinColumns = { @JoinColumn (name = "id_beauty_salon") },
            inverseJoinColumns = { @JoinColumn (name = "id_salon_permission")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SalonPermissionModel> salon_permissions;

    public List<SalonPermissionModel> getSalon_permissions() {
        return salon_permissions;
    }

    public void setSalon_permissions(List<SalonPermissionModel> salon_permissions) {
        this.salon_permissions = salon_permissions;
    }

    public BeautySalonModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.salon_permissions;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBeautySalonName() {
        return beautySalonName;
    }

    public void setBeautySalonName(String beautySalonName) {
        this.beautySalonName = beautySalonName;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeautySalonModel)) return false;
        BeautySalonModel that = (BeautySalonModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCnpj(), that.getCnpj()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getQrCode(), that.getQrCode()) && Objects.equals(getImage_path(), that.getImage_path()) && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getBeautySalonName(), that.getBeautySalonName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(isAccountNonExpired(), that.isAccountNonExpired()) && Objects.equals(isAccountNonLocked(), that.isAccountNonLocked()) && Objects.equals(isCredentialsNonExpired(), that.isCredentialsNonExpired()) && Objects.equals(isEnabled(), that.isEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCnpj(), getAddress(), getDescription(), getQrCode(), getImage_path(), getUserName(), getBeautySalonName(), getPassword(), isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled());
    }
}
