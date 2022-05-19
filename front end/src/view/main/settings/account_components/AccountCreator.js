import React, {Component} from "react";
import axios from "axios";
import Notificatie from "../../../components/melding/Notificatie";

class AccountCreator extends Component {

    constructor(props) {
        super(props);

        this.state = {

            gebruikersnaam: '',
            wachtwoord: '',


            velden: {},
            errors: {},

            openNotificatie: false,
            responseStatus: 0
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()
        console.log(this.state)

        axios.post('http://localhost:8080/gebruikers/toevoegen', this.state)
            .then( (res) => {
                this.setState({responseStatus: res.status});
                this.setState({openNotificatie: true});
            })
            .catch(err => {
                this.setState({openNotificatie: true});
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

                {this.state.openNotificatie &&
                    <Notificatie status={this.state.responseStatus} openNotificatie={this.state.openNotificatie} />
                }

            </div>
        )
    }
}

export default AccountCreator;