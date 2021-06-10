package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.BeautySalonModel;
import br.com.vbdev.beleza_agendada.model.OpeningHoursBeautySalonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpeningHoursBeautySalonRepository extends JpaRepository<OpeningHoursBeautySalonModel, Long> {

    List<OpeningHoursBeautySalonModel> findByBeautySalon(@Param("beauty_salon") BeautySalonModel beautySalonModel);
}
