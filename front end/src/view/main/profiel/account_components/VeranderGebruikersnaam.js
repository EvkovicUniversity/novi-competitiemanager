import React, {useEffect, useState} from "react";
import axios from "axios";
import authHeader from "../../../../services/auth-header";
import AuthService from "../../../../services/auth.service";
import authService from "../../../../services/auth.service";
import Melding from "../../../components/melding/MeldingPopUp";

const VeranderGebruikersnaam = () => {

    const [nieuweGebruikersnaam, setNieuweGebruikersnaam] = useState("");

    const [openMelding, setOpenMelding] = useState(false);
    const [akkoord, setAkkoord] = useState(false);

    const meldingBericht = useState("U staat op het punt uw gebruikersnaam te wijzigen. U zal opnieuw moeten inloggen. Doorgaan?")

    const changeHandler = (e) => {
        const username = e.target.value;
        setNieuweGebruikersnaam(username);
    };

    useEffect(() => {
        if (akkoord) {
            axios.put("http://localhost:8080/user/changeUsername/" + authService.getCurrentUser().username, [nieuweGebruikersnaam], {headers: authHeader()})
                .then((res) => {

                    if (res.status === 200) {
                        AuthService.logout();
                        window.location.reload();
                    }
                })
                .catch(err => {
                });
        }
    }, [akkoord])

    function toonMelding(e) {
        e.preventDefault();
        setOpenMelding(!openMelding);
    }

    return (
        <div>

            {openMelding && <Melding bericht={meldingBericht} openMelding={setOpenMelding} akkoord={setAkkoord}/>}

            <h1>Gebruikersnaam wijzigen</h1>
            <p>voor {AuthService.getCurrentUser().username}</p>

            <form onSubmit={toonMelding}>
                <input type="text"
                       placeholder="Nieuwe gebruikersnaam"
                       name="nieuwegebruikersnaam"
                       value={nieuweGebruikersnaam}
                       onChange={changeHandler}
                /><br/>

                <button className="button01">Doorgaan</button>
            </form>
        </div>
    );
}

export default VeranderGebruikersnaam;