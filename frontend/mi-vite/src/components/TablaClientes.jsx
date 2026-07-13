import { useState } from "react";
import "./TablaClientes.css";

import {    Paper, Typography, TextField, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, IconButton, Tooltip, InputAdornment} 
    from "@mui/material";

import SearchIcon from "@mui/icons-material/Search";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import ChildCareIcon from "@mui/icons-material/ChildCare";

function TablaClientes({

    clientes = [],
    onEditar,
    onEliminar,
    onSeleccionar

}) {

    const [buscar, setBuscar] = useState("");

    const clientesFiltrados = clientes.filter((cliente) => {

        const texto = buscar.toLowerCase();

        return (

            cliente.nombres.toLowerCase().includes(texto) ||

            cliente.apellidos.toLowerCase().includes(texto) ||

            cliente.dni.includes(texto)

        );

    });

    return (

        <Paper
            elevation={3}
            sx={{
                p:3,
                mt:4,
                borderRadius:3
            }}
        >

            <Typography
                variant="h6"
                fontWeight="bold"
                color="primary"
                mb={2}
            >
                Lista de Clientes
            </Typography>

            <TextField

                fullWidth

                placeholder="Buscar por nombre o DNI"

                value={buscar}

                onChange={(e)=>setBuscar(e.target.value)}

                sx={{ mb:3 }}

                InputProps={{
                    startAdornment:(
                        <InputAdornment position="start">
                            <SearchIcon/>
                        </InputAdornment>
                    )
                }}

            />

            <TableContainer>

                <Table>

                    <TableHead>

                        <TableRow>

                            <TableCell><b>DNI</b></TableCell>

                            <TableCell><b>Nombres</b></TableCell>

                            <TableCell><b>Apellidos</b></TableCell>

                            <TableCell><b>Celular</b></TableCell>

                            <TableCell><b>Correo</b></TableCell>

                            <TableCell align="center">
                                <b>Acciones</b>
                            </TableCell>

                        </TableRow>

                    </TableHead>

                    <TableBody>

                        {

                            clientesFiltrados.length > 0 ?

                            clientesFiltrados.map((cliente)=>(

                                <TableRow key={cliente.id} hover>

                                    <TableCell>

                                        {cliente.dni}

                                    </TableCell>

                                    <TableCell>

                                        {cliente.nombres}

                                    </TableCell>

                                    <TableCell>

                                        {cliente.apellidos}

                                    </TableCell>

                                    <TableCell>

                                        {cliente.celular}

                                    </TableCell>

                                    <TableCell>

                                        {cliente.correo}

                                    </TableCell>

                                    <TableCell align="center">

                                        <Tooltip title="Registrar Niño">

                                            <IconButton
                                                color="success"
                                                onClick={()=>
                                                    onSeleccionar(cliente)
                                                }
                                            >
                                                <ChildCareIcon/>
                                            </IconButton>

                                        </Tooltip>

                                        <Tooltip title="Editar">

                                            <IconButton
                                                color="primary"
                                                onClick={()=>
                                                    onEditar(cliente)
                                                }
                                            >
                                                <EditIcon/>
                                            </IconButton>

                                        </Tooltip>

                                        <Tooltip title="Eliminar">

                                            <IconButton
                                                color="error"
                                                onClick={()=>
                                                    onEliminar(cliente.id)
                                                }
                                            >
                                                <DeleteIcon/>
                                            </IconButton>

                                        </Tooltip>

                                    </TableCell>

                                </TableRow>

                            ))

                            :

                            <TableRow>

                                <TableCell
                                    colSpan={6}
                                    align="center"
                                >

                                    No existen clientes registrados.

                                </TableCell>

                            </TableRow>

                        }

                    </TableBody>

                </Table>

            </TableContainer>

        </Paper>

    );

}

export default TablaClientes;