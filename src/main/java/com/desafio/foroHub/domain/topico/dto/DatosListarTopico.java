package com.desafio.foroHub.domain.topico.dto;

import com.desafio.foroHub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Long idUsuario,
        Long idCurso) {

    public DatosListarTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }
}
