package dev.mmartins.gerenciar_funcionario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Funcionario implements Serializable {
    @Id
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String nome;
    @NotNull
    private Double salario;
    private Date dataCriacao = new Date();
}
