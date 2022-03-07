import React from "react";
import DataServices from "../../../controller/services/DataServices";

class Formula1 extends React.Component {

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
                <table className='tabel'>
                    <tr>
                        <th>Positie</th>
                        <th>Coureur</th>
                    </tr>
                    {
                        this.state.coureurs.map(
                            coureur =>
                                <tr key={coureur.id}>
                                    <td>{coureur.id}e</td>
                                    <td>{coureur.name}</td>
                                </tr>
                        )
                    }
                </table>
            </div>
        )
    }

}

export default Formula1
