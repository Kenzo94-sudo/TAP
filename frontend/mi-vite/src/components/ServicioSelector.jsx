import "./ServicioSelector.css";


const ServicioSelector = ({
    servicios,
    serviciosSeleccionados,
    seleccionarServicio
}) => {


    return (

        <div className="selector-container">


            <h3>
                Servicios adicionales
            </h3>



            {
                servicios.length === 0

                ?

                <p>
                    No hay servicios disponibles
                </p>


                :


                <div className="lista-servicios">


                    {
                        servicios.map(servicio => (


                            <div
                                className="servicio-card"
                                key={
                                    servicio.idServicio
                                }
                            >


                                <label>


                                    <input

                                        type="checkbox"

                                        checked={

                                            serviciosSeleccionados.includes(
                                                servicio.idServicio
                                            )

                                        }


                                        onChange={() =>
                                            seleccionarServicio(
                                                servicio.idServicio
                                            )
                                        }

                                    />



                                    <span>

                                        {servicio.nombre}

                                    </span>



                                    <span className="precio">

                                        S/ {servicio.precio}

                                    </span>


                                </label>



                            </div>


                        ))

                    }


                </div>

            }


        </div>

    );

};


export default ServicioSelector;