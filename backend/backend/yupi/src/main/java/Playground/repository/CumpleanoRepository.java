package Playground.repository;

import Playground.model.entity.Cumpleano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CumpleanoRepository extends JpaRepository<Cumpleano, Integer> {

    // Buscar cumpleaños por cliente
    List<Cumpleano> findByClienteIdCliente(Integer idCliente);


    // Buscar cumpleaños por fecha
    List<Cumpleano> findByFechaEvento(LocalDate fechaEvento);


    // Buscar por estado
    List<Cumpleano> findByEstado(String estado);


    // Validar disponibilidad de fecha y horario
    List<Cumpleano> findByFechaEventoAndHoraInicioBetween(
            LocalDate fechaEvento,
            java.time.LocalTime horaInicio,
            java.time.LocalTime horaFin
    );

}