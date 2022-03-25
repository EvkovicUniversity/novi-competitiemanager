import React from "react";
import fetchData from "../../../../../../controller/Data/fetchData";
import Raceuitslag from "./Raceuitslag";

function RaceUitslagMenu(props) {

    const {
        data,
        error,
        loading
    } = fetchData("http://localhost:8080/competitiemanager/competities/raceuitslagen/racesId/" + props.raceId);

    const result = Object.keys(data).map((key) => data[key]);
    let aantalRaces = result.length;

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);


    let uniqueKeyCounter = 0;
    return (
        <div>

            {result.map(
                races =>

                    <div key={"race" + uniqueKeyCounter++}>

                        <Raceuitslag raceId={races.id} racenummer={aantalRaces--}/>

                    </div>
            )}
        </div>
    )
}

export default RaceUitslagMenu;