package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.BeautySalonModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeautySalonRepository extends JpaRepository<BeautySalonModel, Long> {
    Optional<BeautySalonModel> findByqrCode(String qr_code);
}
