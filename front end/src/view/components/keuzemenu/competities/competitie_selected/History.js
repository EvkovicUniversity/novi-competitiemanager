import React, {useState} from "react";
import RaceUitslagMenu from "./RaceUitslagMenu";
import fetchData from "../../../../../controller/Data/fetchData";

function history(props) {

    const [open, setOpen] = useState(false)

    const {data, loading} = fetchData("http://localhost:8080/competities/raceuitslagen/raceId/" + props.competitieId)

    if (loading) return <h1>Loading...</h1>

    return (
        <div>

                    <div>
                        <div className="competitieMenuContent">
                            <h1 className="uitklapbare_pijl" onClick={() => setOpen(!open)}> {'\u276F'} </h1>
                            <h2 className="titel_CompetitieMenuContent">History</h2>
                        </div>

                        {open && <RaceUitslagMenu
                            raceId={data}
                        />}
                    </div>

        </div>
    )
}

export default history;