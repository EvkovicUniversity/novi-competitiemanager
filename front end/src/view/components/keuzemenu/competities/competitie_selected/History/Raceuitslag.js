import React, {useState} from "react";
import fetchData from "../../../../../../controller/Data/fetchData";

function Raceuitslag(props) {
    const [open, setOpen] = useState(false);

    const {data: raceuitslagen, loading: ladenRaceuitslagen} = fetchData("http://localhost:8080/competitiemanager/competities/raceuitslagen/" + props.raceId);
    const raceuitslagenResult = Object.keys(raceuitslagen).map((key) => raceuitslagen[key]);
    let racenummer = props.racenummer;

    const {data: voorspellingen} = fetchData("http://localhost:8080/competitiemanager/user/voorspelling/raceuitslag/" + props.raceId)
    const voorspellingsdata = Object.keys(voorspellingen).map((key) => voorspellingen[key]);

    if (ladenRaceuitslagen) return <h1>Loading...</h1>;

    function findArrayElementByTitle(array, coureurnaam) {
        return array.find((element) => {
            return element.coureurNaam === coureurnaam;
        })
    }

    function voorspellingResultaat(coureurnaam, coureurEindpositie) {
        let array = [];
        let naamCoureurUitVoorspelling;
        let eindpositieVoorspelling;

        let voorspellingArray = findArrayElementByTitle(voorspellingsdata, coureurnaam);

        if (voorspellingArray !== undefined) {

            array = Object.values(voorspellingArray);
            naamCoureurUitVoorspelling = array[0];

            if (naamCoureurUitVoorspelling === coureurnaam) {
                eindpositieVoorspelling = array[1]
                if (coureurEindpositie === eindpositieVoorspelling) {
                    return '\u2705';
                } else {
                    return '\u274C';
                }
            }

        }

        return '-';
    }

    let uniqueKeyCounter = 0;
    return (

        <div>

            <div className="competitieMenuContent">

                <h2 className={!open ? "uitklapbare_pijl_ingeklapt" : "uitklapbare_pijl_uitgeklapt"} onClick={()=>setOpen(!open)}> {'\u276F'} </h2>
                <h2 className="titel_CompetitieMenuContent">Race {racenummer--}</h2>
            </div>

            {open &&

                <table className='tabel'>
                    <thead>
                    <tr>
                        <th className='tabelheaders' id='positieCel'>Positie</th>
                        <th className='tabelheaders'>Coureur</th>
                        <th className='tabelheaders'>Voorspelling</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        raceuitslagenResult.map(
                            coureur =>

                                <tr key={"raceTabel" + uniqueKeyCounter++}>

                                    <td className='tableRow1' id='positieWaarde'>{coureur.eindpositie}e</td>
                                    <td className='tableRow1'>{coureur.name}</td>
                                    <td className='tableRow1'

                                        id='voorspelling'>{voorspellingResultaat(coureur.name, coureur.eindpositie)}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            }
        </div>
    )
}

export default Raceuitslag;