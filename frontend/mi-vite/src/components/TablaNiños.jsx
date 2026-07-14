import { useState } from "react";
import "./TablaNiños.css";

import {
    Paper, Typography, TextField, Table,TableBody, TableCell, TableContainer, TableHead, TableRow,
    IconButton, Tooltip, InputAdornment } from "@mui/material";

import SearchIcon from "@mui/icons-material/Search";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";



function TablaNiños({
    ninos = [],
    onEditar,
    onEliminar
}) {

    const [buscar, setBuscar] = useState("");

    const ninosFiltrados = ninos.filter((nino)=>{
        const texto = buscar.toLowerCase();

        return (
            nino.nombres?.toLowerCase().includes(texto) ||
            nino.apellidos?.toLowerCase().includes(texto)
        );
    });

    return (

        <Paper
            elevation={3}
            sx={{
                p:3,
                mt:4,
                borderRadius:3
            }}>


            <Typography
                variant="h6"
                fontWeight="bold"
                color="primary"
                mb={2}
            >
                Lista de Niños
            </Typography>

            <TextField
                fullWidth
                placeholder="Buscar niño por nombre"
                value={buscar}
                onChange={(e)=>setBuscar(e.target.value)}
                sx={{mb:3}}
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
                            
                            <TableCell>
                                <b>Nombres</b>
                            </TableCell>


                            <TableCell>
                                <b>Apellidos</b>
                            </TableCell>


                            <TableCell>
                                <b>Fecha Nacimiento</b>
                            </TableCell>


                            <TableCell>
                                <b>Género</b>
                            </TableCell>

                            <TableCell>
                                <b>Alergias</b>
                            </TableCell>

                            <TableCell align="center">
                                <b>Acciones</b>
                            </TableCell>

                        </TableRow>

                    </TableHead>

                    <TableBody>

                    {
                    ninosFiltrados.length > 0 ?

                    ninosFiltrados.map((nino)=>(

                        <TableRow
                            key={nino.id}
                            hover
                        >
                            <TableCell>
                                {nino.nombres}
                            </TableCell>

                            <TableCell>
                                {nino.apellidos}
                            </TableCell>

                            <TableCell>
                                {nino.fechaNacimiento}
                            </TableCell>

                            <TableCell>
                                {nino.genero}
                            </TableCell>

                            <TableCell>
                                {nino.alergias || "-"}
                            </TableCell>

                            <TableCell align="center">
                                <Tooltip title="Editar">
                                    <IconButton
                                        color="primary"
                                        onClick={()=>onEditar(nino)}
                                    >
                                        <EditIcon/>
                                    </IconButton>
                                </Tooltip>

                                <Tooltip title="Eliminar">
                                    <IconButton
                                        color="error"
                                        onClick={()=>onEliminar(nino.id)}
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
                            align="center" >
                            No existen niños registrados.

                        </TableCell>
                    </TableRow>

                    }

                    </TableBody>

                </Table>

            </TableContainer>

        </Paper>

    );

}


export default TablaNiños;