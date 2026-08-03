package model.mapper;

import model.dto.ServicioAdicional.ServicioAdicionalRequest;
import model.dto.ServicioAdicional.ServicioAdicionalResponse;
import model.entity.ServicioAdicional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicioAdicionalMapper {

    ServicioAdicional toEntity(ServicioAdicionalRequest servicioAdicionalRequest);

    ServicioAdicionalResponse toResponse(ServicioAdicional servicioAdicional);
}
