package repository;

import model.entity.Cumpleano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CumpleanoRepository extends JpaRepository<Cumpleano, Integer> {
    Cumpleano findByClienteId(Integer idCliente);
    Optional<Cumpleano> findByNombre(String nombreCliente);
    Optional<Cumpleano> findByFecha(LocalDate fechaEvento);
}
