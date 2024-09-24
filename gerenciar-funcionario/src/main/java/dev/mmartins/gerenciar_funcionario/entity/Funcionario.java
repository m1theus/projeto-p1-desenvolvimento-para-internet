package dev.mmartins.gerenciar_funcionario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Funcionario implements Serializable {
    @Id
    private String cpf;
    private String nome;
    private Double salario;
    private Date dataCriacao = new Date();
}
