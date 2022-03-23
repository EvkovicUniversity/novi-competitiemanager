import React from "react";
import NavigeerNaar from "../../../../../controller/Navigatie/navigeerNaar";
import ToonCompetitiesTerSelectie from "./ToonCompetitiesTerSelectie";


function CompetitieSelector() {

    return (
        <div>
            <h1>Competities</h1>

            <div className='competitieLijstContainer'>
                <ToonCompetitiesTerSelectie/>
            </div>

            <button className='button01' onClick={NavigeerNaar('competities/creator')}>Create</button>
        </div>
    );
}

export default CompetitieSelector;
