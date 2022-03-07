import React from "react";
import '../competities.css';
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";
import CompetitieUitLijst from "../competitieUitLijst/competitieUitLijst";

function CompetitieLijst() {

    return (
        <div>
            <h1>Competities</h1>

            <div className='competitieLijstContainer'>

                <div className='enkeleCompetitieUitLijstContainer'>

                    <CompetitieUitLijst/>

                </div>
            </div>

            <button className='button01' onClick={NavigeerNaar('competities/creator')}>Create</button>
        </div>
    );
}

export default CompetitieLijst;
