import React, {useState} from "react";
import RaceUitslagMenu from "./RaceUitslagMenu";

function RaceResults() {

    const [open, setOpen] = useState(false);

    return (
        <div>
            <div className="competitieMenuContent">
                <h1 className="uitklapbare_pijl" onClick={() => setOpen(!open)}> > </h1>
                <h2 className="titel_CompetitieMenuContent">History</h2>
            </div>

            {open && <RaceUitslagMenu/>}

        </div>
    )

}

export default RaceResults;