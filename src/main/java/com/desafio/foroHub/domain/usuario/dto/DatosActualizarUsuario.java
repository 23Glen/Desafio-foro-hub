package com.desafio.foroHub.domain.usuario.dto;

import com.desafio.foroHub.domain.usuario.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank @Email String correo,
        @NotBlank String contrasena,
        @NotNull Rol rol
) {
}
