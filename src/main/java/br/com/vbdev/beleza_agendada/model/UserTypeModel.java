package br.com.vbdev.beleza_agendada.model;

import br.com.vbdev.beleza_agendada.model.types.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_type")
public class UserTypeModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private UserType user_type; // Client or Professional

    public UserTypeModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTypeModel)) return false;
        UserTypeModel that = (UserTypeModel) o;
        return Objects.equals(getId(), that.getId()) && getUser_type() == that.getUser_type();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser_type());
    }
}
