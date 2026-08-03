package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "nino")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nino;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private int edad;
    private String alergias;
}
