import React, {useEffect, useState} from "react";
import axios from "axios";
import authService from "../../../../services/auth.service";
import AuthService from "../../../../services/auth.service";
import authHeader from "../../../../services/auth-header";
import Melding from "../../../components/melding/MeldingPopUp";
import Notificatie from "../../../components/melding/Notificatie";

const VeranderWachtwoord = () => {

    const [nieuwWachtwoord, setNieuwWachtwoord] = useState("");

    const [openMelding, setOpenMelding] = useState(false);
    const [openNotificatie, setOpenNotificatie] = useState(false);
    const [akkoord, setAkkoord] = useState(false);

    const meldingBericht = useState("U staat op het punt uw wachtwoord te wijzigen. U zal opnieuw moeten inloggen. Doorgaan?")

    const changeHandler = (e) => {
        const wachtwoord = e.target.value;
        setNieuwWachtwoord(wachtwoord);
    };

    useEffect(() => {
        if (akkoord) {
            axios.put("http://localhost:8080/user/changePassword/" + authService.getCurrentUser().username, [nieuwWachtwoord], {headers: authHeader()})
                .then((res) => {

                    if (res.status === 200) {
                        AuthService.logout();
                        window.location.reload();
                    } else {
                        setOpenNotificatie(true);
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
            {openNotificatie && <Notificatie status={400} openNotificatie={openNotificatie}
                                             setOpenNotificatie={setOpenNotificatie}/>}

            <h1>Wachtwoord wijzigen</h1>
            <p>voor {AuthService.getCurrentUser().username !== null ? AuthService.getCurrentUser().username : ""}</p>

            <form onSubmit={toonMelding}>
                <input type="password"
                       placeholder="Nieuw wachtwoord"
                       name="nieuwewachtwoord"
                       value={nieuwWachtwoord}
                       onChange={changeHandler}
                /><br/>

                <button className="button01">Doorgaan</button>
            </form>
        </div>
    )

}

export default VeranderWachtwoord;