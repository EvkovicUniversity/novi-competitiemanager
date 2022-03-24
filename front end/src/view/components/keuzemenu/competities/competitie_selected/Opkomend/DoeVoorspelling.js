import React, {Component} from "react";
import DataServices from "../../../../../../controller/services/data/DataServices";
import axios from "axios";

class doeVoorspelling extends Component {
    constructor(props) {
        super(props)

        this.state = {
            raceUitslag: [],
        }
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})

    }

    submitHandler = (e) => {
        e.preventDefault()
        axios.post('', this.state)
            .then(res => {
                console.log("PostData: " + res)
            })
            .catch(err => {
                console.log(err)
            })
    }

    componentDidMount() {
        (DataServices.getData("http://localhost:8080/competitiemanager/formula1/vanillaCoureurs")
            .then((res) => {
                this.setState({raceUitslag: res.data})
            }))
    }

    render() {

        return (
            <div>

                <form onSubmit={this.submitHandler} >

                    <button type='submit' className="button01">Voorspel</button>

                    <table className='tabel'>

                        <thead>
                        <tr>
                            <th className='tabelheaders' id='positieCel'>Coureur</th>
                            <th className='tabelheaders'>Voorspel eindpositie</th>
                        </tr>
                        </thead>
                        <tbody>

                        {
                            this.state.raceUitslag.map(
                                coureur =>
                                    <tr key={coureur.id}>
                                        <td className='tableRow'>{coureur.name}</td>
                                        <td><input type='text'
                                                   id="input_voorspelling"
                                                   name="voorspellingEindpositie"
                                            // value={voorspellingEindpositie}
                                                   onChange={this.changeHandler}
                                        />
                                        </td>
                                    </tr>
                            )
                        }

                        </tbody>
                    </table>
                </form>
            </div>
        );
    }
}

export default doeVoorspelling;