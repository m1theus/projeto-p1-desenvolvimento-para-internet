package dev.mmartins.gerenciar_funcionario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class ContasDoMes implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private Double valor;
    private Date dataCriacao = new Date();
}
