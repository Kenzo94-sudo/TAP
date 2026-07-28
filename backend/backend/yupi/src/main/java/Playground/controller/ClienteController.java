package Playground.controller;

import Playground.model.dto.Cliente.ClienteRequest;
import Playground.model.dto.Cliente.ClienteResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Playground.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {

        return ResponseEntity.ok(clienteService.listar());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(clienteService.obtenerPorId(id));

    }

    @PostMapping
    public ResponseEntity<ClienteResponse> registrar(
            @RequestBody ClienteRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteService.registrar(request));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizar(
            @PathVariable Long id,
            @RequestBody ClienteRequest request) {

        return ResponseEntity.ok(
                clienteService.actualizar(id, request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        clienteService.eliminar(id);

        return ResponseEntity.noContent().build();

    }

}