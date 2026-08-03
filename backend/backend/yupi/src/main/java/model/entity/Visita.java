package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.Estado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "visita")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_visita;

    @ManyToOne
    @JoinColumn(name = "id_nino")
    private Nino nino;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora_ingreso;

    @Column(nullable = false)
    private LocalTime hora_salida;

    @Column(nullable = false)
    private int tiempo_contratado;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "visita")
    private List<PagoVisita> pagoVisita;

}





