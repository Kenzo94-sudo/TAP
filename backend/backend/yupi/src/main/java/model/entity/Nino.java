package model.entity;

import jakarta.persistence.*;
import kotlin.Lazy;
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
    private String apellidos;
    private int edad;
    private LocalDate fecha_nacimiento;
    private String alergias;
    private String observaciones;


}
