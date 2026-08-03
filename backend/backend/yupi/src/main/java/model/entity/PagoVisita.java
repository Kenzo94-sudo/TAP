package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "pagoVisita")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagoVisita;

    @ManyToOne
    @JoinColumn(name = "id_visita", nullable = false)
    private Visita visita;

    private BigDecimal monto;

    private LocalTime fecha_pago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

}
