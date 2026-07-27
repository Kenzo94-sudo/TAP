import { useState } from "react" ;
import "./Sidebar.css";
import {NavLink} from "react-router-dom";

import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PointOfSaleIcon from "@mui/icons-material/PointOfSale";
import PersonIcon from "@mui/icons-material/Person";
import LogoutIcon from "@mui/icons-material/Logout";
import ArrowForwardRoundedIcon from '@mui/icons-material/ArrowForwardRounded';

import panda from '../assets/panda.png'

function Sidebar(){

    const [isClosed, setIsClosed] = useState(true);

    const handleToggle = () => {setIsClosed(!isClosed);
    };
    return(

        <aside className={`sidebar ${isClosed ? "close" : "" } `}>
            <div className="sidebar-logo">
               <img className="panda" src={panda} alt="Panda"/>
                <button className="toggle" onClick={handleToggle}>
                    <ArrowForwardRoundedIcon/>
                </button>
            </div>

            <nav>
                <ul>
                    <li>
                    <NavLink to="/menu" className="menu-link">
                        <DashboardIcon/>
                        <span className="text">Dashboard</span>
                    </NavLink>    
                    </li>

                    <li>
                        <NavLink to="/clientes" className="menu-link">
                            <GroupsIcon />
                            <span className="text">Clientes y Niños</span>
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/reservas" className="menu-link">
                            <CalendarMonthIcon />
                            <span className="text">Reservas</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/caja" className="menu-link">
                            <PointOfSaleIcon />
                            <span className="text">Caja</span>
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/usuarios" className="menu-link">
                            <PersonIcon />
                            <span className="text">Usuarios</span>
                        </NavLink>
                    </li>
                </ul>
            </nav>

            <div className="sidebar-footer">
                <button className="logout-btn">
                    <LogoutIcon />
                    <span className="text">Cerrar sesión</span>
                </button>
            </div>
        </aside>
    );
}

export default Sidebar;