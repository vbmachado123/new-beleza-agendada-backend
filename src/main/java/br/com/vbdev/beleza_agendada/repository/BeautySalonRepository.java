package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.BeautySalonModel;

import br.com.vbdev.beleza_agendada.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeautySalonRepository extends JpaRepository<BeautySalonModel, Long> {

    Optional<BeautySalonModel> findByqrCode(String qr_code);

    @Query("SELECT b FROM BeautySalonModel b WHERE b.userName =:userName")
    BeautySalonModel findByUsername(@Param("userName") String userName);

    @Modifying
    @Query("update BeautySalonModel b set b.qrCode = :qrCode where b.id = :id")
    void update(String qrCode, Long id);

}
