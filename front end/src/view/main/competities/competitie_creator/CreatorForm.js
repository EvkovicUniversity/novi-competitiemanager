import React, {Component} from "react";
import axios from "axios";
import authHeader from "../../../../services/auth-header";

class CreatorForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            competitienaam: '',
            // team_deelnemers: '',
            // extraDeelnemers: '',
            // startmoment: '',
            // raceAantal: '',
            // tijdAantal: '',
            // tijdseenheid: ''
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.post('http://localhost:8080/competitiemanager/formula1/competities', this.state, {headers: authHeader()})
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err)
            })
    }

    render() {

        const {
            competitienaam,
            // team_deelnemers,
            extraDeelnemers,
            // startmoment,
            raceAantal,
            tijdAantal,
            // tijdseenheid
        } = this.state
        return (
            <div>
                <form onSubmit={this.submitHandler} className="formulier">
                    <div className="creator_invoerveldcontainer">
                        <div>
                            <input type="text" name="competitienaam" value={competitienaam}
                                   onChange={this.changeHandler}
                                   placeholder='Competitienaam'
                                   id='Competitienaam_input'/>
                        </div>
                        <div>
                            <select name="team_deelnemers"
                                // TODO: Fix zodat het als JSON gelezen wordt
                                // value={team_deelnemers} onChange={team_deelnemers}
                                    id="team_deelnemers_input">
                                <option>Team A</option>
                                <option>Team B</option>
                                <option>Team C</option>
                                <option>Team Test</option>
                            </select>
                        </div>
                        <div>
                            <input type="text" name="extraDeelnemers" value={extraDeelnemers}
                                   onChange={this.changeHandler}
                                   placeholder="Voeg een extra speler toe"
                                   id='extraDeelnemers_input'/>
                            <button className="button01" id="button_addPlayer">+</button>
                        </div>
                        <div>
                            <input type="datetime-local"
                                // TODO: Fix zodat het als JSON gelezen wordt
                                // name={startmoment} value={startmoment} onChange={this.changeHandler}
                                   id="startmoment_input"
                            />
                        </div>
                        <div>
                            <input type="text" name="raceAantal" value={raceAantal} onChange={this.changeHandler}
                                   placeholder="Voer aantal racen in"
                                   id='raceAantal_input'/>
                        </div>
                        <div>
                            <label>Nieuwe race elke</label>
                            <input type="text" name="tijdAantal" value={tijdAantal} onChange={this.changeHandler}
                                   id='tijdAantal_input'/>
                            <select name="tijdseenheid" id="tijdseenheid_input"
                                // TODO: Fix zodat het als JSON gelezen wordt
                                // value={tijdseenheid} onChange={this.changeHandler}
                            >
                                <option value="minuut">Minuut</option>
                                <option value="uur">Uur</option>
                                <option value="dag">Dag</option>
                                <option value="week">Week</option>
                                <option value="maand">Maand</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" className="button01">Creër</button>
                </form>
            </div>
        )
    }
}

export default CreatorForm;