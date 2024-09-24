package dev.mmartins.gerenciar_servicos_veiculos.service;

import dev.mmartins.gerenciar_servicos_veiculos.controller.ServicosRequest;
import dev.mmartins.gerenciar_servicos_veiculos.controller.exceptions.BusinessException;
import dev.mmartins.gerenciar_servicos_veiculos.entity.Servico;
import dev.mmartins.gerenciar_servicos_veiculos.repository.ServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {
    private final ServicoRepository servicoRepository;
    private final VeiculoService veiculoService;

    public ServicosService(final ServicoRepository servicoRepository, final VeiculoService veiculoService) {
        this.servicoRepository = servicoRepository;
        this.veiculoService = veiculoService;
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findOne(final Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, String.format("Servico de id %s não encontrado!", id)));
    }

    public Servico create(final ServicosRequest servico) {
        final var saved = servicoRepository.save(new Servico(servico));
        veiculoService.addNewServico(servico.placaVeiculo(), saved);
        return saved;
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
