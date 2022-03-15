import React, {useState} from "react";
import RaceUitslag from "../RaceUitslag";

function RaceUitslagMenu() {

    const [open, setOpen] = useState(false);

    return (
        <div>
            <div className="competitieMenuContent">
                <h2 className="uitklapbare_pijl" onClick={() => setOpen(!open)}> > </h2>
                <h2 className="titel_CompetitieMenuContent">Race 1</h2>
            </div>

            {open && <RaceUitslag/>}

        </div>
    )
}

export default RaceUitslagMenu;