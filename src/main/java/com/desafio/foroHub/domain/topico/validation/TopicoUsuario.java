package com.desafio.foroHub.domain.topico.validation;

import com.desafio.foroHub.domain.topico.dto.DatosTopico;
import com.desafio.foroHub.domain.usuario.repository.UsuarioRepository;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoUsuario implements IValidadorDeTopicos {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DatosTopico datosTopico){
        if (!usuarioRepository.findById(datosTopico.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }
    }
}
