import React from "react";
import {Link} from "react-router-dom";

function ToonCompetitieNaam(props) {

    const path = "competities/" + props.competitieId;

    return (

        <div>
            <Link to={path} className="Link">
                <p>{props.competitienaam}</p>
            </Link>
        </div>

    )
}

export default ToonCompetitieNaam;