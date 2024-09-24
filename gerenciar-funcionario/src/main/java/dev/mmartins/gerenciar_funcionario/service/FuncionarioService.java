package dev.mmartins.gerenciar_funcionario.service;

import dev.mmartins.gerenciar_funcionario.entity.Funcionario;
import dev.mmartins.gerenciar_funcionario.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(final FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario create(final Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario findOne(final String cpf) {
        return funcionarioRepository.findById(cpf).orElseThrow(null);
    }

    public void delete(final String cpf) {
        funcionarioRepository.delete(findOne(cpf));
    }

    public Long count() {
        return funcionarioRepository.count();
    }

    public List<Funcionario> findTopSalarios() {
        return funcionarioRepository.findTop5ByOrderBySalarioDesc();
    }
}
