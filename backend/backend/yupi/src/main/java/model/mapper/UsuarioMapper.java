package model.mapper;

import model.dto.Usuario.LoginRequestDTO;
import model.dto.Usuario.LoginResponseDTO;
import model.dto.Usuario.UsuarioCreateDTO;
import model.dto.Usuario.UsuarioReponseDTO;
import model.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(LoginRequestDTO createDTO);

    LoginResponseDTO toResponse(Usuario usuario);

}
