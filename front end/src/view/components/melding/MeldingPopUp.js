import React from "react";
import './melding.css';

function meldingPopUp(props) {

    function handleTerug() {
        props.akkoord(false)
        props.openMelding(false)
    }

    function handleOK() {
        props.akkoord(true)
        props.openMelding(false)
    }

    return (

        <div className="alert_background">
            <div className="alert_container">
                <div className="alert_border">
                    <p>{props.bericht}</p>

                    <button onClick={handleTerug}>Terug</button>
                    <button className="button01" onClick={handleOK}>OK!</button>
                </div>
            </div>
        </div>

    )

}

export default meldingPopUp;