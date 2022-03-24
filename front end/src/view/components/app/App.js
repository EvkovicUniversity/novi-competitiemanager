import React from "react";
import logo from "../../resources/logo/novi_logo.png";
import './App.css';
import AppRouter from "../../../controller/Navigatie/Router";
import '../algemeen.css';
import {BrowserRouter, Link} from "react-router-dom";


function App() {

    return (
        <BrowserRouter>
            <div className="background">
                <div className="outer_content_container">
                    <div className="inner_content_container">
                        <Link to={"/menu"}>
                            <img src={logo} className="novi-logo" alt="novi-logo"/>
                        </Link>
                        <div className="alternating_content_container">

                            <AppRouter/>

                        </div>
                    </div>
                </div>
            </div>
        </BrowserRouter>
    );
}

export default App;
