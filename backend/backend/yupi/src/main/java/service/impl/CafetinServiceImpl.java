package service.impl;

import model.entity.CafetinInventario;
import org.springframework.stereotype.Service;
import repository.CafetinInventarioRepository;
import service.CafetinService;

import java.util.List;
import java.util.Optional;
@Service
public class CafetinServiceImpl implements CafetinService {

        private CafetinInventarioRepository cafetinInventarioRepository;

    public CafetinServiceImpl(CafetinInventarioRepository cafetinInventarioRepository) {
        this.cafetinInventarioRepository = cafetinInventarioRepository;
    }

    @Override
    public Optional<CafetinInventario> registrarProductos(CafetinInventario cafetinProducto) {
        if (cafetinProducto == null || cafetinProducto.getNombreProducto().toString().isEmpty() || cafetinProducto.getCategoria().toString().isEmpty() ) {
            throw new NullPointerException("Existen campos obligatorios sin completar. Por favor, ingrese la información requerida");
        }
        CafetinInventario cafetinProductos = cafetinInventarioRepository.save(cafetinProducto);
        return Optional.ofNullable(cafetinProductos);
    }

    @Override
    public CafetinInventario actualizarProducto(CafetinInventario actualizarProducto, String nombreProducto) {

        if( actualizarProducto == null ) {
            throw new IllegalArgumentException("LOS DATOS DEL PRODUCTO SON OBLIGATORIOS");
        }
        CafetinInventario producto = cafetinInventarioRepository.findByNombreProducto(nombreProducto)
                .orElseThrow (() -> new IllegalArgumentException("NO SE ENCUENTRO EL PRODUCTO:" + nombreProducto));

        producto.setNombreProducto(actualizarProducto.getNombreProducto());
        producto.setCantidadProducto(actualizarProducto.getCantidadProducto());
        producto.setPrecio(actualizarProducto.getPrecio());
        producto.setCategoria(actualizarProducto.getCategoria());

        return cafetinInventarioRepository.save(producto);
    }

    @Override
    public void eliminarProducto(CafetinInventario eliminarProducto, String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()){
            throw new IllegalArgumentException("EL NOMBRE DEL PRODUCTO ES OBLIGATOTRIO");
        }
        CafetinInventario eliminarProductoCafetin = cafetinInventarioRepository.findByNombreProducto(nombreProducto)
                .orElseThrow(() -> new IllegalArgumentException("NO SE ENCONTRO EL PRODUCTO"
                 + nombreProducto));
         cafetinInventarioRepository.delete(eliminarProductoCafetin);

    }

    @Override
    public List<CafetinInventario> listarProductos(CafetinInventario listarProductos) {
        List<CafetinInventario> listar = cafetinInventarioRepository.findAll();
        if ( listarProductos == null) {
            throw new IllegalArgumentException("NO EXISTEN PRODUCTOS REGISTRADOS");
        }
        return listar;
    }

    @Override
    public List<CafetinInventario> buscarPorCategoria(String categoria) {
        if(categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("LA CATEGORIA ES OBLIGARORIA");
        }
        List<CafetinInventario> productoCategoria = cafetinInventarioRepository.findByCategoria(categoria);
        if( productoCategoria.isEmpty()) {
            throw new IllegalArgumentException("No existen productos para la categoria");
        }

        return productoCategoria ;
    }
}
