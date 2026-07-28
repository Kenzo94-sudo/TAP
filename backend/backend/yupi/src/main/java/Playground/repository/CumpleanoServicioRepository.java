package Playground.repository;

import Playground.model.entity.CumpleanoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CumpleanoServicioRepository
        extends JpaRepository<CumpleanoServicio, Integer> {


    // Obtener servicios asociados a un cumpleaños
    List<CumpleanoServicio> findByCumpleanoIdCumpleano(
            Integer idCumpleano
    );


    // Buscar si un servicio ya fue agregado a un cumpleaños
    boolean existsByCumpleanoIdCumpleanoAndServicioIdServicio(
            Integer idCumpleano,
            Integer idServicio
    );


    // Eliminar un servicio específico de un cumpleaños
    void deleteByCumpleanoIdCumpleanoAndServicioIdServicio(
            Integer idCumpleano,
            Integer idServicio
    );

}