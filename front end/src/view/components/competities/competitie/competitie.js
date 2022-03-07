import React from "react";
import DataServices from "../../../../controller/services/DataServices";

class Competitie extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            coureurs: []
        }
    }

    componentDidMount() {
        DataServices.getData("http://localhost:8080/formula1/coureurs")
            .then((res) => {
                this.setState({coureurs: res.data})
            })
    }

    render() {
        return (
            <div>

                <h1>{} Competitionez</h1>

                <div className={'tabelContainer'}>
                    <table className='tabel'>
                        <tr>
                            <th className='tabelheaders' id='positieCel'>Positie</th>
                            <th className='tabelheaders'>Coureur</th>
                        </tr>
                        {
                            this.state.coureurs.map(
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
