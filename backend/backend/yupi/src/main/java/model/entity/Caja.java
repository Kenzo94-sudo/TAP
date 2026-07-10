package model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "caja")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_caja;

    private BigDecimal cajaApertura;

    private BigDecimal cajaCierre;

    private LocalDateTime fecha;

    private BigDecimal totalIngresos;

    private BigDecimal totalEgresos;

    private BigDecimal saldoFinal;

    private LocalDateTime fechaHoraCierre;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Caja(Integer id_caja, Cliente cliente, LocalDateTime fechaHoraCierre, BigDecimal saldoFinal, BigDecimal totalEgresos, BigDecimal totalIngresos, LocalDateTime fecha, BigDecimal cajaCierre, BigDecimal cajaApertura) {
        this.id_caja = id_caja;
        this.cliente = cliente;
        this.fechaHoraCierre = fechaHoraCierre;
        this.saldoFinal = saldoFinal;
        this.totalEgresos = totalEgresos;
        this.totalIngresos = totalIngresos;
        this.fecha = fecha;
        this.cajaCierre = cajaCierre;
        this.cajaApertura = cajaApertura;
    }

    public Caja() {
    }

    public Integer getId_caja() {
        return id_caja;
    }

    public void setId_caja(Integer id_caja) {
        this.id_caja = id_caja;
    }

    public BigDecimal getCajaApertura() {
        return cajaApertura;
    }

    public void setCajaApertura(BigDecimal cajaApertura) {
        this.cajaApertura = cajaApertura;
    }

    public BigDecimal getCajaCierre() {
        return cajaCierre;
    }

    public void setCajaCierre(BigDecimal cajaCierre) {
        this.cajaCierre = cajaCierre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public BigDecimal getTotalEgresos() {
        return totalEgresos;
    }

    public void setTotalEgresos(BigDecimal totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public LocalDateTime getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(LocalDateTime fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
