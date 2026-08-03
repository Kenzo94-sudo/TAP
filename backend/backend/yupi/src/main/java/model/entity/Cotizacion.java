package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.EstadoCotizacion;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cotizacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cotizacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private LocalDate fecha;

    private BigDecimal monto_total;

    @Enumerated(EnumType.STRING)
    private EstadoCotizacion estadoCotizado;

    @OneToOne(mappedBy = "cotizacion")
    private PagoEvento pagoEvento;

}
