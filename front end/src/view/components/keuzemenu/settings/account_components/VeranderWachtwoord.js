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

        const wachtwoord = '';

        return (

            <div>
                <h1>Wachtwoord wijzigen</h1>
                <p>voor Henk</p>
                {/*<p>Voor {this.state.gebruikersnaam}</p>*/}

                <form>
                    <input type="password"
                           placeholder="Huidig wachtwoord"
                           name="wachtwoord"
                           value={wachtwoord}
                           onChange={this.changeHandler}
                    /><br/>

                    <button className="button01">Doorgaan</button>
                </form>
            </div>
        )
    }
}

export default VeranderWachtwoord;