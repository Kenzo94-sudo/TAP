package service;

import model.entity.Enum.MedioPago;
import model.entity.Enum.TipoPago;
import model.entity.Pago;

import java.util.List;

public interface PagoService {

    Pago registrarPagoVisita(Integer idVisita, MedioPago medioPago);
    Pago registrarPagoCumpleano( Integer idCumpleano, MedioPago medioPago);
    Pago registrarPagoVenta( Integer idVenta, MedioPago medioPago);
    List<Pago> listarPagos();
    Pago buscarPagoPorId(Integer id);
    List<Pago> listarPagosPorTipo(TipoPago tipoPago);

    void eliminarPago(Integer id);
