package model.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cumpleano_servicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CumpleanoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cumpleano_servicio")
    private Integer idCumpleanoServicio;
    // Relación con cumpleaños
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cumpleano",
            nullable = false)
    private Cumpleano cumpleano;
    // Relación con servicio adicional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio",
            nullable = false)
    private ServicioAdicional servicio;
}