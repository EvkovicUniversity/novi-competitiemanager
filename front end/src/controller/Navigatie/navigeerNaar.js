import {useHistory} from "react-router-dom";

function NavigeerNaar(path, id) {
    const history=useHistory();
    return history.replace("/" + path, );

}

export default NavigeerNaar;
