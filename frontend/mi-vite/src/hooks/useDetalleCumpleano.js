import { useEffect, useState } from "react";

import {
    obtenerCumpleanoPorId
} from "../services/cumpleanoService";


import {
    listarServiciosCumpleano
} from "../services/cumpleanoServicioService";


const useDetalleCumpleano = (id) => {


    const [cumpleano, setCumpleano] = useState(null);

    const [servicios, setServicios] = useState([]);

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState(null);



    useEffect(() => {

        if(id){

            cargarDetalle();

        }

    }, [id]);



    const cargarDetalle = async () => {


        try {

            setLoading(true);


            const data =
                await obtenerCumpleanoPorId(id);


            setCumpleano(data);



            const serviciosData =
                await listarServiciosCumpleano(id);


            setServicios(serviciosData);



        } catch(error) {


            console.error(error);


            setError(
                "Error cargando detalle del cumpleaños"
            );


        } finally {


            setLoading(false);

        }

    };



    return {

        cumpleano,

        servicios,

        loading,

        error,

        cargarDetalle

    };

};


export default useDetalleCumpleano;