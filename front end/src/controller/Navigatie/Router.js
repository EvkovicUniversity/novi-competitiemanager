import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import LoginPage from "../../view/components/login-page/Login-page";
import Keuzemenu from "../../view/components/keuzemenu/Keuzemenu";
import CompetitieSelector from "../../view/components/keuzemenu/competities/competitie_selector/CompetitieSelector";
import Competitie from "../../view/components/keuzemenu/competities/competitie_selected/Competitie";
import Competitiecreator from "../../view/components/keuzemenu/competities/competitie_creator/Competitiecreator";
import Accountsettings from "../../view/components/keuzemenu/settings/Accountsettings";
import AccountCreator from "../../view/components/keuzemenu/settings/account_components/AccountCreator";
import VeranderWachtwoord from "../../view/components/keuzemenu/settings/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/components/keuzemenu/settings/account_components/VeranderGebruikersnaam";

class AppRouter extends Component {

    render() {
        return (
                <Router>
                    <Routes>
                        <Route path="/" element={<LoginPage/>}/>
                        <Route path='menu' element={<Keuzemenu/>}/>
                        <Route path='competities' element={<CompetitieSelector/>}/>
                        <Route path='competities/:competitieid' element={<Competitie/>}/>
                        <Route path='competities/creator' element={<Competitiecreator/>}/>
                        <Route path='settings' element={<Accountsettings/>}/>
                        <Route path='settings/gebruikersnaam-veranderen' element={<VeranderGebruikersnaam/>}/>
                        <Route path='settings/wachtwoord-veranderen' element={<VeranderWachtwoord/>}/>
                        <Route path='settings/account-maken' element={<AccountCreator/>}/>
                    </Routes>
                </Router>
        );
    }
}

export default AppRouter;