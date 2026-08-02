package repository;

import model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNinosId(Integer idNino);
    List<Cliente> findByCumpleanoId(Integer idCumpleano);

    boolean existsByEmail(String email);
}
