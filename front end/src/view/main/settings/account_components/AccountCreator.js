import React, {Component} from "react";
import axios from "axios";

class AccountCreator extends Component {

    constructor(props) {
        super(props);

        this.state = {

            gebruikersnaam: '',
            wachtwoord: '',


            velden: {},
            errors: {},

        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()

        axios.post('http://localhost:8080/gebruikers/toevoegen', this.state)
            .catch(err => {
                console.log(err)
            })
    }

    render() {

        const {
            gebruikersnaam,
            wachtwoord
        } = this.state;

        return (
            <div>
                <h1>Account creëren</h1>

                <form onSubmit={this.submitHandler}>

                    <input type="text"
                           name="gebruikersnaam"
                           defaultValue="hello"
                           value={gebruikersnaam}
                           onChange={this.changeHandler}
                           placeholder="Voer gebruikersnaam in"
                    /><br/>
                    <input type="password"
                           name="wachtwoord"
                           value={wachtwoord}
                           onChange={this.changeHandler}
                           placeholder="Voer wachtwoord in"
                    /><br/>

                    <button className="button01">Creër</button>

                </form>

            </div>
        )
    }
}

export default AccountCreator;