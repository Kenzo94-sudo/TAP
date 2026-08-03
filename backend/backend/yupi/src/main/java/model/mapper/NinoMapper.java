package model.mapper;

import model.dto.Nino.NinoRequest;
import model.dto.Nino.NinoResponse;
import model.entity.Nino;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NinoMapper {

    Nino toEntity(NinoRequest ninoRequest);
    @Mapping( source="cliente.nombres", target="nombreCliente")
    NinoResponse toResponse(Nino nino);
}
