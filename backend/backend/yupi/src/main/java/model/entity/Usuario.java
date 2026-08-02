package model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer id_usuario;

    private String nombres;
    private String apellidos;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_rol",
            referencedColumnName = "id_rol",
    nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


}
