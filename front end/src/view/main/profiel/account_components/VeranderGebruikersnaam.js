import React, {useState} from "react";
import axios from "axios";
import authHeader from "../../../../services/auth-header";
import AuthService from "../../../../services/auth.service";
import authService from "../../../../services/auth.service";

const VeranderGebruikersnaam = () => {

    const [nieuweGebruikersnaam, setNieuweGebruikersnaam] = useState("");
    const [openNotificatie, setOpenNotificatie] = useState(false);
    const [responseStatus, setResponseStatus] = useState(0);

    const changeHandler = (e) => {
        const username = e.target.value;
        setNieuweGebruikersnaam(username);
    };

    const submitHandler = (e) => {
        e.preventDefault();

        axios.put("http://localhost:8080/user/changeUsername/" + authService.getCurrentUser().username, [nieuweGebruikersnaam], {headers: authHeader()})
            .then((res) => {
                setResponseStatus(res.status);
                setOpenNotificatie(true);
            })
            .catch(err => {
                setOpenNotificatie(true);
            });
    }

    return (
        <div>
            <h1>Gebruikersnaam wijzigen</h1>
            <p>voor {AuthService.getCurrentUser().username}</p>

            <form onSubmit={submitHandler}>
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