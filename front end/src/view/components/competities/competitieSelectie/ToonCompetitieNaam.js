import React from "react";
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";

function ToonCompetitieNaam(props) {

    const path = 'competities/' + props.competitieId;

    return (

        <div onClick={NavigeerNaar(path)}>
            <p>{props.competitienaam}</p>
        </div>

    )
}

export default ToonCompetitieNaam;
