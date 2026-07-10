package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagoEvento")
public class PagoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagoEvento;

    @OneToOne
    @JoinColumn(name = "id_cotizacion", nullable = false, unique = true)
    private Cotizacion cotizacion;

    private BigDecimal monto;

    private LocalDate fecha_pago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    public PagoEvento(Integer id_pagoEvento, Cotizacion cotizacion, BigDecimal monto, LocalDate fecha_pago, MetodoPago metodoPago) {
        this.id_pagoEvento = id_pagoEvento;
        this.cotizacion = cotizacion;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.metodoPago = metodoPago;
    }

    public PagoEvento() {
    }

    public Integer getId_pagoEvento() {
        return id_pagoEvento;
    }

    public void setId_pagoEvento(Integer id_pagoEvento) {
        this.id_pagoEvento = id_pagoEvento;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
