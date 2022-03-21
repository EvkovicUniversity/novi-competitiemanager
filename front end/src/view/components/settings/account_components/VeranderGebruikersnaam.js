import React, {Component} from "react";
import axios from "axios";

class VeranderGebruikersnaam extends Component {

    constructor(props) {
        super(props);

        this.state = {
            gebruikersnaam: ''
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.put('http://localhost:8080/gebruikers/gebruikersnaamwijzigen/' + '2/' + this.state.gebruikersnaam, this.state)
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err)
            })
    }

    render() {

        const {gebruikersnaam} = this.state;

        return (
            <div>
                <h1>Gebruikersnaam wijzigen</h1>
                <p>voor Henk</p>
                {/*<p>voor {this.state.gebruikersnaam}</p>*/}

                <form onSubmit={this.submitHandler}>
                    <input type="text"
                           placeholder="Nieuwe gebruikersnaam"
                           name="gebruikersnaam"
                           value={gebruikersnaam}
                           onChange={this.changeHandler}
                    /><br/>

                    <button className="button01">Doorgaan</button>
                </form>
            </div>
        )
    }
}

export default VeranderGebruikersnaam;