import api from "../api/axiosConfig";

export const registrarCumpleano = (data) => {
    return api.post("/cumpleanos", data);
};

export const listarCumpleanos = () => {
    return api.get("/cumpleanos");
};

export const actualizarCumpleano = (id, data) => {
    return api.put(`/cumpleanos/${id}`, data);
};

export const eliminarCumpleano = (id) => {
    return api.delete(`/cumpleanos/${id}`);
};