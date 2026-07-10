package model.entity;

import jakarta.persistence.*;
import model.entity.Enum.Estado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_visita;

    @ManyToOne
    @JoinColumn(name = "id_nino")
    private Nino nino;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora_ingreso;

    @Column(nullable = false)
    private LocalTime hora_salida;

    @Column(nullable = false)
    private int tiempo_contratado;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "visita")
    private List<PagoVisita> pagoVisita;

    public Visita(Integer id_visita, Nino nino, Cliente cliente, LocalDate fecha, LocalTime hora_ingreso, LocalTime hora_salida, int tiempo_contratado, Estado estado, List<PagoVisita> pagoVisita) {
        this.id_visita = id_visita;
        this.nino = nino;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.tiempo_contratado = tiempo_contratado;
        this.estado = estado;
        this.pagoVisita = pagoVisita;
    }

    public Visita() {
    }

    public Integer getId_visita() {
        return id_visita;
    }

    public void setId_visita(Integer id_visita) {
        this.id_visita = id_visita;
    }

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
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

    public LocalTime getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(LocalTime hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getTiempo_contratado() {
        return tiempo_contratado;
    }

    public void setTiempo_contratado(int tiempo_contratado) {
        this.tiempo_contratado = tiempo_contratado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<PagoVisita> getPagoVisita() {
        return pagoVisita;
    }

    public void setPagoVisita(List<PagoVisita> pagoVisita) {
        this.pagoVisita = pagoVisita;
    }
}





