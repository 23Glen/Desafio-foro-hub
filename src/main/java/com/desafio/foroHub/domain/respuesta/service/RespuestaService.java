package com.desafio.foroHub.domain.respuesta.service;

import com.desafio.foroHub.domain.respuesta.Respuesta;
import com.desafio.foroHub.domain.respuesta.dto.DatosActualizarRespuesta;
import com.desafio.foroHub.domain.respuesta.dto.DatosListarRespuesta;
import com.desafio.foroHub.domain.respuesta.dto.DatosRespuesta;
import com.desafio.foroHub.domain.respuesta.repository.RespuestaRepository;
import com.desafio.foroHub.domain.respuesta.validation.IValidadorDeRespuestas;
import com.desafio.foroHub.domain.topico.Topico;
import com.desafio.foroHub.domain.topico.repository.TopicoRepository;
import com.desafio.foroHub.domain.usuario.Usuario;
import com.desafio.foroHub.domain.usuario.repository.UsuarioRepository;
import com.desafio.foroHub.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RespuestaRepository respuestaRepository;
    @Autowired
    List<IValidadorDeRespuestas> iValidadorDeRespuestas;


    public DatosListarRespuesta registrar(DatosRespuesta datosRespuesta) {
        iValidadorDeRespuestas.forEach(v -> v.validar(datosRespuesta));
        Topico topico = topicoRepository.findById(datosRespuesta.idTopico()).get();
        Usuario usuario = usuarioRepository.findById(datosRespuesta.idUsuario()).get();
        Respuesta respuesta = new Respuesta(
                datosRespuesta.mensaje(),
                topico,
                usuario);
        respuestaRepository.save(respuesta);
        return new DatosListarRespuesta(respuesta);
    }

    public void validarRespuesta(Long id) {
        if (!respuestaRepository.findById(id).isPresent()) {
            throw new ValidacionDeIntegridad("Respuesta no encontrada");
        }
    }

    public DatosListarRespuesta actualizar(DatosActualizarRespuesta datosActualizarRespuesta) {
        validarRespuesta(datosActualizarRespuesta.id());
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.setMensaje(datosActualizarRespuesta.mensaje());
        return new DatosListarRespuesta(respuesta);
    }
}
