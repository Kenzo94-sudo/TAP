package model.mapper;

import model.dto.Acompañante.AcompañanteRequest;
import model.dto.Acompañante.AcompañanteResponse;
import model.entity.Acompañante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper ( componentModel = "spring")
public interface AcompañanteMapper {

    Acompañante toEntity(AcompañanteRequest acompañanteRequest);

    @Mapping(source = "cliente.nombres", target = "nombreCliente")
    AcompañanteResponse toResponse(Acompañante acompañante);
}
