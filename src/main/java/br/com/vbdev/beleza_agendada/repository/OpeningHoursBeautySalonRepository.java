package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.OpeningHoursBeautySalonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningHoursBeautySalonRepository extends JpaRepository<OpeningHoursBeautySalonModel, Long> {
}
