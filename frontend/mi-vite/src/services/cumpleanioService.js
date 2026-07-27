import api from "../api/axiosConfig";

export const registrarCumpleanio = (data) => {
    return api.post("/cumpleanios", data);
};

export const listarCumpleanios = () => {
    return api.get("/cumpleanios");
};

export const actualizarCumpleanio = (id, data) => {
    return api.put(`/cumpleanios/${id}`, data);
};

export const eliminarCumpleanio = (id) => {
    return api.delete(`/cumpleanios/${id}`);
};