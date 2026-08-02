package model.mapper;

import model.dto.Nino.NinoRequest;
import model.dto.Nino.NinoResponse;
import model.entity.Nino;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NinoMapper {

    Nino toEntity(NinoRequest ninoRequest);
    NinoResponse toResponse(Nino nino);
    void updateEntityFromRequest(NinoRequest ninoRequest, @MappingTarget Nino nino);
}
