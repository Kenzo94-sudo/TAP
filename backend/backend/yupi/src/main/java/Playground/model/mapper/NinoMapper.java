package Playground.model.mapper;


import Playground.model.dto.Nino.NinoRequest;
import Playground.model.dto.Nino.NinoResponse;
import Playground.model.entity.Nino;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NinoMapper {

    @Mapping(target = "cliente", ignore = true)
    Nino toEntity(NinoRequest request);

    @Mapping(source = "cliente.idCliente", target = "idCliente")
    @Mapping(target = "edad", ignore = true)
    NinoResponse toResponse(Nino nino);

}