package Playground.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, length = 80)
    private String nombres;

    @Column(nullable = false, length = 80)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(length = 9)
    private String celular;

    @Column(length = 100)
    private String correo;

    @Column(length = 150)
    private String direccion;

    @Column(length = 80)
    private String distrito;

    @Column(length = 1)
    private String genero;

    @Column(length = 250)
    private String observacion;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<Nino> ninos = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

}