package com.dailystatusapi.controller;

import com.dailystatusapi.event.RecursoCriadoEvent;
import com.dailystatusapi.model.Build;
import com.dailystatusapi.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/builds")
public class BuildController {

    @Autowired
    private BuildService buildService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Build> listar() {
        return buildService.listar();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Build> buscarPeloCodigo(@PathVariable Long codigo) {
        Build build = buildService.getBuild(codigo);
        return build != null ? ResponseEntity.ok(build) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Build> criar(@Valid @RequestBody Build build, HttpServletResponse response) {
        Build itemSalva = buildService.salvar(build);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, itemSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(itemSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Build> atualizar(@PathVariable Long codigo, @Valid @RequestBody Build itemTeste) {
        Build itemSalvo = buildService.atualizar(codigo, itemTeste);
        return ResponseEntity.ok(itemSalvo);
    }
}
