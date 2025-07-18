package com.desafio.foroHub.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record AutenticarUsuario(
        @NotBlank String correo,
        @NotBlank String contrasena
) {
}
