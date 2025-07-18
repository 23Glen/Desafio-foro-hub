package com.desafio.foroHub.domain.curso.repository;

import com.desafio.foroHub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
