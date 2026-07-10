package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "pagoVisita")
public class PagoVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagoVisita;

    @ManyToOne
    @JoinColumn(name = "id_visita", nullable = false)
    private Visita visita;

    private BigDecimal monto;

    private LocalTime fecha_pago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    public PagoVisita(Integer id_pagoVisita, Visita visita, BigDecimal monto, LocalTime fecha_pago, MetodoPago metodoPago) {
        this.id_pagoVisita = id_pagoVisita;
        this.visita = visita;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.metodoPago = metodoPago;
    }

    public PagoVisita() {
    }

    public Integer getId_pagoVisita() {
        return id_pagoVisita;
    }

    public void setId_pagoVisita(Integer id_pagoVisita) {
        this.id_pagoVisita = id_pagoVisita;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
