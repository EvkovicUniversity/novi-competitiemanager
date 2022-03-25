import React from "react";
import navigeerNaar from "../../../../../controller/Navigatie/NavigeerNaar";

function ToonCompetitieNaam(props) {

    const path = "competities/" + props.competitieId;

    return (

        <div onClick={navigeerNaar(path)}>
                <p>{props.competitienaam}</p>
        </div>

    )
}

export default ToonCompetitieNaam;