package model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente")
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

    @OneToMany(mappedBy = "cliente")
    private String acompañante;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reserva;

    @OneToMany(mappedBy = "cliente")
    private List<Cotizacion> cotizacion;

    @OneToMany(mappedBy = "caja")
    private List<Caja> caja;

    public Cliente(Integer id_cliente, List<Nino> ninos, String nombre, String apellidos, String email, LocalDateTime fecha_registro, int telefono, String direccion, Integer dni, String acompañante, List<Reserva> reserva, List<Cotizacion> cotizacion, List<Caja> caja) {
        this.id_cliente = id_cliente;
        this.ninos = ninos;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.acompañante = acompañante;
        this.reserva = reserva;
        this.cotizacion = cotizacion;
        this.caja = caja;
    }

    public Cliente() {
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Nino> getNinos() {
        return ninos;
    }

    public void setNinos(List<Nino> ninos) {
        this.ninos = ninos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getAcompañante() {
        return acompañante;
    }

    public void setAcompañante(String acompañante) {
        this.acompañante = acompañante;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public List<Cotizacion> getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(List<Cotizacion> cotizacion) {
        this.cotizacion = cotizacion;
    }

    public List<Caja> getCaja() {
        return caja;
    }

    public void setCaja(List<Caja> caja) {
        this.caja = caja;
    }
}
