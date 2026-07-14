package Playground.service;


import Playground.model.dto.Login.LoginRequest;
import Playground.model.dto.Login.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}