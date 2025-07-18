package com.desafio.foroHub.domain.respuesta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull Long id,
        @NotBlank String mensaje) {
}
