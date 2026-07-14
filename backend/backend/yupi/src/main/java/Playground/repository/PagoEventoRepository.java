package Playground.repository;

import Playground.model.entity.PagoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoEventoRepository extends JpaRepository<PagoEvento, Integer> {
}
