import {useCallback} from "react";
import {useNavigate} from "react-router-dom";

function navigeerNaar(path) {

    const navigate = useNavigate();
    return useCallback(() => navigate('/' + path, {replace: true}), [navigate]);

}

export default navigeerNaar;