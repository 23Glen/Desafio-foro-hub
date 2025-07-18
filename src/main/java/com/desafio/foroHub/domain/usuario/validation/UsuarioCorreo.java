package com.desafio.foroHub.domain.usuario.validation;

import com.desafio.foroHub.domain.usuario.dto.DatosUsuario;
import com.desafio.foroHub.domain.usuario.repository.UsuarioRepository;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCorreo implements IValidadorDeUsuarios {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void validar(DatosUsuario datosUsuario) {
        var usuario = usuarioRepository.existsByCorreo(datosUsuario.correo());
        if (usuario) {
            throw new ValidacionDeIntegridad("Correo ya registrado");
        }
    }
}
