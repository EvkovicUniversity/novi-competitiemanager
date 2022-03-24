import React, {useState} from "react";
import fetchData from "../../../../../../controller/Data/fetchData";
import Raceuitslag from "./Raceuitslag";

function RaceUitslagMenu(props) {

    const {data, error, loading} = fetchData("http://localhost:8080/competitiemanager/competities/raceuitslagen/racesId/" + props.raceId);
    const result = Object.keys(data).map((key) => data[key]);

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);
    let aantalRaces = result.length;

    let uniqueKeyCounter=0;
    return (
        <div>

            {result.map(
                races =>
                    <div key={"race"+uniqueKeyCounter++}>
                        <Raceuitslag raceId={races.id} racenummer={aantalRaces+1}/>
                    </div>
            )}

        </div>

    )
}

export default RaceUitslagMenu;