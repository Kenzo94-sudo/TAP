package Playground.service.impl;

import Playground.model.dto.Login.LoginRequest;
import Playground.model.dto.Login.LoginResponse;
import Playground.model.entity.Usuario;
import lombok.RequiredArgsConstructor;
import Playground.model.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import Playground.repository.UsuarioRepository;
import Playground.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public LoginResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByCorreo(request.getCorreo())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        // En Sprint 1 la contraseña se compara directamente.
        // Posteriormente se reemplazará por BCrypt.

        if (!usuario.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuarioMapper.toLoginResponse(usuario);

    }
}