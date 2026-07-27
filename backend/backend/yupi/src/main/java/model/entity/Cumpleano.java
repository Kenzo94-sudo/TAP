package model.entity;

import jakarta.persistence.*;
import lombok.*;
import model.entity.Enum.EstadoCumpleano;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "cumpleano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cumpleano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cumpleano")
    private Integer idCumpleano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDate fechaEvento;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "cantidad_ninos", nullable = false)
    private Integer cantidadNinos;

    @Column(name = "cantidad_adultos")
    private Integer cantidadAdultos;

    @Column(name = "observaciones")
    private String observaciones;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCumpleano estado;

    @ManyToMany
    @JoinTable(
            name = "cumpleano_servicio",
            joinColumns = @JoinColumn(name = "id_cumpleano"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<ServicioAdicional> servicios;
}
