import { useState } from "react";
import "./ClientForm.css";
import { Grid, Paper, TextField, Button, Typography, MenuItem, Divider} from "@mui/material";
import SaveIcon from "@mui/icons-material/Save";
import ClearIcon from "@mui/icons-material/Clear";

function ClientForm({ onGuardar }) {

    const [cliente, setCliente] = useState({
        nombres: "",
        apellidos: "",
        dni: "",
        celular: "",
        correo: "",
        direccion: "",
        distrito: "",
        genero: "",
        observacion: ""
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCliente({
            ...cliente,
            [name]: value
        });
    };

    const limpiarFormulario = () => {
        setCliente({
            nombres: "",
            apellidos: "",
            dni: "",
            celular: "",
            correo: "",
            direccion: "",
            distrito: "",
            genero: "",
            observacion: ""
        });
    };

    const guardarCliente = (e) => {
        e.preventDefault();
        if (onGuardar) {
            onGuardar(cliente);
        }
    };
    return (
            <Paper
                elevation={0}
                className="client-form">
                <Typography
                    variant="h6"
                    fontWeight="bold"
                    color="primary">
                    Registro de Cliente
                </Typography>

                <Divider sx={{ my: 2 }} />

                <form onSubmit={guardarCliente}>

                    <Grid container spacing={2} className="form-container">
                        <Grid size={{ xs: 12, md: 6 }}>
                            <TextField
                                fullWidth
                                label="Nombres"
                                name="nombres"
                                value={cliente.nombres}
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid size={{ xs: 12, md: 6 }}>
                            <TextField
                                fullWidth
                                label="Apellidos"
                                name="apellidos"
                                value={cliente.apellidos}
                                onChange={handleChange}/>
                        </Grid>
                    </Grid>

                    <Grid container spacing={2}>
                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                label="DNI"
                                name="dni"
                                inputProps={{ maxLength: 8 }}
                                value={cliente.dni}
                                onChange={handleChange}/>
                        </Grid>

                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                label="Celular"
                                name="celular"
                                inputProps={{ maxLength: 9 }}
                                value={cliente.celular}
                                onChange={handleChange}/>
                        </Grid>

                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                select
                                label="Género"
                                name="genero"
                                value={cliente.genero}
                                onChange={handleChange}>
                                    <MenuItem value="M">
                                        Masculino
                                    </MenuItem>
                                    <MenuItem value="F">
                                        Femenino
                                    </MenuItem>
                            </TextField>
                        </Grid>
                    </Grid>

                    <Grid container spacing={2}>
                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                label="Correo Electrónico"
                                name="correo"
                                value={cliente.correo}
                                onChange={handleChange}/>
                        </Grid>
                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                label="Dirección"
                                name="direccion"
                                value={cliente.direccion}
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid size={{ xs: 12, md: 4 }}>
                            <TextField
                                fullWidth
                                label="Distrito"
                                name="distrito"
                                value={cliente.distrito}
                                onChange={handleChange}
                            />
                        </Grid>
                    </Grid>

                    <Grid container spacing={2}>
                        <Grid size={{ xs: 12, md: 6 }}>
                            <TextField
                                fullWidth
                                multiline
                                rows={3}
                                label="Observaciones"
                                name="observacion"
                                value={cliente.observacion}
                                onChange={handleChange}/>
                        </Grid>
                        <Grid size={{ xs: 12, md: 6 }}
                                sx={{display: "flex",
                                    justifyContent: "flex-start",
                                    gap: 2}}>
                                <Button
                                    fullWidth
                                    variant="outlined"
                                    color="error"
                                    startIcon={<ClearIcon />}
                                    onClick={limpiarFormulario}>
                                    Limpiar
                                </Button>
                                <Button
                                    fullWidth
                                    type="submit"
                                    variant="contained"
                                    startIcon={<SaveIcon />}>
                                    Guardar Cliente
                                </Button>
                        </Grid>
                    </Grid>
            </form>
        </Paper>
    );
}

export default ClientForm;