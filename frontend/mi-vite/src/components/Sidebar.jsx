<<<<<<< HEAD
import { useState } from "react" ;
=======
>>>>>>> master
import "./Sidebar.css";
import {NavLink} from "react-router-dom";

import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PointOfSaleIcon from "@mui/icons-material/PointOfSale";
import PersonIcon from "@mui/icons-material/Person";
import LogoutIcon from "@mui/icons-material/Logout";
<<<<<<< HEAD
import ArrowForwardRoundedIcon from '@mui/icons-material/ArrowForwardRounded';

function Sidebar(){

    const [isClosed, setIsClosed] = useState(true);

    const handleToggle = () => {setIsClosed(!isClosed);
    };
    return(

        <aside className={`sidebar ${isClosed ? "close" : "" } `}>
            <div className="sidebar-logo">
                <span className="text">YUPI</span>
                <span className="text">Playground</span>
                <button className="toggle" onClick={handleToggle}>
                    <ArrowForwardRoundedIcon/>
                </button>
=======

function Sidebar(){

    return(

        <aside className="sidebar">

            <div className="sidebar-logo">
                <h2>YUPI</h2>
                <span>Playground</span>
>>>>>>> master
            </div>

            <nav>
                <ul>
<<<<<<< HEAD
                    <li>
                    <NavLink to="/menu" className="menu-link">
                        <DashboardIcon/>
                        <span className="text">Dashboard</span>
=======

                    <li>
                    <NavLink to="/menu" className="menu-link">
                        <DashboardIcon/>
                        <span>Dashboard</span>
>>>>>>> master
                    </NavLink>    
                    </li>

                    <li>
                        <NavLink to="/clientes" className="menu-link">
                            <GroupsIcon />
<<<<<<< HEAD
                            <span className="text">Clientes y Niños</span>
=======
                            <span>Clientes y Niños</span>
>>>>>>> master
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/reservas" className="menu-link">
                            <CalendarMonthIcon />
<<<<<<< HEAD
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
=======
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

>>>>>>> master
}

export default Sidebar;