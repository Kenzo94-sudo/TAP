package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.Categoria;

import java.util.List;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

   
}
