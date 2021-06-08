package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.ReschedulingTimeModel;
import br.com.vbdev.beleza_agendada.model.SalonPermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonPermissionRepository extends JpaRepository<SalonPermissionModel, Long> {
}
