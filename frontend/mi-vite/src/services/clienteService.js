import api from "../api/axiosConfig";

export const obtenerClientes = () => {
    return api.get("/clientes");
};

export const buscarCliente = (id) => {
    return api.get(`/clientes/${id}`);
};