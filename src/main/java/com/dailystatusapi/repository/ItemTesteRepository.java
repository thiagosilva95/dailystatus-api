package com.dailystatusapi.repository;

import com.dailystatusapi.model.ItemTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemTesteRepository extends JpaRepository<ItemTeste, Long> {

    @Query("select i from ItemTeste i where i.build.codigo = ?1")
    List<ItemTeste> listarPorBuild(Long codigoBuild);

    @Query("select i from ItemTeste i " +
            "join i.build b " +
            "where b.produto.codigo = ?1")
    List<ItemTeste> listarPorProduto(Long codigoProduto);
}
