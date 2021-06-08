package br.com.vbdev.beleza_agendada.model;

import br.com.vbdev.beleza_agendada.model.types.FavoriteType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "favorites") //atendimento
public class FavoritesModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserModel user; // Usuario que favoritou <- Dono da lista

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessionalUserModel> professional_user; //listagem de profissionais

    @Enumerated(EnumType.STRING)
    private FavoriteType type;

    public FavoritesModel() {
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

    public List<ProfessionalUserModel> getProfessional_user() {
        return professional_user;
    }

    public void setProfessional_user(List<ProfessionalUserModel> professional_user) {
        this.professional_user = professional_user;
    }

    public FavoriteType getType() {
        return type;
    }

    public void setType(FavoriteType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritesModel)) return false;
        FavoritesModel that = (FavoritesModel) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(professional_user, that.professional_user) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, professional_user, type);
    }
}
