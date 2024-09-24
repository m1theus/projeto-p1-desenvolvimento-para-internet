package dev.mmartins.gerenciar_servicos_veiculos.controller.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    @Getter
    private final HttpStatus status;
    @Getter
    private final String message;

    public BusinessException(final HttpStatus status, final String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BusinessException(final String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
