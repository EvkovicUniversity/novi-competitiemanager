import React from "react";
import "../algemeen/algemeen.css";
import "./login-page-css.css";
import NavigeerNaar from "../../../controller/Navigatie/navigeerNaar";

function LoginPage(){

        return (
            <div>
                <h1>Novi's competitiemanager</h1>

                <form action="">
                    <input type="text"
                           placeholder="gebruikersnaam"
                           className="login_invoervelden"
                           id="username_input"/>
                    <br/>
                    <input type="password"
                           placeholder="wachtwoord"
                           className="login_invoervelden"
                           id="password_input"/>
                    <br/>
                    <button className="button01" id="login_button" onClick={NavigeerNaar('menu')}>Login</button>
                </form>

                <p id="geen_wachtwoord_paragraaf">
                    Neem contact op met de beheerder in geval van
                    wachtwoord vergeten of het aanmaken van een account.
                </p>
            </div>
        );
    }
// }

export default LoginPage;
