import React, {useCallback} from "react";
import "./keuzemenu.css";
import {useNavigate} from "react-router-dom";

function Keuzemenu() {

    const navigate = useNavigate();
    const navigateOnClickCompetities = useCallback(() => navigate('/competities', {replace: true}), [navigate]);
    const navigateOnClickSettings = useCallback(() => navigate('/settings', {replace: true}), [navigate]);
    const navigateOnClickLogout = useCallback(() => navigate('/', {replace: true}), [navigate]);

    return(
        <div>
            <div className="keuzemenuknop" id="keuzemenu_01" onClick={navigateOnClickCompetities}>
                <p>Competities bekijken</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenu_02" onClick={navigateOnClickSettings}>
                <p>Account instellingen</p>
            </div>

            <div className="keuzemenuknop" id="keuzemenu_03" onClick={navigateOnClickLogout}>
                <p>Uitloggen</p>
            </div>
        </div>
    )
}

export default Keuzemenu;