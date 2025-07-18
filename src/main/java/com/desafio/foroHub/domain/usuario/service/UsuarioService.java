package com.desafio.foroHub.domain.usuario.service;

import com.desafio.foroHub.domain.usuario.Usuario;
import com.desafio.foroHub.domain.usuario.dto.DatosActualizarUsuario;
import com.desafio.foroHub.domain.usuario.dto.DatosListarUsuario;
import com.desafio.foroHub.domain.usuario.dto.DatosUsuario;
import com.desafio.foroHub.domain.usuario.repository.UsuarioRepository;
import com.desafio.foroHub.domain.usuario.validation.IValidadorDeUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    List<IValidadorDeUsuarios> validadorDeUsuarios;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public DatosListarUsuario registrar(DatosUsuario datosUsuario) {
        validadorDeUsuarios.forEach(v -> v.validar(datosUsuario));
        Usuario usuario = new Usuario(datosUsuario, passwordEncoder);
        usuarioRepository.save(usuario);
        return new DatosListarUsuario(usuario);
    }

    public DatosListarUsuario actualizar(DatosActualizarUsuario datosActualizarUsuario) {
        validadorDeUsuarios.forEach(v -> v.validar(new DatosUsuario(datosActualizarUsuario)));
        var usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarUsuario(datosActualizarUsuario, passwordEncoder);
        return new DatosListarUsuario(usuario);
    }
}
