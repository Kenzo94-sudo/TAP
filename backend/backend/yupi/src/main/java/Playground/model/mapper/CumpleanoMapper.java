package Playground.model.mapper;


import Playground.model.dto.Cumpleano.CumpleanoRequest;
import Playground.model.dto.Cumpleano.CumpleanoResponse;
import Playground.model.entity.Cumpleano;
import Playground.model.entity.ServicioAdicional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CumpleanoMapper {

    // Entity -> Response
    @Mapping(source = "idCumpleanio", target = "idCumpleanio")
    @Mapping(source = "cliente.idCliente", target = "idCliente")
    @Mapping(expression = "java(cumpleanio.getCliente().getNombre() + \" \" + cumpleanio.getCliente().getApellido())",
            target = "nombreCliente")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "servicios", expression = "java(mapServicios(cumpleanio.getServicios()))")
    CumpleanoResponse toResponse(Cumpleano cumpleano);

    // Request -> Entity
    @Mapping(target = "idCumpleanio", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "servicios", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Cumpleano toEntity(CumpleanoRequest request);

    // Lista de entidades -> lista de respuestas
    List<CumpleanoResponse> toResponseList(List<Cumpleano> lista);

    // Convierte List<ServicioAdicional> -> List<String>
    default List<String> mapServicios(List<ServicioAdicional> servicios) {
        if (servicios == null) {
            return List.of();
        }

        return servicios.stream()
                .map(ServicioAdicional::getNombre)
                .toList();
    }
}
