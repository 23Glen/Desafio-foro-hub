package com.desafio.foroHub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long idUsuario,
        @NotNull Long idCurso) {

    public DatosTopico(DatosActualizarTopico datosActualizarTopico) {
        this(
                datosActualizarTopico.titulo(),
                datosActualizarTopico.mensaje(),
                datosActualizarTopico.idUsuario(),
                datosActualizarTopico.idCurso()
        );
    }
}
