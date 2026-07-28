package Playground.model.mapper;

import Playground.model.dto.Login.LoginResponse;
import Playground.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "rol.nombre", target = "rol")
    LoginResponse toLoginResponse(Usuario usuario);

}