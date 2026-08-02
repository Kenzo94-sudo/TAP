package model.mapper;

import model.dto.Acompañante.AcompañanteRequest;
import model.dto.Acompañante.AcompañanteResponse;
import model.entity.Acompañante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcompañanteMapper {

    Acompañante toEntity(AcompañanteRequest acompañanteRequest);
    AcompañanteResponse toResponse(Acompañante acompañante);
}
