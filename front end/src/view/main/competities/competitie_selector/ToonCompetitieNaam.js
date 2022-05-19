import React from "react";
import navigeerNaar from "../../../../controller/Navigatie/NavigeerNaar";

function ToonCompetitieNaam(props) {

    const path = "competities/" + props.competitieId;

    return (

        <hgroup onClick={navigeerNaar(path)}>
                <p>{props.competitienaam}</p>
        </hgroup>

    )
}

export default ToonCompetitieNaam;