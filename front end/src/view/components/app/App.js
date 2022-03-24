import React from "react";
import logo from "../../resources/logo/novi_logo.png";
import './App.css';
import AppRouter from "../../../controller/Navigatie/Router";
import '../algemeen.css';


function App() {

    return (
        <div className="background">
            <div className="outer_content_container">
                <div className="inner_content_container">
                    <img src={logo} className="novi-logo" alt="novi-logo"/>
                    <div className="alternating_content_container">

                        <AppRouter/>

                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
