package repository;

import model.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CajaRepository extends JpaRepository<Caja, Integer> {

    @Query("SELECT c FROM Caja c WHERE FUNCTION('DATE', c.fecha) = :dia")
    Optional<Caja> findByDia();
    Optional<Caja> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}
