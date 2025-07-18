package com.desafio.foroHub.domain.respuesta.dto;

import com.desafio.foroHub.domain.respuesta.Respuesta;

import java.time.LocalDateTime;

public record DatosListarRespuesta(
        String mensaje,
        Long topico,
        Long idUsuario,
        Boolean solucion,
        LocalDateTime fechaCreacion) {

    public DatosListarRespuesta(Respuesta respuesta) {
        this(
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getUsuario().getId(),
                respuesta.getSolucion(),
                respuesta.getFechaCreacion()
        );
    }
}
