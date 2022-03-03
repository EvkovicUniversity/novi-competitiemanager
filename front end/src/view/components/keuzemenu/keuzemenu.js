import React from "react";
import "./keuzemenu.css";
import NavigeerNaar from "../../../controller/Navigatie/navigeerNaar";

function Keuzemenu() {

    return(
        <div>
            <div className="keuzemenuknop" id="keuzemenu_01" onClick={NavigeerNaar('competities')}>
                <p>Competities bekijken</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenu_02" onClick={NavigeerNaar('settings')}>
                <p>Account instellingen</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenu_03" onClick={NavigeerNaar('')}>
                <p>Uitloggen</p>
            </div>
        </div>
    )
}

export default Keuzemenu;
