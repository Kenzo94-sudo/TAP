import { useNavigate } from "react-router-dom";

import useTablaCumpleano 
from "../../hooks/useTablaCumpleano";

import "./TablaCumpleano.css";


const TablaCumpleano = () => {


    const navigate = useNavigate();



    const {

        cumpleanos,

        busqueda,

        loading,

        error,

        cambiarBusqueda,

        eliminar

    } = useTablaCumpleano();




    if (loading) {

        return (

            <h3>
                Cargando cumpleaños...
            </h3>

        );

    }



    if (error) {

        return (

            <h3>
                {error}
            </h3>

        );

    }



    return (

        <div className="tabla-container">


            <h2>
                Lista de Cumpleaños
            </h2>



            <div className="barra-busqueda">


                <input

                    type="text"

                    placeholder="Buscar por cliente..."

                    value={busqueda}

                    onChange={cambiarBusqueda}

                />


            </div>




            <table>


                <thead>

                    <tr>

                        <th>
                            Cliente
                        </th>

                        <th>
                            Fecha evento
                        </th>

                        <th>
                            Hora
                        </th>

                        <th>
                            Niños
                        </th>

                        <th>
                            Adultos
                        </th>

                        <th>
                            Estado
                        </th>

                        <th>
                            Acciones
                        </th>


                    </tr>

                </thead>




                <tbody>


                {
                    cumpleanos.length === 0

                    ?

                    (

                        <tr>

                            <td colSpan="7">

                                No existen cumpleaños registrados

                            </td>

                        </tr>

                    )


                    :


                    cumpleanos.map(
                        cumpleano => (

                        <tr
                            key={
                                cumpleano.idCumpleano
                            }
                        >


                            <td>

                                {
                                    cumpleano.cliente.nombre
                                }

                                {" "}

                                {
                                    cumpleano.cliente.apellido
                                }

                            </td>



                            <td>

                                {
                                    cumpleano.fechaEvento
                                }

                            </td>




                            <td>

                                {
                                    cumpleano.horaInicio
                                }

                                {" - "}

                                {
                                    cumpleano.horaFin
                                }

                            </td>




                            <td>

                                {
                                    cumpleano.cantidadNinos
                                }

                            </td>



                            <td>

                                {
                                    cumpleano.cantidadAdultos
                                }

                            </td>




                            <td>

                                <span
                                    className={
                                        `estado ${cumpleano.estado}`
                                    }
                                >

                                    {
                                        cumpleano.estado
                                    }

                                </span>

                            </td>





                            <td>


                                <button

                                    className="btn-detalle"

                                    onClick={() =>
                                        navigate(
                                            `/cumpleanos/${cumpleano.idCumpleano}`
                                        )
                                    }

                                >

                                    Ver

                                </button>




                                <button

                                    className="btn-eliminar"

                                    onClick={() =>
                                        eliminar(
                                            cumpleano.idCumpleano
                                        )
                                    }

                                >

                                    Eliminar

                                </button>


                            </td>



                        </tr>

                    ))

                }


                </tbody>


            </table>



        </div>

    );

};



export default TablaCumpleano;