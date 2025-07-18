package com.desafio.foroHub.domain.curso.dto;

import com.desafio.foroHub.domain.curso.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso (
        @NotBlank String nombre,
        @NotNull Categoria categoria){
}
