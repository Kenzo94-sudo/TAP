package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "servicio_adicional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioAdicional {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(
            nullable = false,
            length = 100
    )
    private String nombre;

    @Column(nullable = false,
            precision = 10,
            scale = 2 )
    private BigDecimal precio;

    @OneToMany(mappedBy = "servicio",
            cascade = CascadeType.ALL)
    private List<CumpleanoServicio> cumpleanos;
}