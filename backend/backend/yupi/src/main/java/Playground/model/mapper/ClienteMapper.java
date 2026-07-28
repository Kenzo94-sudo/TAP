package Playground.model.mapper;




import Playground.model.dto.Cliente.ClienteRequest;
import Playground.model.dto.Cliente.ClienteResponse;
import Playground.model.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequest request);

    ClienteResponse toResponse(Cliente cliente);

}