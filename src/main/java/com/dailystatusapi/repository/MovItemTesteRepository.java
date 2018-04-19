package com.dailystatusapi.repository;

import com.dailystatusapi.model.MovItemTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovItemTesteRepository extends JpaRepository<MovItemTeste, Long> {

    @Query("select m from MovItemTeste m where m.itemTeste.codigo = ?1")
    public MovItemTeste getUltimaMovimentacaoItem(Long codigoItem);
}
