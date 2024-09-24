package dev.mmartins.gerenciar_funcionario.service;

import dev.mmartins.gerenciar_funcionario.entity.ContasDoMes;
import dev.mmartins.gerenciar_funcionario.repository.ContaDoMesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaDoMesService {

    private final ContaDoMesRepository repository;

    public ContaDoMesService(final ContaDoMesRepository repository) {
        this.repository = repository;
    }

    public List<ContasDoMes> findAll() {
        return repository.findAll();
    }

    public ContasDoMes findOne(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Conta Do Mes de id %s não encontrata!", id)));
    }

    public ContasDoMes create(final ContasDoMes contasDoMes) {
        return repository.save(contasDoMes);
    }

    public ContasDoMes update(final ContasDoMes contasDoMes) {
        final ContasDoMes entity = findOne(contasDoMes.getId());
        entity.setDescricao(contasDoMes.getDescricao());
        entity.setValor(contasDoMes.getValor());
        return repository.save(entity);
    }

    public void delete(final Long id) {
        repository.delete(findOne(id));
    }

    public Long count() {
        return repository.count();
    }

    public List<ContasDoMes> findTopContas() {
        return repository.findTop5ByOrderByValorDesc();
    }
}
