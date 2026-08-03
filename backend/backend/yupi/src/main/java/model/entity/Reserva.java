package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.EstadoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private LocalDate fecha_evento;

    private int cantidad_niños;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    private LocalTime hora_inicio;

    private LocalTime hora_fin;

    private BigDecimal monto_total;


}
