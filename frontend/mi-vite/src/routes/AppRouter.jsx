import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../pages/login/login";
import MenuPrincipal from "../pages/menuPrincipal/menu";

function AppRouter() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/menu" element={<MenuPrincipal />} />
            </Routes>
        </BrowserRouter>
    );
}

export default AppRouter;
