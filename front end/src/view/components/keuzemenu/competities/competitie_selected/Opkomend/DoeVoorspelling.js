import React, {useEffect, useState} from "react";
import fetchData from "../../../../../../controller/Data/fetchData";
import Melding from "../../../../melding/Melding";
import axios from "axios";


function doeVoorspelling(props) {

    const {data, loading, error} = fetchData(false, "http://localhost:8080/competitiemanager/formula1/vanillaCoureurs");
    const result = Object.keys(data).map((key) => data[key])

    const [openMelding, setOpenMelding] = useState(false);
    const [akkoord, setAkkoord] = useState(false);


    const [competitieInfo, setCompetitieInfo] = useState(props.competitieId);
    const [raceInfo, setRaceInfo] = useState(props.competitieId);
    const [voorspelling, setVoorspelling] = useState();

    const [postdata, setPostdata] = useState([]);
    let meldingBericht = useState("U doet een voorspelling, wilt u doorgaan?");

    function clickVoorspel(e) {
        e.preventDefault();
        setOpenMelding(!openMelding)
    }

    function handleSubmit(e) {
        postdata.push(voorspelling);
        postdata.push(competitieInfo);
        axios.post("http://localhost:8080/competitiemanager/user/formula1/voorspelling/" + props.competitieId, {
            postdata
        })
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    useEffect(() => {
        if (akkoord === true) {
            console.log("postdata: " + voorspelling)
            handleSubmit();
        }
    }, [akkoord]);

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);


    function handleChange(e) {
        setVoorspelling(e.target.value)
    }

    return (
        <div>
            {openMelding && <Melding bericht={meldingBericht} openMelding={setOpenMelding} akkoord={setAkkoord}/>}

            <p>Wie gaat de volgende race winnen?</p>

            <form>
                {/*<select onChange={e => setPostdata(e.target.value)}>*/}
                <select onChange={handleChange}>
                    <option value="default">Kies een coureur:</option>

                    {
                        result.map(
                            coureur =>
                                <option value={coureur.name} key={coureur.id}>{coureur.name}</option>
                        )
                    }

                </select>

                <button className="button01" onClick={clickVoorspel} >Voorspel!</button>
            </form>


            {/*<form onSubmit={handleSubmit}>*/}

            {/*    <button type='submit' className="button01" onClick={clickVoorspel}>Voorspel</button>*/}
            {/*    {openMelding && <Melding bericht={meldingBericht} openMelding={setOpenMelding} akkoord={setAkkoord}/>}*/}

            {/*    <table className='tabel'>*/}

            {/*        <thead>*/}
            {/*        <tr>*/}
            {/*            <th className='tabelheaders' id="positieCel">Coureur</th>*/}
            {/*            <th className='tabelheaders'>Voorspel <br/> eindpositie</th>*/}
            {/*        </tr>*/}
            {/*        </thead>*/}
            {/*        <tbody>*/}

            {/*        {*/}
            {/*            result.map(*/}
            {/*                coureur =>*/}
            {/*                    <tr key={dummy++}>*/}
            {/*                        <td className="tableRow1">{coureur.name}</td>*/}
            {/*                        <td className="tableRow2"><input type='text'*/}
            {/*                                                         id="input_voorspelling"*/}
            {/*                                                         key={coureur.name}*/}
            {/*                                                         name={coureur.name}*/}
            {/*                                                         onChange={handleChange}*/}
            {/*                        />*/}
            {/*                        </td>*/}
            {/*                    </tr>*/}
            {/*            )*/}
            {/*        }*/}

            {/*        </tbody>*/}
            {/*    </table>*/}
            {/*</form>*/}
        </div>
    );
}

export default doeVoorspelling;
