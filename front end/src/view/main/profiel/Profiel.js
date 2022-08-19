import React from "react";
import AuthService from "../../../services/auth.service";
import {Link} from "react-router-dom";

const Profiel = () => {
    const currentUser = AuthService.getCurrentUser();
    return (
        <div>
            <header>

                <h1>Hi, {currentUser.username}!</h1>

            </header>

            <div>
                <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                    <Link to={"/profile/gebruikersnaam-wijzigen"} className="Link">
                        <p>Verander gebruikersnaam</p>
                    </Link>
                </div>

                <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                    <Link to={"/profile/wachtwoord-wijzigen"} className="Link">
                        <p>Verander wachtwoord</p>
                    </Link>
                </div>

                <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                    <Link to={"/profile/account-maken"} className="Link">
                        <p>Creër een account</p>
                    </Link>
                </div>
            </div>

        </div>
    );
};
export default Profiel;
