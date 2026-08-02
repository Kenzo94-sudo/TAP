package model.mapper;

import model.dto.cumpleanos.CumpleanoRequest;
import model.dto.cumpleanos.CumpleanoResponse;
import model.entity.Cumpleano;
import model.entity.ServicioAdicional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CumpleanoMapper {

    Cumpleano toEntity(CumpleanoRequest cumpleanoRequest);

    @Mapping(target = "servicios", source = "ServicioAdcional.id_servicio")
    CumpleanoResponse toResponse(Cumpleano cumpleano);

}