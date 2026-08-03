

import Playground.model.dto.Cumpleano.CumpleanoRequest;
import Playground.model.dto.Cumpleano.CumpleanoResponse;
import Playground.service.CumpleanoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cumpleanos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CumpleanoController {


    private final CumpleanoService cumpleanoService;



    // Registrar cumpleaños
    @PostMapping
    public ResponseEntity<CumpleanoResponse> registrar(
            @RequestBody CumpleanoRequest request
    ){

        CumpleanoResponse response =
                cumpleanoService.registrar(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }



    // Listar cumpleaños
    @GetMapping
    public ResponseEntity<List<CumpleanoResponse>> listar(){

        return ResponseEntity.ok(
                cumpleanoService.listar()
        );
    }



    // Buscar cumpleaños por ID
    @GetMapping("/{id}")
    public ResponseEntity<CumpleanoResponse> buscarPorId(
            @PathVariable Integer id
    ){

        return ResponseEntity.ok(
                cumpleanoService.buscarPorId(id)
        );
    }



    // Actualizar cumpleaños
    @PutMapping("/{id}")
    public ResponseEntity<CumpleanoResponse> actualizar(
            @PathVariable Integer id,
            @RequestBody CumpleanoRequest request
    ){

        return ResponseEntity.ok(
                cumpleanoService.actualizar(id, request)
        );
    }



    // Eliminar cumpleaños
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id
    ){

        cumpleanoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}