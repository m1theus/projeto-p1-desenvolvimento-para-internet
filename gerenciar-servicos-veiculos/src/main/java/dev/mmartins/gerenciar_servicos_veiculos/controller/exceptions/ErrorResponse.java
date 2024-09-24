package dev.mmartins.gerenciar_servicos_veiculos.controller.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {
}
