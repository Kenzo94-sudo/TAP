package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.Categoria;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Rol(Integer id_rol, List<Usuario> usuarios, Categoria categoria) {
        this.id_rol = id_rol;
        this.usuarios = usuarios;
        this.categoria = categoria;
    }

    public Rol() {
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
