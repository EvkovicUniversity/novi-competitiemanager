import React from "react";
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";
import ToonCompetities from ".//ToonCompetities"

function CompetitieSelecteren() {

    return (
        <div>
            <h1>Competities</h1>

            <div className='competitieLijstContainer'>
                <ToonCompetities/>
            </div>

            <button className='button01' onClick={NavigeerNaar('competities/creator')}>Create</button>
        </div>
    );
}

export default CompetitieSelecteren;
