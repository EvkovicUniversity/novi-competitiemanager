import React from "react";
import {Link} from "react-router-dom";

function Accountsettings() {

    return (
        <div>
            <h1>Account instellingen</h1>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                <Link to={"/settings/gebruikersnaam-wijzigen"} className="Link">
                <p>Verander gebruikersnaam</p>
                </Link>
            </div>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                <Link to={"/settings/wachtwoord-wijzigen"} className="Link">
                    <p>Verander wachtwoord</p>
                </Link>
            </div>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings">
                <Link to={"/settings/account-maken"} className="Link">
                    <p>Creër een account</p>
                </Link>
            </div>

        </div>
    );
}

export default Accountsettings;
