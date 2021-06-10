package br.com.vbdev.beleza_agendada.repository;

import br.com.vbdev.beleza_agendada.model.BreakTimeModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakTimeRepository extends JpaRepository<BreakTimeModel, Long> {

    List<BreakTimeModel> findByUser(UserModel user);
}
