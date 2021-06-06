package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.UserTypeModel;
import br.com.vbdev.beleza_agendada.model.types.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeModel, Long> {

    UserTypeModel findByUserType( UserType userType);
}
