import React, {Component} from "react";
import DataServices from "../../../../controller/services/DataServices";

class RaceUitslag extends Component {
    constructor(props) {
        super(props)
        this.componentInfo = this.componentInfo.bind(this);

        this.state = {
            raceUitslag: [],
        }
    }

    componentInfo(id, racenummer) {
        this.props.raceId(id);
        this.props.racenummer(racenummer)
    }

    componentDidMount() {
        (DataServices.getData("http://localhost:8080/competities/raceuitslagen/" + this.props.raceId)
            .then((res) => {
                this.setState({raceUitslag: res.data})
            }))
    }

    render() {

        let voorspelling = 0;
        if (voorspelling === 0) {
            voorspelling = '-';
        } else voorspelling = 2;

        return (

            <div>
                <table className='tabel'>
                    <thead>
                    <tr>
                        <th className='tabelheaders' id='positieCel'>Positie</th>
                        <th className='tabelheaders'>Coureur</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.raceUitslag.map(
                            coureur =>
                                <tr key={coureur.id}>
                                    <td className='tableRow' id='positieWaarde'>{coureur.eindpositie}e</td>
                                    <td className='tableRow'>{coureur.name}</td>
                                    <td className='tableRow' id='voorspelling'>{voorspelling}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default RaceUitslag;