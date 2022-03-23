import React, {Component} from "react";
import ToonCompetitieNaam from "./ToonCompetitieNaam";
import DataServices from "../../../../../controller/services/DataServices";

class ToonCompetitiesTerSelectie extends Component {

    constructor(props) {
        super(props);

        this.state = {
            competities: []
        }
    }

    componentDidMount() {
        DataServices.getData("http://localhost:8080/formula1/competities")
            .then((res) => {
                this.setState({competities: res.data})
            })
    }

    render() {
        return (
            <div>
                {
                    this.state.competities.map(
                        competitie =>

                            <div className="keuzemenuknop" id="competitieSelecteren">
                                <div className="background_enkeleCompetitie">
                                    <ToonCompetitieNaam
                                        competitienaam={competitie.competitienaam}
                                        competitieId={competitie.id}
                                    />
                                </div>
                            </div>
                    )
                }
            </div>
        )
    }
}

export default ToonCompetitiesTerSelectie;
