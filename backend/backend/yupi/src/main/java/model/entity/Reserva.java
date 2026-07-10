package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.EstadoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private LocalDate fecha_evento;

    private int cantidad_niños;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    private LocalTime hora_inicio;

    private LocalTime hora_fin;

    private BigDecimal monto_total;


    public Reserva(Integer id_reserva, Cliente cliente, LocalDate fecha_evento, int cantidad_niños, EstadoReserva estadoReserva, LocalTime hora_inicio, LocalTime hora_fin, BigDecimal monto_total) {
        this.id_reserva = id_reserva;
        this.cliente = cliente;
        this.fecha_evento = fecha_evento;
        this.cantidad_niños = cantidad_niños;
        this.estadoReserva = estadoReserva;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.monto_total = monto_total;
    }

    public Reserva() {
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(LocalDate fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public int getCantidad_niños() {
        return cantidad_niños;
    }

    public void setCantidad_niños(int cantidad_niños) {
        this.cantidad_niños = cantidad_niños;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public BigDecimal getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(BigDecimal monto_total) {
        this.monto_total = monto_total;
    }
}
