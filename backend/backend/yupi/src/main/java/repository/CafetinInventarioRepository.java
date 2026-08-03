package repository;

import model.entity.CafetinInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafetinInventarioRepository extends JpaRepository<CafetinInventario, Integer> {
}
