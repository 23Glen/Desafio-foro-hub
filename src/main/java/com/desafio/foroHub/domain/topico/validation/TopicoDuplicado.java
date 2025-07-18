package com.desafio.foroHub.domain.topico.validation;

import com.desafio.foroHub.domain.topico.dto.DatosTopico;
import com.desafio.foroHub.domain.topico.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements IValidadorDeTopicos {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosTopico datosTopico) {
        var topico = topicoRepository.findTopicoDuplicado(datosTopico.titulo(), datosTopico.mensaje());
        if (!topico.isEmpty()) {
            throw new ValidationException("El topico ya se encutra registrado");
        }
    }
}
