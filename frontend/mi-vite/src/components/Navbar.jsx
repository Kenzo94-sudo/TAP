import "./Navbar.css";

import NotificationsIcon from "@mui/icons-material/Notifications";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";

function Navbar(){

    return(

        <header className="navbar">

            <h2>Dashboard</h2>

            <div className="navbar-user">

                <NotificationsIcon/>

                <AccountCircleIcon/>

                <span>Administrador</span>

            </div>

        </header>

    );

}

export default Navbar;