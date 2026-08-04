import axios from "axios";


const API_URL = "http://localhost:8081/api/cumpleanos";


// Registrar cumpleaños
export const registrarCumpleano = async (cumpleano) => {

    const response = await axios.post(
        API_URL,
        cumpleano
    );

    return response.data;
};



// Listar todos los cumpleaños
export const listarCumpleanos = async () => {

    const response = await axios.get(
        API_URL
    );

    return response.data;
};



// Buscar cumpleaños por ID
export const obtenerCumpleanoPorId = async (id) => {

    const response = await axios.get(
        `${API_URL}/${id}`
    );

    return response.data;
};



// Actualizar cumpleaños
export const actualizarCumpleano = async (
    id,
    cumpleano
) => {

    const response = await axios.put(
        `${API_URL}/${id}`,
        cumpleano
    );

    return response.data;
};



// Eliminar cumpleaños
export const eliminarCumpleano = async (id) => {

    await axios.delete(
        `${API_URL}/${id}`
    );

};

