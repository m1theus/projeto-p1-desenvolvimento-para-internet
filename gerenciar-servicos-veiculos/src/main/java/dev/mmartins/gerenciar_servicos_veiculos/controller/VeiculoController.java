package dev.mmartins.gerenciar_servicos_veiculos.controller;

import dev.mmartins.gerenciar_servicos_veiculos.entity.Veiculo;
import dev.mmartins.gerenciar_servicos_veiculos.service.VeiculoService;
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
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(final VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> findOne(@PathVariable final String placa) {
        return ResponseEntity.ok(service.findOne(placa));
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody final Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(veiculo));
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Veiculo> update(@PathVariable final String placa, final Veiculo veiculo) {
        return ResponseEntity.ok(service.update(placa, veiculo));
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Veiculo> delete(@PathVariable final String placa) {
        service.delete(placa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
