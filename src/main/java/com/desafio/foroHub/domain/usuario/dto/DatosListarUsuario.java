package com.desafio.foroHub.domain.usuario.dto;

import com.desafio.foroHub.domain.usuario.Rol;
import com.desafio.foroHub.domain.usuario.Usuario;

public record DatosListarUsuario(
        String nombre,
        String correo,
        Rol rol) {

    public DatosListarUsuario(Usuario usuario) {
        this(
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }
}
