package com.desafio.foroHub.domain.respuesta.validation;

import com.desafio.foroHub.domain.respuesta.dto.DatosRespuesta;
import com.desafio.foroHub.domain.topico.repository.TopicoRepository;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaTopico implements IValidadorDeRespuestas {
    @Autowired
    TopicoRepository topicoRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!topicoRepository.findById(datosRespuesta.idTopico()).isPresent()) {
            throw new ValidacionDeIntegridad("topico no econtrado");
        }
    }
}
