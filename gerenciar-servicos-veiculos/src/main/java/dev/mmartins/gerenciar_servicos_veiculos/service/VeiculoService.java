package dev.mmartins.gerenciar_servicos_veiculos.service;

import dev.mmartins.gerenciar_servicos_veiculos.controller.exceptions.BusinessException;
import dev.mmartins.gerenciar_servicos_veiculos.entity.Veiculo;
import dev.mmartins.gerenciar_servicos_veiculos.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(final VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findOne(final String placa) {
        return veiculoRepository.findById(placa)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, String.format("Veiculo de placa %s não encontrado!", placa)));
    }

    public Veiculo create(final Veiculo veiculo) {
        veiculoRepository.findById(veiculo.getPlaca())
                .ifPresent(v -> {
                    throw new BusinessException(HttpStatus.CONFLICT, String.format("Veiculo de placa %s já cadastrado!", veiculo.getPlaca()));
                });

        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(final String placa, final Veiculo veiculo) {
        final var entity = veiculoRepository.findById(placa)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, String.format("Veiculo de placa %s não encontrado!", placa)));

        entity.setModelo(veiculo.getModelo());
        entity.setMarca(veiculo.getMarca());
        entity.setCor(veiculo.getCor());
        entity.setAnoModelo(veiculo.getAnoModelo());
        entity.setAnoFabricacao(veiculo.getAnoFabricacao());
        entity.setPreco(veiculo.getPreco());

        return veiculoRepository.save(entity);
    }

    public void delete(String placa) {
        veiculoRepository.delete(findOne(placa));
    }
}
