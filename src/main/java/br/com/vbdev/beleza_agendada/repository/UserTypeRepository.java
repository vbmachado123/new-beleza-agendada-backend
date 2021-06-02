package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeModel, Long> {
}
