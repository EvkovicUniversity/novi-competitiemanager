import React, {useState} from "react";
import DoeVoorspelling from "../DoeVoorspelling";

function OpkomendeRace(){

    const [open, setOpen] = useState(true);

        return (
            <div>
                <div className="competitieMenuContent">
                    <h1 className="uitklapbare_pijl" onClick={() => setOpen(!open)}> > </h1>
                    <h2 className="titel_CompetitieMenuContent">Opkomend</h2>
                </div>

                {open && <DoeVoorspelling/>}

            </div>
        )
}

export default OpkomendeRace;