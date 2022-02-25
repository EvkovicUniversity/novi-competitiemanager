import React from "react";
import "./keuzemenu.css";

class Keuzemenu extends React.Component {
    render() {
        return(
            <div>
                <div className="keuzemenuknop" id="keuzemenu_01">
                    <p>Competities bekijken</p>
                </div>

                <div className="keuzemenuknop" id="keuzemenu_02">
                    <p>Account instellingen</p>
                </div>

                <div className="keuzemenuknop" id="keuzemenu_03">
                    <p>Uitloggen</p>
                </div>
            </div>
        )
    }
}

export default Keuzemenu;