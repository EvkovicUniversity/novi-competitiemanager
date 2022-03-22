import React from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import LoginPage from "../../view/components/login-page/Login-page";
import Keuzemenu from "../../view/components/keuzemenu/Keuzemenu";
import CompetitieSelecteren from "../../view/components/competities/competitieSelectie/CompetitieSelecteren";
import Competitie from "../../view/components/competities/competitie/Competitie";
import Competitiecreator from "../../view/components/competities/competitiecreator/Competitiecreator";
import Accountsettings from "../../view/components/settings/Accountsettings";
import AccountCreator from "../../view/components/settings/account_components/AccountCreator";
import VeranderWachtwoord from "../../view/components/settings/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/components/settings/account_components/VeranderGebruikersnaam";

class AppRouter extends React.Component {

    render() {
        return (
                <Router>
                    <Routes>
                        <Route path="/" element={<LoginPage/>}/>
                        <Route path='menu' element={<Keuzemenu/>}/>
                        <Route path='competities' element={<CompetitieSelecteren/>}/>
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