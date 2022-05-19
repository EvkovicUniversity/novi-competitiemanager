import React, {Component} from "react";

class VeranderWachtwoord extends Component {
    constructor(props) {
        super(props);

        this.state = {
            wachtwoord: ''
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    render() {

        const {nieuwWachtwoord} = this.state;

        return (

            <div>
                <h1>Wachtwoord wijzigen</h1>
                <p>Voor [gebruikersnaam]{this.state.gebruikersnaam}</p>

                <form>
                    <input type="password"
                           placeholder="Huidig wachtwoord"
                           name="nieuwWachtwoord"
                           value={nieuwWachtwoord}
                           onChange={this.changeHandler}
                    /><br/>

                    <button className="button01">Doorgaan</button>
                </form>
            </div>
        )
    }
}

export default VeranderWachtwoord;