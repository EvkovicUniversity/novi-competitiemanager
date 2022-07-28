import React from "react";
import './melding.css';

function Notificatie(props) {

    let goedImg = "\u2705";
    let goedMsg = "Actie voltooid!";
    let foutImg = "\u274C";
    let foutMsg = "Actie mislukt!";

    function handleClass() {
        this.setState({
            openNotificatie: false
        })
    }


    return (
        <div className="notificatie_achtergrond">
            <div className="notificatie_outer">
                <div className="notificatie_border">
                    <div className="notificatie_inner">

                        <div className="notificatie_melding">
                            <p id="notificatieMsg">{props.status === 201 || 200 ? goedMsg : foutMsg}</p>
                            <p id="notificatieImg">{props.status === 201 || 200 ? goedImg : foutImg}</p>
                        </div>

                        {/*<button className="button01" onClick={() => handleOK()}>oki</button>*/}
                        <button className="button01" onClick={() => handleClass()}>oki</button>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default Notificatie;