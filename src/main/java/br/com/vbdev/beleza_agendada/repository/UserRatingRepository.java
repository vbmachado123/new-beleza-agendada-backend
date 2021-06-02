package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.UserRatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRatingModel, Long> {
}
