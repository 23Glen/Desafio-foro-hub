package com.desafio.foroHub.domain.topico.dto;

import com.desafio.foroHub.domain.respuesta.dto.DatosDetallesRespuesta;
import com.desafio.foroHub.domain.topico.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DatosDetallesTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Long idUsuario,
        Long idCurso,
        List<DatosDetallesRespuesta> respuestas) {

    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getId(),
                topico.getCurso().getId(),
                topico.getRespuestas().stream().map(DatosDetallesRespuesta::new).collect(Collectors.toList())
        );
    }
}
