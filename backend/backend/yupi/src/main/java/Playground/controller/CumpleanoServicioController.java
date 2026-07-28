package Playground.controller;

import Playground.model.dto.Cumpleano.CumpleanoServicioRequest;
import Playground.model.dto.Cumpleano.CumpleanoServicioResponse;
import Playground.service.CumpleanoServicioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cumpleano-servicios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CumpleanoServicioController {


    private final CumpleanoServicioService service;



    // Registrar servicio adicional en un cumpleaños
    @PostMapping
    public ResponseEntity<CumpleanoServicioResponse> registrar(
            @RequestBody CumpleanoServicioRequest request
    ){

        CumpleanoServicioResponse response =
                service.registrar(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }



    // Listar servicios de un cumpleaños específico
    @GetMapping("/cumpleano/{idCumpleano}")
    public ResponseEntity<List<CumpleanoServicioResponse>> listarPorCumpleano(
            @PathVariable Integer idCumpleano
    ){

        return ResponseEntity.ok(
                service.listarPorCumpleano(idCumpleano)
        );
    }



    // Buscar servicio asignado por ID
    @GetMapping("/{id}")
    public ResponseEntity<CumpleanoServicioResponse> buscarPorId(
            @PathVariable Integer id
    ){

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }



    // Actualizar cantidad o precio aplicado
    @PutMapping("/{id}")
    public ResponseEntity<CumpleanoServicioResponse> actualizar(
            @PathVariable Integer id,
            @RequestBody CumpleanoServicioRequest request
    ){

        return ResponseEntity.ok(
                service.actualizar(id, request)
        );
    }



    // Eliminar servicio de un cumpleaños
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id
    ){

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}