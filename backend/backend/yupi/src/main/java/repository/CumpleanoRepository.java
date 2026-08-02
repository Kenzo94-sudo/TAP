package repository;

import model.dto.cumpleanos.CumpleanoResponse;
import model.entity.Cumpleano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CumpleanoRepository extends JpaRepository<Cumpleano, Integer> {
    Cumpleano save(Cumpleano cumpleano);
    Cumpleano findByClienteId(Integer idCliente);

    CumpleanoResponse toResponse(Cumpleano cumpleano);
}
