package model.dto.Cliente;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class ClienteResponse {

    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private LocalDateTime fecha_registro;
    private String observaciones;
}
