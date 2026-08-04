package service;

import model.entity.CafetinInventario;
import model.entity.Enum.CategoriaProducto;

import java.util.List;
import java.util.Optional;

public interface CafetinService {

    Optional<CafetinInventario> registrarProductos(CafetinInventario cafetinProducto);
    CafetinInventario actualizarProducto(CafetinInventario actualizarProducto, String nombreProducto);
    void eliminarProducto(CafetinInventario eliminarProducto, String nombreProducto);
    List<CafetinInventario> listarProductos(CafetinInventario listarProductos);
    List<CafetinInventario> buscarPorCategoria(String categoria);
}
