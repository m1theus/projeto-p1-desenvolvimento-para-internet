package dev.mmartins.gerenciar_funcionario.repository;

import dev.mmartins.gerenciar_funcionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    List<Funcionario> findTop5ByOrderBySalarioDesc();
}
