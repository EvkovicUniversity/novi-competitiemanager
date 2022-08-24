import React, {useState} from "react";
import DoeVoorspelling from "./DoeVoorspelling";

function OpkomendeRace(props) {

    const [open, setOpen] = useState(true);

    return (
        <div>
            <div className="competitieMenuContent">
                <h1 className={!open ? "uitklapbare_pijl_ingeklapt" : "uitklapbare_pijl_uitgeklapt"}
                    onClick={() => setOpen(!open)}> {'\u276F'} </h1>
                <h2 className="titel_CompetitieMenuContent">Opkomend</h2>
            </div>

            {open && <DoeVoorspelling competitieId={props.competitieId}/>}

        </div>
    )
}

export default OpkomendeRace;
