import React from "react";
import NavigeerNaar from "../../../../controller/Navigatie/navigeerNaar";

function CompetitieUitLijst() {

    return(

    <div onClick={NavigeerNaar('competities/:competitieid')}>
        <p>&#123; Competitienaam &#125;</p>
    </div>

    )
}

export default CompetitieUitLijst;
