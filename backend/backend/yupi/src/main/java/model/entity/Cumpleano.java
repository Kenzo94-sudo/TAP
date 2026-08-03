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
    // Cliente que reserva el cumpleaños
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_cliente",
            nullable = false)
    private Cliente cliente;
    @Column(name = "fecha_evento",
            nullable = false)
    private LocalDate fechaEvento;
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    @Column(name = "hora_fin")
    private LocalTime horaFin;
    @Column(name = "cantidad_ninos",
            nullable = false)
    private Integer cantidadNinos;
    @Column(name = "cantidad_adultos")
    private Integer cantidadAdultos;
    @Column(length = 500)
    private String observaciones;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCumpleano estado;
    @OneToMany(mappedBy = "cumpleano",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CumpleanoServicio> servicios;
}
