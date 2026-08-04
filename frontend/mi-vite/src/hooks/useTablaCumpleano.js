import {
    listarCumpleanos,
    eliminarCumpleano
} from "../services/cumpleanoService";

const data = await listarCumpleanos();

setCumpleanos(data);

await eliminarCumpleano(id);

