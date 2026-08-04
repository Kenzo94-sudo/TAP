import axios from "axios";


const API_URL = 
    "http://localhost:8081/api/servicios-adicionales";



// Listar servicios disponibles
export const listarServiciosActivos = async () => {

    const response = await axios.get(
        `${API_URL}/activos`
    );

    return response.data;

};



// Listar todos los servicios
export const listarServicios = async () => {

    const response = await axios.get(
        API_URL
    );

    return response.data;

};



// Buscar servicio por ID
export const obtenerServicioPorId = async (id) => {

    const response = await axios.get(
        `${API_URL}/${id}`
    );

    return response.data;

};



// Registrar servicio adicional
export const registrarServicio = async (
    servicio
) => {

    const response = await axios.post(
        API_URL,
        servicio
    );

    return response.data;

};



// Actualizar servicio
export const actualizarServicio = async (
    id,
    servicio
) => {

    const response = await axios.put(
        `${API_URL}/${id}`,
        servicio
    );

    return response.data;

};



// Eliminar servicio
export const eliminarServicio = async (id) => {

    await axios.delete(
        `${API_URL}/${id}`
    );

};