import api from "../axios/axios";

export const listarClientes = async () => {

    const response = await api.get("/clientes");

    return response.data;

};

export const registrarCliente = async (cliente) => {

    const response = await api.post("/clientes", cliente);

    return response.data;

};

export const actualizarCliente = async (id, cliente) => {

    const response = await api.put(`/clientes/${id}`, cliente);

    return response.data;

};

export const eliminarCliente = async (id) => {

    await api.delete(`/clientes/${id}`);

};