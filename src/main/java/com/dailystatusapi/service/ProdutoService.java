package com.dailystatusapi.service;

import com.dailystatusapi.model.Produto;
import com.dailystatusapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto getProduto(Long codigo) {
        return produtoRepository.findOne(codigo);
    }
}
