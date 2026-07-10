package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.EstadoCotizacion;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cotizacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private LocalDate fecha;

    private BigDecimal monto_total;

    @Enumerated(EnumType.STRING)
    private EstadoCotizacion estadoCotizado;

    @OneToOne(mappedBy = "cotizacion")
    private PagoEvento pagoEvento;

    public Cotizacion(Integer id_cotizacion, Cliente cliente, LocalDate fecha, BigDecimal monto_total, EstadoCotizacion estadoCotizado, PagoEvento pagoEvento) {
        this.id_cotizacion = id_cotizacion;
        this.cliente = cliente;
        this.fecha = fecha;
        this.monto_total = monto_total;
        this.estadoCotizado = estadoCotizado;
        this.pagoEvento = pagoEvento;
    }

    public Cotizacion() {
    }

    public Integer getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(Integer id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(BigDecimal monto_total) {
        this.monto_total = monto_total;
    }

    public EstadoCotizacion getEstadoCotizado() {
        return estadoCotizado;
    }

    public void setEstadoCotizado(EstadoCotizacion estadoCotizado) {
        this.estadoCotizado = estadoCotizado;
    }

    public PagoEvento getPagoEvento() {
        return pagoEvento;
    }

    public void setPagoEvento(PagoEvento pagoEvento) {
        this.pagoEvento = pagoEvento;
    }
}
