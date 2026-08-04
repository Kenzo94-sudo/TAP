import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../pages/login/login";
import MenuPrincipal from "../pages/menuPrincipal/menu";
import RegistroClientes from "../pages/clientes/RegistroClientes";

function AppRouter() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/menu" element={<MenuPrincipal />} />
                <Route path="/clientes" element={<RegistroClientes/>}/>
                <Route path="/cumpleanos/:id" element={<DetalleCumpleano />}/>
                
            </Routes>
        </BrowserRouter>
    );
}

export default AppRouter;
