import api from "../axios/axios";

export const login = async (credenciales) => {

    const response = await api.post("/auth/login", credenciales);

    return response.data;

};