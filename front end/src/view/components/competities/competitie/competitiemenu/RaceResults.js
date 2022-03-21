import React, {useState} from "react";
import RaceUitslagMenu from "./RaceUitslagMenu";
import fetchData from "../../../../../controller/Data/fetchData";
import OpkomendeRace from "./OpkomendeRace";
import History from "./History";

function RaceResults(props) {

    // const {data, loading} = fetchData("http://localhost:8080/competities/raceuitslagen/raceId/" + props.competitieId)

    return (

        <div>
                    <div>
                        <History competitieId={props.competitieId}/>
                    </div>
        </div>

    )

}

export default RaceResults;