package dev.mmartins.gerenciar_servicos_veiculos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
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

    public Veiculo(final String placa) {
        this.placa = placa;
    }

    public void addNewServico(final Servico servico) {
        this.servicos.add(servico);
    }
}
