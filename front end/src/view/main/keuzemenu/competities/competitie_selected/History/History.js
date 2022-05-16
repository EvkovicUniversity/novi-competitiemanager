import React, {useState} from "react";
import RaceUitslagMenu from "./RaceUitslagMenu";
import fetchData from "../../../../../../controller/Data/fetchData";

function history(props) {
    const {data, loading, error} = fetchData(props.competitieId,
            "http://localhost:8080/competitiemanager/formula1/competities/raceuitslagen/raceId/" + props.competitieId);

    const [open, setOpen] = useState(false)


    if (loading) return <h1>Loading...</h1>
    if (error) return console.log(error);

    return (
        <div>
                    <div>
                        <div className="competitieMenuContent">
                            <h1 className={!open ? "uitklapbare_pijl_ingeklapt" : "uitklapbare_pijl_uitgeklapt"} onClick={() => setOpen(!open)}> {'\u276F'} </h1>
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
