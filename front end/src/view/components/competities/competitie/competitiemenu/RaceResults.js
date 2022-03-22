import React from "react";
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