import "./Sidebar.css";
import {NavLink} from "react-router-dom";

import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PointOfSaleIcon from "@mui/icons-material/PointOfSale";
import PersonIcon from "@mui/icons-material/Person";
import LogoutIcon from "@mui/icons-material/Logout";

function Sidebar(){

    return(

        <aside className="sidebar">

            <div className="sidebar-logo">
                <h2>YUPI</h2>
                <span>Playground</span>
            </div>

            <nav>
                <ul>

                    <li>
                    <NavLink to="/menu" className="menu-link">
                        <DashboardIcon/>
                        <span>Dashboard</span>
                    </NavLink>    
                    </li>

                    <li>
                        <NavLink to="/clientes" className="menu-link">
                            <GroupsIcon />
                            <span>Clientes y Niños</span>
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/reservas" className="menu-link">
                            <CalendarMonthIcon />
                            <span>Reservas</span>
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/caja" className="menu-link">
                            <PointOfSaleIcon />
                            <span>Caja</span>
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/usuarios" className="menu-link">
                            <PersonIcon />
                            <span>Usuarios</span>
                        </NavLink>
                    </li>

                </ul>
            </nav>
        
            <div className="sidebar-footer">

                <button className="logout-btn">

                    <LogoutIcon />

                    <span>Cerrar sesión</span>

                </button>

            </div>

        </aside>


    );

}

export default Sidebar;