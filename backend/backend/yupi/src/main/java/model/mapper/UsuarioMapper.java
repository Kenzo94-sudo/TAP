package model.mapper;

import model.dto.Usuario.LoginResponseDTO;
import model.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    LoginResponseDTO toResponse(Usuario usuario);
}
