package Playground.model.mapper;

import Playground.model.dto.Cumpleano.CumpleanoServicioRequest;
import Playground.model.dto.Cumpleano.CumpleanoServicioResponse;
import Playground.model.entity.CumpleanoServicio;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CumpleanoServicioMapper {


    // Entity -> Response
    @Mapping(source = "cumpleano.idCumpleano",
            target = "idCumpleano")

    @Mapping(source = "servicio.idServicio",
            target = "idServicio")

    @Mapping(source = "servicio.nombre",
            target = "nombreServicio")

    CumpleanoServicioResponse toResponse(
            CumpleanoServicio entity
    );


    // Request -> Entity
    @Mapping(target = "idCumpleanoServicio",
            ignore = true)

    @Mapping(target = "cumpleano",
            ignore = true)

    @Mapping(target = "servicio",
            ignore = true)

    CumpleanoServicio toEntity(
            CumpleanoServicioRequest request
    );


    // Lista Entity -> Lista Response
    List<CumpleanoServicioResponse> toResponseList(
            List<CumpleanoServicio> lista
    );
}