import React, {useState} from "react";
import RaceUitslag from "../RaceUitslag";
import fetchData from "../../../../../controller/Data/fetchData";

function RaceUitslagMenu(props) {
    const [open, setOpen] = useState(false);

    const {data, error, loading} = fetchData("http://localhost:8080/competities/raceuitslagen/racesId/" + props.raceId);
    const result = Object.keys(data).map((key) => data[key]);

    if (loading) return <h1>Loading...</h1>;
    if (error) console.log(error);
    let aantalRaces = result.length;

    return (
        <div>

            {result.map(
                races =>
                    <div>
                        <div className="competitieMenuContent">
                            <h2 className="uitklapbare_pijl" onClick={() => setOpen(!open)}> > </h2>
                            <h2 className="titel_CompetitieMenuContent">Race {aantalRaces--}</h2>
                        </div>

                        {open && <RaceUitslag raceId={races.id} racenummer={aantalRaces+1}/> }
                    </div>
            )}

        </div>

    )
}

export default RaceUitslagMenu;