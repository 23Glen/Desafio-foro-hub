package com.desafio.foroHub.domain.respuesta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotBlank String mensaje,
        @NotNull Long idTopico,
        @NotNull Long idUsuario) {
}
