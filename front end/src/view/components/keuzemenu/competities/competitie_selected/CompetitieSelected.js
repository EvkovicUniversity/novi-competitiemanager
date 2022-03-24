import React, {Component} from "react";
import DataServices from "../../../../../controller/services/data/DataServices";
import OpkomendeRace from "./Opkomend/OpkomendeRace";
import History from "./History/History";
import axios from "axios";

class CompetitieSelected extends Component {

    constructor(props) {
        super(props);

        this.state = {
            competitieinfo: []
        }
    }

    componentDidMount() {
        const getUrl = window.location.href;
        const urlParsed = getUrl.replace("http://localhost:3000", "");

        DataServices.getData("http://localhost:8080/competitiemanager/formula1" + urlParsed)
            .then((res) => {
                this.setState({competitieinfo: res.data})
            })
    }

    // TODO: Als deze methode aan staat (en hij op de onClick staat) krijg ik in de backend een foutmelding.
    //  hierdoor ontstaan er twee nieuwe races.
    //  Wat mij opvalt is dat deze 4x af vuurt terwijl dat alleen zou moeten als er op de knop gedrukt wordt.
    doRace(){
        axios.post("http://localhost:8080/competitiemanager/formula1/playmatch/" + this.state.competitieinfo.id)
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err)
            })
    }

    render() {
        return (
            <div>

                <h1>{this.state.competitieinfo.competitienaam}</h1>

                <div className='competitieMenuContainer'>

                    <div className="competitieMenuInhoudContainer">
                        <OpkomendeRace/>
                    </div>

                    <div className="competitieMenuInhoudContainer">
                        <History competitieId={this.state.competitieinfo.id}/>
                    </div>

                </div>

                <button className="button01" >Race!</button>
            </div>
        )
    }

}

export default CompetitieSelected