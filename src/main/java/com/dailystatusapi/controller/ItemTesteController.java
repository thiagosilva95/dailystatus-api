package com.dailystatusapi.controller;

import com.dailystatusapi.event.RecursoCriadoEvent;
import com.dailystatusapi.model.ItemTeste;
import com.dailystatusapi.service.ItemTesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item-teste")
public class ItemTesteController {

    @Autowired
    private ItemTesteService itemService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<ItemTeste> listar() {
        return itemService.listar();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemTeste> buscarPeloCodigo(@PathVariable Long codigo) {
        ItemTeste pessoa = itemService.getItemTeste(codigo);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ItemTeste> criar(@Valid @RequestBody ItemTeste itemTeste, HttpServletResponse response) {
        ItemTeste itemSalva = itemService.salvar(itemTeste);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, itemSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(itemSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ItemTeste> atualizar(@PathVariable Long codigo, @Valid @RequestBody ItemTeste itemTeste) {
        ItemTeste itemSalvo = itemService.atualizar(codigo, itemTeste);
        return ResponseEntity.ok(itemSalvo);
    }
}
