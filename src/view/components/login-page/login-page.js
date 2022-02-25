import "../algemeen/algemeen.css";
import "./login-page-css.css";

function LoginPage() {
    return (
        <div>
            <h1>Novi's competitiemanager</h1>

            <form action="">
                <input type="text" placeholder="gebruikersnaam" />
                <br/>
                <input type="password" placeholder="wachtwoord"/>
                <br/>
                <button>Login</button>
                <p>een paar lieve woordjes.</p>
            </form>
        </div>
    );
}

export default LoginPage;