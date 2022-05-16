import React, {Component} from "react";
import DataServices from "../../../../../controller/services/data/DataServices";
import ToonCompetitieNaam from "./ToonCompetitieNaam";

class ToonCompetitiesTerSelectie extends Component {

    constructor(props) {
        super(props);

        this.state = {
            competities: []
        }
    }

    componentDidMount() {
        DataServices.getData("http://localhost:8080/competitiemanager/formula1/competities")
            .then((res) => {
                this.setState({competities: res.data})
            })
    }

    render() {

        let uniqueKeyCounter = 0;
        return (
            <ul>
                {
                    this.state.competities.map(
                        competitie =>

                            <li className="keuzemenuknop" id="competitieSelecteren" key={"competitie" + uniqueKeyCounter++}>
                                <div className="background_enkeleCompetitie" >
                                    <ToonCompetitieNaam
                                        competitienaam={competitie.competitienaam}
                                        competitieId={competitie.id}
                                    />
                                </div>
                            </li>
                    )
                }
            </ul>
        )
    }
}

export default ToonCompetitiesTerSelectie;
