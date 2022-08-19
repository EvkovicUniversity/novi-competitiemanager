import React from "react";
import './melding.css';

function Notificatie(props) {

    let goedImg = "\u2705";
    let goedMsg = "Actie voltooid!";
    let foutImg = "\u274C";
    let foutMsg = "Actie mislukt!";

    const message = props.status === 200 || props.status === 201 ? goedMsg : foutMsg;
    const image = props.status === 200 || props.status === 201 ? goedImg : foutImg;

    const handleClick = () => {
        props.setOpenNotificatie(false);
    }

    return (
        <div className="notificatie_achtergrond">
            <div className="notificatie_outer">
                <div className="notificatie_border">
                    <div className="notificatie_inner">

                        {console.log(props.status)}

                        <div className="notificatie_melding">
                            <p id="notificatieMsg">{message}</p>
                            <p id="notificatieImg">{image}</p>
                        </div>

                        <button className="button01" onClick={() => handleClick()}>oki</button>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default Notificatie;