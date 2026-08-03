package model.mapper;


import model.dto.CumpleanoServicio.CumpleanoServicioRequest;
import model.dto.CumpleanoServicio.CumpleanoServicioResponse;
import model.entity.CumpleanoServicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CumpleanoServicioMapper {

    CumpleanoServicio toEntity(CumpleanoServicioRequest cumpleanoServicioRequest);

    CumpleanoServicioResponse toResponse(CumpleanoServicio cumpleanoServicio);
}
