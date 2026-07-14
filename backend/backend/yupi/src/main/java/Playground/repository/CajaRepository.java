package Playground.repository;

import Playground.model.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajaRepository extends JpaRepository<Caja, Integer> {
}
