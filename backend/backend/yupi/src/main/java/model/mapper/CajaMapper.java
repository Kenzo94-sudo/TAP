package model.mapper;

import model.dto.Caja.CajaRequest;
import model.dto.Caja.CajaResponse;
import model.entity.Caja;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CajaMapper {

    Caja toEntity (CajaRequest cajaRequest);

    CajaResponse toResponse(Caja caja);
}
