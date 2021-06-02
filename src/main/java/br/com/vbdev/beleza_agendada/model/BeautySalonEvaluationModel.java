package br.com.vbdev.beleza_agendada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "beauty_salon_evaluation") //avaliação salão
public class BeautySalonEvaluationModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double rating;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private BeautySalonModel beauty_salon;

    public BeautySalonEvaluationModel() {
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

    public BeautySalonModel getBeauty_salon() {
        return beauty_salon;
    }

    public void setBeauty_salon(BeautySalonModel beauty_salon) {
        this.beauty_salon = beauty_salon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeautySalonEvaluationModel)) return false;
        BeautySalonEvaluationModel that = (BeautySalonEvaluationModel) o;
        return Double.compare(that.rating, rating) == 0 && Objects.equals(id, that.id) && Objects.equals(beauty_salon, that.beauty_salon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, beauty_salon);
    }
}
