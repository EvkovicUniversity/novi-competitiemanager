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
                {
                    this.state.coureurs.map(
                        coureur =>
                            <tr key={coureur.id}>
                                <td>{coureur.name}</td>
                                <td>{coureur.winfactor}</td>
                            </tr>
                    )
                }
            </div>
        )
    }

}

export default Formula1
