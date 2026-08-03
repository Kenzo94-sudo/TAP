package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "caja")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_caja;
    private BigDecimal cajaApertura;
    private BigDecimal cajaCierre;
    private LocalDateTime fecha;
    private BigDecimal totalIngresos;
    private BigDecimal totalEgresos;
    private BigDecimal saldoFinal;
    private LocalDateTime fechaHoraCierre;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
