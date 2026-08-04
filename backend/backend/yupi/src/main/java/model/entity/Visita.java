package model.entity;

import jakarta.persistence.*;
import lombok.*;
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
    private Cliente cliente;

    @OneToOne
    private Pago pago;
}





