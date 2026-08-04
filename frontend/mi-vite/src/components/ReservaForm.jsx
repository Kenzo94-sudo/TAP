import useCumpleano from "../../hooks/useCumpleano";
import ServicioSelector from "./ServicioSelector";
import "./ReservaForm.css";


const ReservaForm = () => {

    const {

    clientes,

    servicios,

    formulario,

    handleChange,

    seleccionarServicio,

    guardarCumpleano,

    loading,

    error

    } = useCumpleano();
    

    const guardarReserva = async (e) => {

        e.preventDefault();

        try {

            await guardarCumpleano();

            alert(
                "Reserva registrada correctamente"
            );


        } catch(error){

            alert(
                "Error al registrar reserva"
            );

        }

    };


    return (

        <div className="reserva-container">


            <h2>
                Registro de Cumpleaños
            </h2>


            <form onSubmit={guardarReserva}>


                <label>
                    Cliente
                </label>

                <select
                    name="idCliente"
                    value={formulario.idCliente}
                    onChange={handleChange}
                    required
                >

                    <option value="">
                        Seleccione cliente
                    </option>


                    {
                        clientes.map(cliente => (

                            <option
                                key={cliente.idCliente}
                                value={cliente.idCliente}
                            >

                                {
                                    cliente.nombre
                                }
                                {" "}
                                {
                                    cliente.apellido
                                }

                            </option>

                        ))
                    }

                </select>



                <label>
                    Fecha del evento
                </label>

                <input

                    type="date"

                    name="fechaEvento"

                    value={
                        formulario.fechaEvento
                    }

                    onChange={handleChange}

                    required

                />



                <div className="horarios">


                    <div>

                        <label>
                            Hora inicio
                        </label>

                        <input

                            type="time"

                            name="horaInicio"

                            value={
                                formulario.horaInicio
                            }

                            onChange={handleChange}

                        />

                    </div>



                    <div>

                        <label>
                            Hora fin
                        </label>

                        <input

                            type="time"

                            name="horaFin"

                            value={
                                formulario.horaFin
                            }

                            onChange={handleChange}

                        />

                    </div>


                </div>




                <label>
                    Cantidad niños
                </label>

                <input

                    type="number"

                    name="cantidadNinos"

                    value={
                        formulario.cantidadNinos
                    }

                    onChange={handleChange}

                />



                <label>
                    Cantidad adultos
                </label>

                <input

                    type="number"

                    name="cantidadAdultos"

                    value={
                        formulario.cantidadAdultos
                    }

                    onChange={handleChange}

                />




                <label>
                    Servicios adicionales
                </label>

                        <ServicioSelector

                                servicios={servicios}

                                serviciosSeleccionados={
                                    formulario.servicios
                                }

                                seleccionarServicio={
                                    seleccionarServicio
                                }

                            />




                <label>
                    Observaciones
                </label>


                <textarea

                    name="observaciones"

                    value={
                        formulario.observaciones
                    }

                    onChange={handleChange}

                />



                <button type="submit">

                    Registrar Reserva

                </button>


            </form>


        </div>

    );

};


export default ReservaForm;