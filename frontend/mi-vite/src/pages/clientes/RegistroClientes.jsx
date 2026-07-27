import { useState } from "react";
import "./RegistroClientes.css";

import Sidebar from "../../components/Sidebar";
import Navbar from "../../components/Navbar";

import ClientForm from "../../components/ClientForm";
import ChildForm from "../../components/ChildForm";

import TablaClientes from "../../components/TablaClientes";
import TablaNiños from "../../components/TablaNiños";

import  {Typography}  from "@mui/material";

import PersonIcon from '@mui/icons-material/Person';
import ChildCareIcon from '@mui/icons-material/ChildCare';

function RegistroClientes() {

    const [clientes, setClientes] = useState([]);
    const [ninos, setNinos] = useState([]);
    const [clienteSeleccionado, setClienteSeleccionado] = useState(null);
    const [activeTab, setActiveTab] = useState("clientes");

    const guardarCliente = (cliente)=>{
        const nuevoCliente={
            id: Date.now(),
            ...cliente
        };
        setClientes([...clientes,
            nuevoCliente
        ]);
    };

    const editarCliente=(cliente)=>{
        console.log("Editar",cliente);
    };

    const eliminarCliente=(id)=>{
        setClientes(
            clientes.filter(
                cliente=>cliente.id!==id
            )
        );
    };

    const seleccionarCliente=(cliente)=>{
        setClienteSeleccionado(cliente);
    };

    const guardarNino = (nino)=>{
            const nuevoNino={
                id:Date.now(),
                ...nino,
                clienteId:clienteSeleccionado.id
            };
            setNinos(prev=>[
                ...prev,
                nuevoNino
            ]);
        };

    const editarNino=(nino)=>{
        console.log("Editar niño",nino);
    };

    const eliminarNino=(id)=>{
        setNinos(
            ninos.filter(
                nino=>nino.id!==id
            )
        );
    };

    return (
        <div className="dashboard">
            <Sidebar/>
            <div className="dashboard-content">
                <Navbar/>
                <main className="dashboard-body">

                    <div className="registro-header">
                        <h1>Gestión de Clientes y Niños</h1>
                        <p>Registra clientes y niños asociados</p>
                    </div>

                    <div className="registro">
                        <div className="tabs">
                            <button className={activeTab == "clientes" ? "active" : ""} onClick={() => setActiveTab("clientes")}>
                                <PersonIcon/>
                                Registro Clientes
                            </button>
                            <button className={activeTab == "niños" ? "active" : ""} onClick={() => setActiveTab("niños")}>
                                <ChildCareIcon/>
                                Registro Niños
                            </button>
                        </div>

                    {activeTab === "clientes" && ( 
                    <div className="panel">
                        <ClientForm
                            onGuardar={guardarCliente}/>
                        <TablaClientes
                            clientes={clientes}
                            onEditar={editarCliente}
                            onEliminar={eliminarCliente}
                            onSeleccionar={seleccionarCliente}/>
                    </div>

                    )}   

                    {activeTab === "niños" && (
                    <div className="panel">
                        { clienteSeleccionado ?
                            <>
                                <Typography
                                    variant="subtitle1"
                                    fontWeight="bold"
                                    color="primary"
                                    sx={{mb:2}}>
                                    Cliente seleccionado:
                                    {" "}
                                    {clienteSeleccionado.nombres}
                                    {" "}
                                    {clienteSeleccionado.apellidos}
                                </Typography>

                                <ChildForm
                                    clienteId={clienteSeleccionado.id} 
                                    onGuardar={guardarNino}/>

                                <TablaNiños
                                    ninos={ninos.filter(nino =>
                                        Number(nino.clienteId) === Number(clienteSeleccionado.id))}
                                onEditar={editarNino}
                                onEliminar={eliminarNino}
                            />
                            </>
                            :
                            <div className="seleccionar">
                                👈 Seleccione un cliente para registrar niños
                            </div>
                        }
                        </div>
                          )}   
                    </div>
                     
                </main>
            </div>
        </div>
    );
}

export default RegistroClientes;