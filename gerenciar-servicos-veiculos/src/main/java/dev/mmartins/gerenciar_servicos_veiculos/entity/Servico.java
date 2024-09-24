package dev.mmartins.gerenciar_servicos_veiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.mmartins.gerenciar_servicos_veiculos.controller.ServicosRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
public class Servico implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne
    private Veiculo veiculo;

    public Servico(final ServicosRequest servico) {
        this.descricao = servico.descricao();
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
        this.veiculo = new Veiculo(servico.placaVeiculo());
    }
}
