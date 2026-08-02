package model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "acompañante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Acompañante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_acompañante;
    private String nombre;
    private String apellidos;
    @Column(unique = true)
    private int dni;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}
