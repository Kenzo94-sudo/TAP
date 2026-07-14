import { useState } from "react";
import "./ChildForm.css";


import {Paper, Grid, TextField, Button, Typography, Divider,MenuItem} from "@mui/material";

import SaveIcon from "@mui/icons-material/Save";
import ClearIcon from "@mui/icons-material/Clear";

function ChildForm({ clienteId, onGuardar }) {

    const [nino, setNino] = useState({

        nombres: "",
        apellidos: "",
        fechaNacimiento: "",
        genero: "",
        alergias: "",
        observaciones: ""

    });

    const handleChange = (e) => {

        const { name, value } = e.target;

        setNino({
            ...nino,
            [name]: value
        });

    };

    const limpiarFormulario = () => {

        setNino({

            nombres: "",
            apellidos: "",
            fechaNacimiento: "",
            genero: "",
            alergias: "",
            observaciones: ""

        });

    };

    const guardarNino = (e) => {
        e.preventDefault();
        const datos = {
            ...nino,
            clienteId
        };
        if (onGuardar) {
            onGuardar(datos);
        }
    };

    return (
        <Paper
            elevation={3}
            sx={{
                p: 4,
                mt: 4,
                borderRadius: 3
            }}>

            <Typography
                variant="h6"
                color="primary"
                fontWeight="bold">
                Registro de Niño
            </Typography>

            <Divider sx={{ my: 2 }} />

            <form onSubmit={guardarNino}>

                <Grid container spacing={2}>
                    <Grid item xs={12} md={6}>
                        <TextField
                            fullWidth
                            label="Nombres"
                            name="nombres"
                            value={nino.nombres}
                            onChange={handleChange}
                        />
                    </Grid>

                    <Grid item xs={12} md={6}>
                        <TextField
                            fullWidth
                            label="Apellidos"
                            name="apellidos"
                            value={nino.apellidos}
                            onChange={handleChange}
                        />
                    </Grid>

                    <Grid item xs={12} md={4}>
                        <TextField
                            fullWidth
                            type="date"
                            label="Fecha de Nacimiento"
                            name="fechaNacimiento"
                            InputLabelProps={{
                                shrink: true
                            }}
                            value={nino.fechaNacimiento}
                            onChange={handleChange}
                        />
                    </Grid>

                    <Grid item xs={12} md={4}>
                        <TextField
                            select
                            fullWidth
                            label="Género"
                            name="genero"
                            value={nino.genero}
                            onChange={handleChange}
                        >
                            <MenuItem value="M">
                                Masculino
                            </MenuItem>

                            <MenuItem value="F">
                                Femenino
                            </MenuItem>
                        </TextField>
                    </Grid>

                    <Grid item xs={12} md={4}>
                        <TextField
                            fullWidth
                            label="Edad"
                            disabled
                            value={
                                nino.fechaNacimiento
                                    ? calcularEdad(nino.fechaNacimiento)
                                    : ""
                            }
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <TextField
                            fullWidth
                            label="Alergias"
                            name="alergias"
                            value={nino.alergias}
                            onChange={handleChange}
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <TextField fullWidth 
                            multiline 
                            rows={3} 
                            label="Observaciones" 
                            name="observaciones" 
                            value={nino.observaciones}
                            onChange={handleChange}
                        />
                    </Grid>

                    <Grid item xs={12} sx={{display: "flex",justifyContent: "flex-end", gap: 2}}>

                        <Button variant="outlined" color="error" startIcon={<ClearIcon />}
                            onClick={limpiarFormulario}>Limpiar</Button>

                        <Button type="submit" variant="contained" startIcon={<SaveIcon />}>
                            Guardar Niño</Button>

                    </Grid>

                </Grid>

            </form>

        </Paper>

    );

}

function calcularEdad(fechaNacimiento) {

    const hoy = new Date();
    const nacimiento = new Date(fechaNacimiento);

    let edad = hoy.getFullYear() - nacimiento.getFullYear();

    const mes = hoy.getMonth() - nacimiento.getMonth();

    if (
        mes < 0 ||
        (mes === 0 && hoy.getDate() < nacimiento.getDate())
    ) {
        edad--;
    }

    return edad;
}

export default ChildForm;