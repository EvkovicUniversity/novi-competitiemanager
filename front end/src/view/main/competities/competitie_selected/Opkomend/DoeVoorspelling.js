import React, {useEffect, useState} from "react";
import fetchData from "../../../../../controller/Data/fetchData";
import Melding from "../../../../components/melding/MeldingPopUp";
import axios from "axios";
import Notificatie from "../../../../components/melding/Notificatie";
import authHeader from "../../../../../services/auth-header";


function doeVoorspelling(props) {

    const {data, loading, error} = fetchData(false, "http://localhost:8080/competitiemanager/formula1/vanillaCoureurs");
    const result = Object.keys(data).map((key) => data[key])

    const [openMelding, setOpenMelding] = useState(false);
    const [akkoord, setAkkoord] = useState(false);

    const [status, setStatus] = useState(0);
    const [openNotificatie, setOpenNotificatie] = useState(false);


    const [competitieInfo] = useState(props.competitieId);
    const [voorspelling, setVoorspelling] = useState();

    const [postdata] = useState([]);
    let meldingBericht = useState("U doet een voorspelling, wilt u doorgaan?");

    function clickVoorspel(e) {
        e.preventDefault();
        setOpenMelding(!openMelding)
    }

    function handleSubmit(e) {
        postdata.push(voorspelling);
        postdata.push(competitieInfo);
        axios.post("http://localhost:8080/competitiemanager/formula1/user/formula1/voorspelling/" + props.competitieId, {
            postdata
        }, {headers: authHeader()})
            .then((response) => {
                setStatus(response.status);
                console.log(status);
            })
            .then(() => {
                setOpenNotificatie(true);
            })
            .catch((error) => {
                setStatus(400);
                setOpenNotificatie(true);
            })
    }

    useEffect(() => {
        if (akkoord === true) {
            handleSubmit();
        }
    }, [akkoord]);

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);


    function handleChange(e) {
        setVoorspelling(e.target.value)
    }

    let keyCount = 1;

    return (
        <div>

            {openMelding && <Melding bericht={meldingBericht} openMelding={setOpenMelding} akkoord={setAkkoord}/>}
            {openNotificatie && <Notificatie status={status} openNotificatie={openNotificatie}
                                             setOpenNotificatie={setOpenNotificatie}/>}

            <p>Wie gaat de volgende race winnen?</p>

            <form>
                <select onChange={handleChange}>
                    <option value="default" key="default">Kies een coureur:</option>

                    {
                        result.map(
                            coureur =>
                                <option value={coureur.name} key={coureur.name + keyCount++}>{coureur.name}</option>
                        )
                    }

                </select>

                <button className="button01" onClick={clickVoorspel}>Voorspel!</button>
            </form>

        </div>
    );
}

export default doeVoorspelling;
