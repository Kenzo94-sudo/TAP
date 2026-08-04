import axios from "axios";


const API_URL =
    "http://localhost:8081/api/cumpleano-servicios";



// Registrar servicio a un cumpleaños
export const agregarServicioCumpleano = async (
    data
) => {

    const response = await axios.post(
        API_URL,
        data
    );

    return response.data;

};



// Listar servicios de un cumpleaños
export const listarServiciosCumpleano = async (
    idCumpleano
) => {

    const response = await axios.get(
        `${API_URL}/cumpleano/${idCumpleano}`
    );

    return response.data;

};



// Obtener relación por ID
export const obtenerCumpleanoServicioPorId = async (
    id
) => {

    const response = await axios.get(
        `${API_URL}/${id}`
    );

    return response.data;

};



// Actualizar servicio asignado
export const actualizarServicioCumpleano = async (
    id,
    data
) => {

    const response = await axios.put(
        `${API_URL}/${id}`,
        data
    );

    return response.data;

};



// Eliminar servicio de un cumpleaños
export const eliminarServicioCumpleano = async (
    id
) => {

    await axios.delete(
        `${API_URL}/${id}`
    );

};

// Obtener servicios asociados a un cumpleaños
export const listarServiciosCumpleano = async (
    idCumpleano
) => {

    const response = await api.get(
        `/cumpleano-servicios/cumpleano/${idCumpleano}`
    );

    return response.data;

};

// Agregar servicio a cumpleaños
export const agregarServicioCumpleano = async (
    data
) => {

    const response = await api.post(
        "/cumpleano-servicios",
        data
    );

    return response.data;

};

