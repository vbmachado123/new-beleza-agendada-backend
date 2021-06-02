package br.com.vbdev.beleza_agendada.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "address")
public class AddressModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String zip_code; //CEP
    private String district; //Bairro

    public AddressModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressModel)) return false;
        AddressModel that = (AddressModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getZip_code(), that.getZip_code()) && Objects.equals(getDistrict(), that.getDistrict());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getZip_code(), getDistrict());
    }
}
