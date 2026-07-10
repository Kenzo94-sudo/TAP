package repository;

import model.entity.Nino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinoRepository extends JpaRepository<Nino, Integer> {
}
