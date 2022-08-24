import axios from "axios";
import {Component} from "react";
import authHeader from "../../../services/auth-header";

class DataServices extends Component {

    getData(url) {
        return axios.get(url, {headers: authHeader()})
    }

    postData(url) {
        return axios.post(url, {
            "id": 30,
            "competitienaam": "React PostMethod",
            "spelers_db_id": "123",
            "startmoment": "2022-03-11T11:16:45.427389",
            "raceAantal": 100,
            "tijdaantal": 10,
            "tijdseenheid": "week"
        })
    }

}

export default new DataServices();