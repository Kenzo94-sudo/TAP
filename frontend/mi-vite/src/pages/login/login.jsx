import "./login.css";
import { useState } from "react";

import {useNavigate} from "react-router-dom";


import PersonOutlineIcon from "@mui/icons-material/PersonOutlined";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import VisibilityOutlinedIcon from "@mui/icons-material/VisibilityOutlined";
import VisibilityOffOutlinedIcon from "@mui/icons-material/VisibilityOffOutlined";
import LockIcon from "@mui/icons-material/Lock";

import background from "../../assets/login-background.png";
import panda from "../../assets/panda.png";

function Login() {
<<<<<<< HEAD

=======
        const iniciarSesion = async () => {
            try { const usuario = await login({ correo, password});
                localStorage.setItem("usuario",
                    JSON.stringify(usuario));
                navigate("/menuPrincipal");
            } catch (error) {
                alert("Correo o contraseña incorrectos");}
        };
>>>>>>> master
    const navigate = useNavigate();
    const handleAccess = (event) => { navigate("/menu"); 
        event.preventDefault(); };

    const [username, setUsername] = useState("");

    const [password, setPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);

    return (
        <div className="login-container">

            <img src={background} alt="Background" className="background-image" />
            
                <div className="login-container-card">

                    <div className="login-card">
                        <div className="title">
                            <div className="avatar">
                                <PersonOutlineIcon fontSize="large" />
                            </div>
                            <div className="text-title">
                                <h1 className="title-text">Iniciar sesión</h1>
                                <p className="subtitle">Sistema Administrativo - YUPI Indoor Playground</p>
                            </div>
                        </div>

                        <form>
                            <label>Usuario o correo</label>
                            <div className="input-group">
                                <PersonOutlineIcon />
                                <input type="text" placeholder="Ingresa tu usuario o correo" value={username} onChange={(e) => setUsername(e.target.value)}/>
                            </div>
                            <label>Contraseña</label>

                            <div className="input-group">
                                <LockOutlinedIcon />
                                <input type={showPassword ? "text" : "password"} placeholder="Ingresa tu contraseña" value={password} onChange={(e) => setPassword(e.target.value)}/>

                                <button type="button" className="eye" onClick={() => setShowPassword(!showPassword)}>
                                    {showPassword ? (
                                        <VisibilityOffOutlinedIcon />
                                    ) : (
                                        <VisibilityOutlinedIcon />
                                    )}
                                </button>
                            </div>

                            <div className="options">
                                <label>
                                    <input type="checkbox" />Recordar sesión
                                </label>
                            </div>

                            <button type="submit" className="login-btn" onClick={handleAccess}> 
                                <LockIcon />Iniciar sesión
                            </button>
                            
                        </form>

                        <div className="footer">
                            <img src={panda} alt="Panda" className="panda-image"/>
                            <span>YUPI Indoor Playground</span>
                        </div>

                    </div>
                </div>
        </div>
    );
}

export default Login;