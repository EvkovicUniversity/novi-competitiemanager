import React from "react";
import fetchData from "../../../../../controller/Data/fetchData";

function Raceuitslag(props) {

    const {data, loading} = fetchData("http://localhost:8080/competities/raceuitslagen/" + props.raceId);
    const raceuitslagenResult = Object.keys(data).map((key) => data[key]);


    const {data: voorspellingen} = fetchData("http://localhost:8080/user/voorspelling/raceuitslag/" + props.raceId)
    const voorspellingsdata = Object.keys(voorspellingen).map((key) => voorspellingen[key]);

    if (loading) return <h1>Loading...</h1>;

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

        console.log(voorspellingArray);

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

    return (

        <div>

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

                            <tr key={coureur.id}>
                                <td className='tableRow' id='positieWaarde'>{coureur.eindpositie}e</td>
                                <td className='tableRow'>{coureur.name}</td>
                                <td className='tableRow'
                                    id='voorspelling'>{voorspellingResultaat(coureur.name, coureur.eindpositie)}</td>
                            </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    )
}

export default Raceuitslag;