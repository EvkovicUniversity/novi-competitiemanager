import React from "react";
import DataServices from "../../../../controller/services/DataServices";

class Competitie extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            raceUitslag: [],
            competitieinfo: []
        }
    }

    componentDidMount() {
        const getUrl = window.location.href;
        const urlParsed = getUrl.replace('http://localhost:3000', '');

        DataServices.getData("http://localhost:8080/formula1/coureurs")
            .then((res) => {
                this.setState({raceUitslag: res.data})
            })
        DataServices.getData("http://localhost:8080/formula1" + urlParsed)
            .then((res) => {
                this.setState({competitieinfo: res.data})
            })
    }


    render() {
        return (
            <div>

                <h1>{this.state.competitieinfo.competitienaam}</h1>

                <div className={'tabelContainer'}>
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
            </div>
        )
    }

}

export default Competitie
