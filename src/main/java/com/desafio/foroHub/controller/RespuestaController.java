package com.desafio.foroHub.controller;

import com.desafio.foroHub.domain.respuesta.*;
import com.desafio.foroHub.domain.respuesta.dto.DatosActualizarRespuesta;
import com.desafio.foroHub.domain.respuesta.dto.DatosListarRespuesta;
import com.desafio.foroHub.domain.respuesta.dto.DatosRespuesta;
import com.desafio.foroHub.domain.respuesta.repository.RespuestaRepository;
import com.desafio.foroHub.domain.respuesta.service.RespuestaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Respuestas")
@RestController
@ResponseBody
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;
    @Autowired
    RespuestaRepository respuestaRepository;

    @Operation(summary = "Crea una respuesta.")
    @PostMapping
    @Transactional
    public ResponseEntity registrarRespuesta(@RequestBody @Valid DatosRespuesta datosRespuesta) {
        var respuesta = respuestaService.registrar(datosRespuesta);
        return ResponseEntity.ok(respuesta);
    }

    @Operation(summary = "Lista todas las respuestas.")
    @GetMapping
    public ResponseEntity<Page<DatosListarRespuesta>> listarRespuestas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(respuestaRepository.findAll(pageable).map(DatosListarRespuesta::new));
    }

    @Operation(summary = "Actualiza una respuesta.")
    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        var respuesta = respuestaService.actualizar(datosActualizarRespuesta);
        return ResponseEntity.ok(respuesta);
    }

    @Operation(summary = "Elimina una respuesta.")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        respuestaService.validarRespuesta(id);
        respuestaRepository.deleteById(respuestaRepository.getReferenceById(id).getId());
        return ResponseEntity.noContent().build();
    }
}
