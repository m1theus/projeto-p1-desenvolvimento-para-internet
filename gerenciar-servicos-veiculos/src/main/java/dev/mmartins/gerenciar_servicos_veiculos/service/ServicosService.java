package dev.mmartins.gerenciar_servicos_veiculos.service;

import dev.mmartins.gerenciar_servicos_veiculos.controller.exceptions.BusinessException;
import dev.mmartins.gerenciar_servicos_veiculos.entity.Servico;
import dev.mmartins.gerenciar_servicos_veiculos.repository.ServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {
    private final ServicoRepository servicoRepository;

    public ServicosService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findOne(final Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, String.format("Servico de id %s não encontrado!", id)));
    }

    public Servico create(final Servico servico) {
        if (servico.getId() != null) {
            servicoRepository.findById(servico.getId())
                    .ifPresent(v -> {
                        throw new BusinessException(HttpStatus.CONFLICT, String.format("Servico de id %s já cadastrado!", servico.getId()));
                    });

        }

        return servicoRepository.save(servico);
    }

    public Servico update(final Long id, final Servico servico) {
        final Servico entity = findOne(id);

        entity.setDescricao(servico.getDescricao());
        entity.setDataAtualizacao(servico.getDataAtualizacao());
        entity.setVeiculo(servico.getVeiculo());

        return servicoRepository.save(entity);
    }

    public void delete(final Long id) {
        servicoRepository.delete(findOne(id));
    }
}
