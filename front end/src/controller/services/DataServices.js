import React from "react";
import axios from "axios";

class DataServices extends React.Component{

    getData(url){
        return axios.get(url)
    }

}

export default new DataServices();