import React from "react";
import "../algemeen/algemeen.css";
import "./login-page-css.css";

class LoginPage extends React.Component {
    render() {
        return (
            <div>
                <h1>Novi's competitiemanager</h1>

                <form action="">
                    <input type="text" placeholder="gebruikersnaam"/>
                    <br/>
                    <input type="password" placeholder="wachtwoord"/>
                    <br/>
                    <button>Login</button>
                    <p>een paar lieve woordjes.</p>
                </form>
            </div>
        );
    }
}

export default LoginPage;