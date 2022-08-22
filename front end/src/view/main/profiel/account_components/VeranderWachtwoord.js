import React, {useState} from "react";
import axios from "axios";
import authService from "../../../../services/auth.service";
import AuthService from "../../../../services/auth.service";
import authHeader from "../../../../services/auth-header";

// class VeranderWachtwoord extends Component {
//     constructor(props) {
//         super(props);
//
//         this.state = {
//             wachtwoord: ''
//         }
//     }
//
//     changeHandler = (e) => {
//         this.setState({[e.target.name]: e.target.value})
//     }
//
//     render() {
//
//         const {nieuwWachtwoord} = this.state;
//
//         return (
//
//             <div>
//                 <h1>Wachtwoord wijzigen</h1>
//                 <p>Voor [gebruikersnaam]{this.state.gebruikersnaam}</p>
//
//                 <form>
//                     <input type="password"
//                            placeholder="Huidig wachtwoord"
//                            name="nieuwWachtwoord"
//                            value={nieuwWachtwoord}
//                            onChange={this.changeHandler}
//                     /><br/>
//
//                     <button className="button01">Doorgaan</button>
//                 </form>
//             </div>
//         )
//     }
// }

const VeranderWachtwoord = () => {

    const [nieuwWachtwoord, setNieuwWachtwoord] = useState("");
    const [openNotificatie, setOpenNotificatie] = useState(false);
    const [responseStatus, setResponseStatus] = useState(0);

    const changeHandler = (e) => {
        const wachtwoord = e.target.value;
        setNieuwWachtwoord(wachtwoord);
    };

    const submitHandler = (e) => {
        e.preventDefault();

        axios.put("http://localhost:8080/user/changePassword/" + authService.getCurrentUser().username, [nieuwWachtwoord], {headers: authHeader()})
            .then((res) => {
                setResponseStatus(res.status);
                setOpenNotificatie(true);
            })
            .catch(err => {
                setOpenNotificatie(true);
            });
    }

    return (
        <div>
            <h1>Wachtwoord wijzigen</h1>
            <p>voor {AuthService.getCurrentUser().username}</p>

            <form onSubmit={submitHandler}>
                <input type="text"
                       placeholder="Nieuwe gebruikersnaam"
                       name="nieuwegebruikersnaam"
                       value={nieuwWachtwoord}
                       onChange={changeHandler}
                /><br/>

                <button className="button01">Doorgaan</button>
            </form>
        </div>
    )

}

export default VeranderWachtwoord;