package Playground.repository;

import Playground.model.entity.ServicioAdicional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioAdicionalRepository
        extends JpaRepository<ServicioAdicional, Integer> {


    // Buscar servicios activos
    List<ServicioAdicional> findByEstadoTrue();


    // Buscar servicios por nombre
    List<ServicioAdicional> findByNombreContainingIgnoreCase(
            String nombre
    );


    // Validar nombre duplicado
    boolean existsByNombreIgnoreCase(
            String nombre
    );

    List<ServicioAdicional> findAllById(List<String> servicios);
}