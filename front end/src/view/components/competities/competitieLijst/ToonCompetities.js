import React from "react";
import CompetitieUitLijst from "../competitieUitLijst/competitieUitLijst";
import DataServices from "../../../../controller/services/DataServices";

class ToonCompetities extends React.Component {

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

                            <div className='enkeleCompetitieUitLijstContainer'>
                                <CompetitieUitLijst
                                    competitienaam={competitie.competitienaam}
                                    competitieId={competitie.id}
                                />
                            </div>
                    )
                }
            </div>
        )
    }
}

export default ToonCompetities;

//
