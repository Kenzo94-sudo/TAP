package model.mapper;

import model.dto.Cumpleano.CumpleanoRequest;
import model.dto.Cumpleano.CumpleanoResponse;
import model.entity.Cumpleano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CumpleanoMapper {

    @Mapping( source = "cliente.nombres", target = "nombreCliente")
    Cumpleano toEntity(CumpleanoRequest cumpleanoRequest);

    @Mapping( source = "cliente.nombres", target="nombreCliente")
    @Mapping( source = "ServicioAdicional.nombre", target="tipoServicioAdicional")
    CumpleanoResponse toResponse(Cumpleano cumpleano);


}
