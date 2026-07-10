package model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "acompañante")
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


    public Acompañante(Integer id_acompañante, String nombre, String apellidos, int dni, Cliente cliente) {
        this.id_acompañante = id_acompañante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.cliente = cliente;
    }

    public Acompañante() {
    }

    public Integer getId_acompañante() {
        return id_acompañante;
    }

    public void setId_acompañante(Integer id_acompañante) {
        this.id_acompañante = id_acompañante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
