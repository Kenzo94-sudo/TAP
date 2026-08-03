package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagoEvento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagoEvento;

    @OneToOne
    @JoinColumn(name = "id_cotizacion", nullable = false, unique = true)
    private Cotizacion cotizacion;

    private BigDecimal monto;

    private LocalDate fecha_pago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

   
}
