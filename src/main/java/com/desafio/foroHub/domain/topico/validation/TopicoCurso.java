package com.desafio.foroHub.domain.topico.validation;

import com.desafio.foroHub.domain.curso.repository.CursoRepository;
import com.desafio.foroHub.domain.topico.dto.DatosTopico;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoCurso implements IValidadorDeTopicos{
    @Autowired
    CursoRepository cursoRepository;

    public void validar(DatosTopico datosTopico) {
        if (!cursoRepository.findById(datosTopico.idCurso()).isPresent()) {
            throw new ValidacionDeIntegridad("Curso no encontrado");
        }
    }
}
