package com.desafio.foroHub.domain.usuario.repository;

import com.desafio.foroHub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByCorreo(String username);

    Boolean existsByCorreo(String correo);
}
