package com.dailystatusapi.controller;

import com.dailystatusapi.event.RecursoCriadoEvent;
import com.dailystatusapi.model.Produto;
import com.dailystatusapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo) {
        Produto pessoa = produtoService.getProduto(codigo);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
        Produto produtoSalvo = produtoService.salvar(produto);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
