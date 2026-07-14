package Playground.controller;


import Playground.model.dto.Nino.NinoRequest;
import Playground.model.dto.Nino.NinoResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Playground.service.NinoService;

import java.util.List;

@RestController
@RequestMapping("/api/ninos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class NinoController {

    private final NinoService ninoService;

    @GetMapping
    public ResponseEntity<List<NinoResponse>> listar() {

        return ResponseEntity.ok(
                ninoService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<NinoResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ninoService.obtenerPorId(id));

    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<NinoResponse>> listarPorCliente(
            @PathVariable Long idCliente) {

        return ResponseEntity.ok(
                ninoService.listarPorCliente(idCliente));

    }

    @PostMapping
    public ResponseEntity<NinoResponse> registrar(
            @RequestBody NinoRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ninoService.registrar(request));

    }

    @PutMapping("/{id}")
    public ResponseEntity<NinoResponse> actualizar(
            @PathVariable Long id,
            @RequestBody NinoRequest request) {

        return ResponseEntity.ok(
                ninoService.actualizar(id, request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        ninoService.eliminar(id);

        return ResponseEntity.noContent().build();

    }

}