package com.dailystatusapi.repository;

import com.dailystatusapi.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuildRepository extends JpaRepository<Build, Long> {

    @Query("select b from Build b where b.produto.codigo = ?1")
    List<Build> listarPorProduto(Long codigoProduto);
}
