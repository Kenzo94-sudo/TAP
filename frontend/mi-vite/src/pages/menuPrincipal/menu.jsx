import { useEffect, useState } from "react";
import "./menu.css";

import Sidebar from "../../components/Sidebar";
import Navbar from "../../components/Navbar";
import Card from "../../components/Card";


import GroupsIcon from "@mui/icons-material/Groups";
import ChildCareIcon from "@mui/icons-material/ChildCare";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import PointOfSaleIcon from "@mui/icons-material/PointOfSale";

import axios from "axios";


function MenuPrincipal() {
    const [dashboard, setDashboard] = useState({
        clientes: 0,
        ninos: 0,
        reservas: 0,
        caja: 0
    });

    useEffect(()=>{
        obtenerDatosDashboard();

    },[]);

    const obtenerDatosDashboard = async()=>{
        try{
            const response = await axios.get(
                "http://localhost:8080/api/dashboard"
            );
            setDashboard(response.data);
        }catch(error){
            console.error(
                "Error al cargar dashboard:",
                error
            );
        }
    };

    const cards = [
        {
            title:"Clientes",
            value:dashboard.clientes,
            icon:<GroupsIcon fontSize="large"/>
        },
        {
            title:"Niños",
            value:dashboard.ninos,
            icon:<ChildCareIcon fontSize="large"/>
        },
        {
            title:"Reservas",
            value:dashboard.reservas,
            icon:<CalendarMonthIcon fontSize="large"/>
        },
        {
            title:"Caja",
            value:`S/ ${dashboard.caja}`,
            icon:<PointOfSaleIcon fontSize="large"/>
        }
    ];

    return (
        <div className="dashboard">
            <Sidebar/>
            <div className="dashboard-content">
                <Navbar/>
                <main className="dashboard-body">
                    <h1>
                        Bienvenido al Sistema YUPI
                    </h1>
                    <p>
                        Gestiona clientes, niños, reservas y caja en tiempo real.
                    </p>
                    <div className="cards">
                        {
                            cards.map((card,index)=>(

                                <Card
                                    key={index}
                                    title={card.title}
                                    value={card.value}
                                    icon={card.icon}
                                />

                            ))
                        }
                    </div>
                </main>
            </div>
        </div>
    );
}
export default MenuPrincipal;