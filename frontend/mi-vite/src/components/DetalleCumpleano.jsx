import { useParams } from "react-router-dom";

import useDetalleCumpleano 
from "../../hooks/useDetalleCumpleano";

import "./DetalleCumpleano.css";


const DetalleCumpleano = () => {


    const { id } = useParams();


    const {

        cumpleano,

        servicios,

        loading,

        error

    } = useDetalleCumpleano(id);



    if (loading) {

        return (

            <h3>
                Cargando información...
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



    if (!cumpleano) {

        return (

            <h3>
                No existe información del cumpleaños
            </h3>

        );

    }



    return (

        <div className="detalle-container">


            <h2>
                Detalle de Cumpleaños
            </h2>



            <div className="card-detalle">


                <h3>
                    Datos del evento
                </h3>


                <p>
                    <strong>
                        Cliente:
                    </strong>

                    {" "}

                    {cumpleano.cliente.nombre}

                    {" "}

                    {cumpleano.cliente.apellido}

                </p>



                <p>
                    <strong>
                        Fecha:
                    </strong>

                    {" "}

                    {cumpleano.fechaEvento}

                </p>



                <p>
                    <strong>
                        Horario:
                    </strong>

                    {" "}

                    {cumpleano.horaInicio}

                    {" - "}

                    {cumpleano.horaFin}

                </p>



                <p>
                    <strong>
                        Cantidad niños:
                    </strong>

                    {" "}

                    {cumpleano.cantidadNinos}

                </p>



                <p>
                    <strong>
                        Cantidad adultos:
                    </strong>

                    {" "}

                    {cumpleano.cantidadAdultos}

                </p>



                <p>
                    <strong>
                        Estado:
                    </strong>

                    {" "}

                    {cumpleano.estado}

                </p>



                <p>
                    <strong>
                        Observaciones:
                    </strong>

                    {" "}

                    {cumpleano.observaciones}

                </p>


            </div>





            <div className="card-detalle">


                <h3>
                    Servicios adicionales
                </h3>



                {
                    servicios.length === 0

                    ?

                    <p>
                        No tiene servicios adicionales
                    </p>


                    :


                    servicios.map(item => (

                        <div

                            className="servicio-item"

                            key={
                                item.idCumpleanoServicio
                            }

                        >

                            <span>
                                {
                                    item.servicio.nombre
                                }
                            </span>


                            <span>
                                S/ {
                                    item.servicio.precio
                                }
                            </span>


                        </div>

                    ))

                }


            </div>





            <div className="total">


                <h3>
                    Total servicios:
                </h3>



                <p>

                    S/ {

                        servicios.reduce(

                            (total, item) =>

                            total +
                            item.servicio.precio,

                            0

                        )

                    }

                </p>


            </div>



        </div>

    );

};


export default DetalleCumpleano;