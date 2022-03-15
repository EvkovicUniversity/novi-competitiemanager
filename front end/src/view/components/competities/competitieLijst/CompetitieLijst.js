import React from "react";
import './competitieLijst.css';
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";
import ToonCompetities from "../competitieLijst/ToonCompetities"

function CompetitieLijst() {

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

export default CompetitieLijst;
