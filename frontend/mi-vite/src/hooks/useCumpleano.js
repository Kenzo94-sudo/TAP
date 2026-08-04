import { useEffect, useState } from "react";


import {
    registrarCumpleano
} from "../services/cumpleanoService";


import {
    listarClientes
} from "../services/clienteService";


import {
    listarServiciosActivos
} from "../services/servicioAdicionalService";


import {
    agregarServicioCumpleano
} from "../services/cumpleanoServicioService";



const useCumpleano = () => {


    const [clientes, setClientes] = useState([]);

    const [servicios, setServicios] = useState([]);


    const [loading, setLoading] = useState(false);


    const [error, setError] = useState(null);



    const [formulario, setFormulario] = useState({

        idCliente: "",

        fechaEvento: "",

        horaInicio: "",

        horaFin: "",

        cantidadNinos: "",

        cantidadAdultos: "",

        observaciones: "",

        servicios: []

    });



    // Cargar datos iniciales

    useEffect(() => {

        cargarClientes();

        cargarServicios();

    }, []);



    const cargarClientes = async () => {

        try {

            const data = await listarClientes();

            setClientes(data);


        } catch (error) {

            setError(
                "Error cargando clientes"
            );

        }

    };



    const cargarServicios = async () => {

        try {

            const data =
                await listarServiciosActivos();


            setServicios(data);


        } catch (error) {

            setError(
                "Error cargando servicios"
            );

        }

    };




    const handleChange = (e) => {


        setFormulario({

            ...formulario,

            [e.target.name]:
                e.target.value

        });

    };




    // Selección de servicios adicionales

    const seleccionarServicio = (
        idServicio
    ) => {


        let lista =
            [...formulario.servicios];



        if(lista.includes(idServicio)){


            lista =
                lista.filter(
                    id => id !== idServicio
                );


        }else{


            lista.push(idServicio);

        }



        setFormulario({

            ...formulario,

            servicios: lista

        });

    };





    // Registrar reserva completa

    const guardarCumpleano = async () => {


        try {


            setLoading(true);



            const cumpleano =
                await registrarCumpleano(
                    formulario
                );



            const idCumpleano =
                cumpleano.idCumpleano;



            // Guardar servicios seleccionados

            for(
                const idServicio 
                of formulario.servicios
            ){


                await agregarServicioCumpleano({

                    idCumpleano,

                    idServicio,

                    cantidad: 1

                });


            }



            limpiarFormulario();


            return cumpleano;



        }catch(error){


            setError(
                "Error registrando cumpleaños"
            );


            throw error;


        }finally{


            setLoading(false);

        }


    };





    const limpiarFormulario = () => {


        setFormulario({

            idCliente: "",

            fechaEvento: "",

            horaInicio: "",

            horaFin: "",

            cantidadNinos: "",

            cantidadAdultos: "",

            observaciones: "",

            servicios: []

        });


    };




    return {


        clientes,

        servicios,

        formulario,

        loading,

        error,


        handleChange,

        seleccionarServicio,

        guardarCumpleano,

        limpiarFormulario


    };

};


export default useCumpleano;