package Playground.controller;

import Playground.model.dto.ServicioAdicional.ServicioAdicionalRequest;
import Playground.model.dto.ServicioAdicional.ServicioAdicionalResponse;
import Playground.service.ServicioAdicionalService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/servicios-adicionales")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ServicioAdicionalController {


    private final ServicioAdicionalService servicioService;


    // Registrar servicio adicional
    @PostMapping
    public ResponseEntity<ServicioAdicionalResponse> registrar(
            @RequestBody ServicioAdicionalRequest request
    ){

        ServicioAdicionalResponse response =
                servicioService.registrar(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }



    // Listar todos los servicios
    @GetMapping
    public ResponseEntity<List<ServicioAdicionalResponse>> listar(){

        return ResponseEntity.ok(
                servicioService.listar()
        );
    }



    // Listar servicios activos
    @GetMapping("/activos")
    public ResponseEntity<List<ServicioAdicionalResponse>> listarActivos(){

        return ResponseEntity.ok(
                servicioService.listarActivos()
        );
    }



    // Buscar servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<ServicioAdicionalResponse> buscarPorId(
            @PathVariable Integer id
    ){

        return ResponseEntity.ok(
                servicioService.buscarPorId(id)
        );
    }



    // Buscar por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<ServicioAdicionalResponse>> buscarPorNombre(
            @RequestParam String nombre
    ){

        return ResponseEntity.ok(
                servicioService.buscarPorNombre(nombre)
        );
    }



    // Actualizar servicio
    @PutMapping("/{id}")
    public ResponseEntity<ServicioAdicionalResponse> actualizar(
            @PathVariable Integer id,
            @RequestBody ServicioAdicionalRequest request
    ){

        return ResponseEntity.ok(
                servicioService.actualizar(id, request)
        );
    }



    // Eliminar servicio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id
    ){

        servicioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}