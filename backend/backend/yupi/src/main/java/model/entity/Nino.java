package model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "nino")
public class Nino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nino;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private String nombre;

    private LocalDate fecha_nacimiento;

    private String alergias;

    public Nino(Integer id_nino, Cliente cliente, String nombre, LocalDate fecha_nacimiento, String alergias) {
        this.id_nino = id_nino;
        this.cliente = cliente;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.alergias = alergias;
    }

    public Nino() {
    }

    public Integer getId_nino() {
        return id_nino;
    }

    public void setId_nino(Integer id_nino) {
        this.id_nino = id_nino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
}
