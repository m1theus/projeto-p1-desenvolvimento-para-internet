package dev.mmartins.gerenciar_servicos_veiculos.repository;

import dev.mmartins.gerenciar_servicos_veiculos.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
