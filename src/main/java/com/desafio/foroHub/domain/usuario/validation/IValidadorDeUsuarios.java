package com.desafio.foroHub.domain.usuario.validation;

import com.desafio.foroHub.domain.usuario.dto.DatosUsuario;

public interface IValidadorDeUsuarios {
    void validar(DatosUsuario datosUsuario);
}
