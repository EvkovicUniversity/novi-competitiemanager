import React from "react";
import "./keuzemenu.css";
import {Link} from "react-router-dom";
import AuthService from "../../../services/auth.service";

function logout() {
    AuthService.logout();
}

function Keuzemenu() {

    return (
        <menu>

            <nav>
                <ol>
                    <li className="keuzemenuknop" id="keuzemenu_01">
                        <Link to={"/competities"} className="Link">
                            <p>Competities bekijken</p>
                        </Link>
                    </li>
                </ol>

                <ol>
                    <li className="keuzemenuknop" id="keuzemenu_02">
                        <Link to={"/profile"} className="Link">
                            <p>Mijn profiel</p>
                        </Link>
                    </li>
                </ol>

                <ol>
                    <li className="keuzemenuknop" id="keuzemenu_03" onClick={logout}>
                        <Link to={"/"} className={"Link"}>
                            <p>Uitloggen</p>
                        </Link>
                    </li>
                </ol>
            </nav>
        </menu>
    )
}

export default Keuzemenu;
