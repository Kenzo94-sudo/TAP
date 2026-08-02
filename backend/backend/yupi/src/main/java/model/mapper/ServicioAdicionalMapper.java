package model.mapper;

import model.dto.ServicioAdicional.ServicioAdicionalRequest;
import model.dto.ServicioAdicional.ServicioAdicionalResponse;
import model.entity.ServicioAdicional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioAdicionalMapper {

    @Mapping(target = "cumpleanos" , source = "ServicioAdicional.idCumpleano")
    ServicioAdicional toEntity(ServicioAdicionalRequest servicioAdicionalRequest);

    ServicioAdicionalResponse toResponse(ServicioAdicional servicioAdicional);
}
