import React, {useState} from "react";
import RaceUitslagMenu from "./RaceUitslagMenu";
import fetchData from "../../../../../../controller/Data/fetchData";

function history(props) {

    const [open, setOpen] = useState(false)

    const data = fetchData("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/" + props.competitieId)
    const raceId = Object.keys(data).map((key) => data[key]);

    return (
        <div>

                    <div>
                        <div className="competitieMenuContent">
                            <h1 className={!open ? "uitklapbare_pijl_ingeklapt" : "uitklapbare_pijl_uitgeklapt"} onClick={() => setOpen(!open)}> {'\u276F'} </h1>
                            <h2 className="titel_CompetitieMenuContent">History</h2>
                        </div>

                        {open && <RaceUitslagMenu
                            raceId={raceId[0]}
                        />}
                    </div>

        </div>
    )
}

export default history;