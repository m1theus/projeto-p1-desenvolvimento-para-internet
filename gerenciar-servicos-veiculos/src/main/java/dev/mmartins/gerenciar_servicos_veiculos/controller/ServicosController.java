package dev.mmartins.gerenciar_servicos_veiculos.controller;

import dev.mmartins.gerenciar_servicos_veiculos.entity.Servico;
import dev.mmartins.gerenciar_servicos_veiculos.service.ServicosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    private final ServicosService service;

    public ServicosController(final ServicosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findOne(@PathVariable final Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody final ServicosRequest servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(servico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> update(@PathVariable final Long id, final Servico servico) {
        return ResponseEntity.ok(service.update(id, servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
