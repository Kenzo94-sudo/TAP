import api from "../axios/axios";

export const listarNinos = async (idCliente) => {

    const response = await api.get(`/ninos/cliente/${idCliente}`);

    return response.data;

};

export const registrarNino = async (nino) => {

    const response = await api.post("/ninos", nino);

    return response.data;

};

export const actualizarNino = async (id, nino) => {

    const response = await api.put(`/ninos/${id}`, nino);

    return response.data;

};

export const eliminarNino = async (id) => {

    await api.delete(`/ninos/${id}`);

};