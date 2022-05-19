import React from "react";

import ToonCompetitiesTerSelectie from "./ToonCompetitiesTerSelectie";
import {Link} from "react-router-dom";


function CompetitieSelector() {

    return (
        <div>
            <h1>Competities</h1>

            <menu className='competitieLijstContainer'>
                <ToonCompetitiesTerSelectie/>
            </menu>

            <button className='button01'>
                <Link to={"/CompetitieCreator"} className="Link" id="LinkButton">
                    Create
                </Link>
            </button>
        </div>
    );
}

export default CompetitieSelector;
