import React, {useCallback} from "react";
import {useNavigate} from "react-router-dom";

function NavigeerNaar(path) {

    const navigate = useNavigate();
    return useCallback(() => navigate('/' + path, {replace: true}), [navigate]);

}

export default NavigeerNaar;
