package model.mapper;

import model.dto.Cliente.ClienteRequest;
import model.dto.Cliente.ClienteResponse;
import model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    Cliente toEntity(ClienteRequest clienteRequest);

    ClienteResponse toResponse(Cliente cliente);

    void updateEntityFromRequest(ClienteRequest request, @MappingTarget Cliente cliente);
}
