import React from "react";
import History from "./History";

function RaceResults(props) {

    return (

        <div>
                    <div>
                        <History competitieId={props.competitieId}/>
                    </div>
        </div>

    )

}

export default RaceResults;