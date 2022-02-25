import React from "react";
import logo from "../../resources/logo/novi_logo.png";
import "./basis.css";
import Keuzemenu from "../keuzemenu/keuzemenu";
import LoginPage from "../login-page/login-page";


class Basis extends React.Component{
    render() {
        return (
            <div className="background">
                <div className="outer_content_container">
                    <div className="inner_content_container">
                        <img src={logo} className="novi-logo" alt="novi-logo"/>
                        <div className="alternating_content_container">

                            <Keuzemenu/>

                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Basis;