import React, {useEffect, useState} from "react";
import OpkomendeRace from "./Opkomend/OpkomendeRace";
import History from "./History/History";
import axios from "axios";
import fetchData from "../../../../../controller/Data/fetchData";
import Melding from "../../../../components/melding/MeldingPopUp";
import Notificatie from "../../../../components/melding/Notificatie";

function CompetitieSelected() {

    function fetchCompInfo() {
        const getUrl = window.location.href;
        const urlParsed = getUrl.replace("http://localhost:3000", "");

        return fetchData(false, "http://localhost:8080/competitiemanager/formula1" + urlParsed)
    }
    const {data, loading, error} = fetchCompInfo();
    const result = Object.keys(data).map((key) => data[key]);

    const [openMelding, setOpenMelding] = useState(false);
    const [akkoord, setAkkoord] = useState(false);

    const [status, setStatus] = useState(0);
    const [openNotificatie, setOpenNotificatie] = useState(false);

    const raceMelding = useState("U gaat een nieuwe race beginnen, doorgaan?")

    useEffect(() => {
        if (akkoord) {

            axios.post("http://localhost:8080/competitiemanager/formula1/playmatch/" + result[0])
                .then((res) => {
                    setStatus(res.status);
                })
                .then(() => {
                    setOpenNotificatie(true);
                })
                .catch((err) => {
                    setStatus(400)
                    setOpenNotificatie(true);
                })
        }
    }, [akkoord])

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);

    return (
        <main>

            <h1>{result[1]}</h1>

            <div className='competitieMenuContainer'>

                <div className="competitieMenuInhoudContainer">
                    <OpkomendeRace competitieId={result[0]}/>
                </div>

                <div className="competitieMenuInhoudContainer">
                    <History competitieId={result[0]}/>
                </div>

            </div>

            <button className="button01" onClick={() => setOpenMelding(!openMelding)} >Race!</button>

            {openMelding && <Melding bericht={raceMelding} openMelding={setOpenMelding} akkoord={setAkkoord}/>}
            {openNotificatie && <Notificatie status={status} openNotificatie={setOpenNotificatie} />}


        </main>
    )

}

export default CompetitieSelected
