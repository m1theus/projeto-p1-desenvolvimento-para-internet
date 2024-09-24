package dev.mmartins.gerenciar_servicos_veiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Servico implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @ManyToOne
    private Veiculo veiculo;
}
