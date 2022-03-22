import React, {Component} from "react";
import axios from "axios";

class VeranderWachtwoord extends Component {

    constructor(props) {
        super(props);

        this.state = {
            huidigwachtwoord: '',
            nieuwwachtwoord: ''
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()
        console.log(this.state)
        axios.put('http://localhost:8080/gebruikers/gebruikersnaamwijzigen/2/' + this.state.nieuwwachtwoord, this.state)
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err)
            })
    }

    render() {

        const {huidigwachtwoord, nieuwwachtwoord} = this.state;

        return (
            <div>
                <h1>Wachtwoord wijzigen</h1>
                <p>voor Henk</p>
                {/*<p>Voor {this.state.gebruikersnaam}</p>*/}

                <form onSubmit={this.submitHandler}>
                    <input type="password"
                           placeholder="Huidig wachtwoord"
                           name="huidigwachtwoord"
                           value={huidigwachtwoord}
                           onChange={this.changeHandler}
                    /><br/>
                    <input type="password"
                           placeholder="Nieuw wachtwoord"
                           name="nieuwwachtwoord"
                           value={nieuwwachtwoord}
                           onChange={this.changeHandler}
                    /><br/>

                    <button className="button01">Doorgaan</button>
                </form>
            </div>
        )
    }
}

export default VeranderWachtwoord;