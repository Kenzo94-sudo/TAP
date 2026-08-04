package repository;

import model.entity.CafetinInventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CafetinInventarioRepository extends JpaRepository<CafetinInventario, Integer> {
    Optional<CafetinInventario> findByNombreProducto(String nombreProducto);

    List<CafetinInventario> findByCategoria(String categoria);
}
