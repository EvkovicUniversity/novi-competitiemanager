import React, {Component} from "react";
import axios from "axios";
import Notificatie from "../../../components/melding/Notificatie";

class VeranderGebruikersnaam extends Component {

    constructor(props) {
        super(props);

        this.state = {
            nieuwegebruikersnaam: '',
            openNotificatie: false,
            responseStatus: 0
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = (e) => {
        e.preventDefault()
        axios.put('http://localhost:8080/gebruikers/gebruikersnaamwijzigen/2/' + this.state.gebruikersnaam, this.state)
            .then((res) => {
                this.setState({responseStatus: res.status});

                this.setState({openNotificatie: true});
            })
            .catch(err => {
                this.setState({openNotificatie: true});
            })
    }

    render() {

        const {nieuwegebruikersnaam} = this.state;

        return (
            <div>
                <h1>Gebruikersnaam wijzigen</h1>
                <p>voor [gebruikersnaam] {this.state.gebruikersnaam}</p>

                <form onSubmit={this.submitHandler}>
                    <input type="text"
                           placeholder="Nieuwe gebruikersnaam"
                           name="nieuwegebruikersnaam"
                           value={nieuwegebruikersnaam}
                           onChange={this.changeHandler}
                    /><br/>

                    <button className="button01">Doorgaan</button>
                </form>

                {this.state.openNotificatie && <Notificatie status={this.state.responseStatus} openNotificatie={this.state.openNotificatie} />}


            </div>
        )
    }
}

export default VeranderGebruikersnaam;