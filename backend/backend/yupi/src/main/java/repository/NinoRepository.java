package repository;

import model.entity.Nino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NinoRepository extends JpaRepository<Nino, Integer> {

    List<Nino> findByClienteId(Integer id);
    List<Nino> findByCumpleanoId(Integer id);
}
