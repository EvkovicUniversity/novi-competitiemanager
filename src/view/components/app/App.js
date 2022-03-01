import React, {useCallback} from "react";
import {BrowserRouter as Router, Route, Routes, useNavigate} from "react-router-dom";
import LoginPage from "../login-page/login-page";
import logo from "../../resources/logo/novi_logo.png";
import './App.css';
import Keuzemenu from "../keuzemenu/keuzemenu";
import Settings from "../settings/settings";
import Competities from "../competities/competities";
import CompetitieCreator from "../competitiecreator/competitiecreator";

function App() {

    return (
        <Router>
            <div className="background">
                <div className="outer_content_container">
                    <div className="inner_content_container">
                        <img src={logo} className="novi-logo" alt="novi-logo"/>
                        <div className="alternating_content_container">

                            <Routes>
                                <Route path="/" element={<LoginPage/>}/>
                                <Route path='menu' element={<Keuzemenu/>}/>
                                <Route path='competities' element={<Competities/>}/>
                                <Route path='competities/creator' element={<CompetitieCreator/>}/>
                                <Route path='settings' element={<Settings/>}/>
                            </Routes>

                        </div>
                    </div>
                </div>
            </div>
        </Router>
    );
}

export default App;
