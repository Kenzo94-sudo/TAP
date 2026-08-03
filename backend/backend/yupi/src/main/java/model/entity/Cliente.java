package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    @OneToMany(mappedBy = "cliente")
    private List<Nino> ninos;
    private String nombres;
    private String apellidos;
    private String email;
    private LocalDateTime fecha_registro;
    private int telefono;
    private String direccion;
    @Column(unique = true)
    private Integer dni;
    @OneToMany(mappedBy = "cliente")
    private String acompañante;
    @OneToMany(mappedBy = "cliente")
    private List<Cumpleano> cumpleano;
    @OneToMany(mappedBy = "caja")
    private List<Caja> caja;
}