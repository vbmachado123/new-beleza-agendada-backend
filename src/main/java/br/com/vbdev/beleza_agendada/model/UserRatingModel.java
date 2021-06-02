package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_rating")
public class UserRatingModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rating; //avaliação

    @OneToOne
    @JoinColumn(name="equipe_id", referencedColumnName = "id")
    private UserModel user;

    public UserRatingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
        if (!(o instanceof UserRatingModel)) return false;
        UserRatingModel that = (UserRatingModel) o;
        return Double.compare(that.getRating(), getRating()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRating(), getUser());
    }
}
