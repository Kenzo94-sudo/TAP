package Playground.repository;



import Playground.model.entity.Nino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinoRepository extends JpaRepository<Nino, Long> {

    List<Nino> findByClienteIdCliente(Long idCliente);

}