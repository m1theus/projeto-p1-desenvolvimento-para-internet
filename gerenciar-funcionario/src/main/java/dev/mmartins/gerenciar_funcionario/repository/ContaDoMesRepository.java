package dev.mmartins.gerenciar_funcionario.repository;

import dev.mmartins.gerenciar_funcionario.entity.ContasDoMes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaDoMesRepository extends JpaRepository<ContasDoMes, Long> {
    List<ContasDoMes> findTop5ByOrderByValorDesc();
}
