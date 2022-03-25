import {useCallback} from "react";
import {useNavigate} from "react-router-dom";

function NavigeerNaar(path, id) {

    const navigate = useNavigate();
    return useCallback(() => navigate('/' + path, {replace: true}), [navigate]);

}

export default NavigeerNaar;