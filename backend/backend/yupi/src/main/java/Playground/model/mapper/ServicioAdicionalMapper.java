package Playground.model.mapper;

import Playground.model.dto.ServicioAdicional.ServicioAdicionalRequest;
import Playground.model.dto.ServicioAdicional.ServicioAdicionalResponse;
import Playground.model.entity.ServicioAdicional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioAdicionalMapper {


    // Entity -> Response
    ServicioAdicionalResponse toResponse(
            ServicioAdicional servicio
    );


    // Request -> Entity
    @Mapping(
            target = "idServicio",
            ignore = true
    )
    @Mapping(
            target = "cumpleanos",
            ignore = true
    )
    ServicioAdicional toEntity(
            ServicioAdicionalRequest request
    );


    // Lista Entity -> Lista Response
    List<ServicioAdicionalResponse> toResponseList(
            List<ServicioAdicional> servicios
    );

}