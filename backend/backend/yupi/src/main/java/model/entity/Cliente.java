package model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    @OneToMany(mappedBy = "cliente")
    private List<Nino> ninos;
    private String nombre;
    private String apellidos;
    private String email;
    private LocalDateTime fecha_registro;
    private int telefono;
    private String direccion;
    @Column(unique = true)
    private Integer dni;
    private String observaciones;
    @OneToMany(mappedBy = "cliente")
    private String acompañante;
    @OneToMany(mappedBy = "cliente")
    private List<Cumpleano> cumpleanos;
    @OneToMany(mappedBy = "cliente")
    private List<Cotizacion> cotizacion;

}
