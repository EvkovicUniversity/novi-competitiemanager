import React from "react";
import DataServices from "../../../../controller/services/DataServices";

class RaceUitslag extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            raceUitslag: []
        }
    }

    componentDidMount() {
        DataServices.getData("http://localhost:8080/formula1/coureurs")
            .then((res) => {
                this.setState({raceUitslag: res.data})
            })
    }

    render() {

        return (

            <div>
                <table className='tabel'>
                    <tr>
                        <th className='tabelheaders' id='positieCel'>Positie</th>
                        <th className='tabelheaders'>Coureur</th>
                    </tr>
                    {
                        this.state.raceUitslag.map(
                            coureur =>
                                <tr key={coureur.id}>
                                    <td className='tableRow' id='positieWaarde'>{coureur.id}e</td>
                                    <td className='tableRow'>{coureur.name}</td>
                                </tr>
                        )
                    }
                </table>
            </div>
        )
    }
}

export default RaceUitslag;