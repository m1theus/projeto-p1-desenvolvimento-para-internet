package dev.mmartins.gerenciar_servicos_veiculos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Veiculo implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String anoModelo;
    private String anoFabricacao;
    private Double preco;

    @OneToMany
    private List<Servico> servicos = new ArrayList<>();
}
