import React from "react";
import AuthService from "../../../services/auth.service";
import {Link} from "react-router-dom";

const Profile = () => {
    const currentUser = AuthService.getCurrentUser();
    return (
        <main>
            <header className="jumbotron">

                <h1>Mijn Profiel</h1>

                <h3>
                    Hi, <strong>{currentUser.username}</strong>!
                </h3>
            </header>
            <p>
                <strong>Email:</strong> {currentUser.email}
            </p>
            <strong>Authorities:</strong>
            <ul>
                {currentUser.roles &&
                    currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
            </ul>

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

        </main>
    );
};
export default Profile;
