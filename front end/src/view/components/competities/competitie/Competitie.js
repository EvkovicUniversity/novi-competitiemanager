import React from "react";
import DataServices from "../../../../controller/services/DataServices";
import RaceUitslag from "./RaceUitslag";
import OpkomendeRace from "./competitiemenu/OpkomendeRace";
import RaceResults from "./competitiemenu/RaceResults";

class Competitie extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            competitieinfo: []
        }
    }

    componentDidMount() {
        const getUrl = window.location.href;
        const urlParsed = getUrl.replace('http://localhost:3000', '');

        DataServices.getData("http://localhost:8080/formula1" + urlParsed)
            .then((res) => {
                this.setState({competitieinfo: res.data})
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
                            <RaceResults/>
                        </div>


                    </div>

                <button className="button01">Race!</button>
            </div>
        )
    }

}

export default Competitie
