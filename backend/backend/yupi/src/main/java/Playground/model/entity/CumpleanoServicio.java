package Playground.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cumpleanio_servicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cumpleanio_servicio")
    private Integer idCumpleanoServicio;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_cumpleano",
            nullable = false
    )
    private Cumpleano cumpleano;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_servicio",
            nullable = false
    )
    private ServicioAdicional servicio;


    @Column(nullable = false)
    private Integer cantidad = 1;


    @Column(name = "precio_aplicado")
    private BigDecimal precioAplicado;

}