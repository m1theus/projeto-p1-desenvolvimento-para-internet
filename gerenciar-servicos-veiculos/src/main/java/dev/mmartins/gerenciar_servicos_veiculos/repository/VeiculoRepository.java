package dev.mmartins.gerenciar_servicos_veiculos.repository;

import dev.mmartins.gerenciar_servicos_veiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
