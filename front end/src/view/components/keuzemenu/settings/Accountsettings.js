import React from "react";
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";

function Accountsettings() {

    return (
        <div>
            <h1>Account instellingen</h1>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings" onClick={NavigeerNaar('settings/gebruikersnaam-veranderen')}>
                <p>Verander gebruikersnaam</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings" onClick={NavigeerNaar('settings/wachtwoord-veranderen')}>
                <p>Verander wachtwoord</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenuknop_accountsettings" onClick={NavigeerNaar('settings/account-maken')}>
                <p>Creër een account</p>
            </div>

        </div>
    );
}

export default Accountsettings;
