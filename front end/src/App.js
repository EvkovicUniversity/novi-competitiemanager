import React from "react";
import logo from "./resources/images/logo/novi_logo.png";
import "./resources/stylingsheets/algemeen.css";
import "./resources/stylingsheets/App.css";
import AppRouter from "./controller/Navigatie/Router";

import {BrowserRouter, Link} from "react-router-dom";
import Footer from "./view/footer/Footer";

function App() {

    return (
        <BrowserRouter>
            <div className="background">
                <div className="outer_content_container">
                    <div className="inner_content_container">

                        <header>
                            <Link to={"/menu"}>
                                <img src={logo} className="novi-logo" alt="novi-logo"/>
                            </Link>
                        </header>

                        <main className="alternating_content_container">
                            <AppRouter/>
                        </main>

                        <footer>
                            <Footer/>
                        </footer>

                    </div>
                </div>
            </div>
        </BrowserRouter>
    );
}

export default App;
