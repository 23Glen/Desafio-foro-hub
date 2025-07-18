package com.desafio.foroHub.domain.respuesta.validation;

import com.desafio.foroHub.domain.respuesta.dto.DatosRespuesta;
import com.desafio.foroHub.domain.usuario.repository.UsuarioRepository;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuario implements IValidadorDeRespuestas {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!usuarioRepository.findById(datosRespuesta.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encotrado");
        }
    }
}
