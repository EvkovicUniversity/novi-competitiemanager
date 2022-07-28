import React, {Component} from "react";

import {Route, Routes} from "react-router-dom";
import Keuzemenu from "../../view/main/keuzemenu/Keuzemenu";
import CompetitieSelector from "../../view/main/competities/competitie_selector/CompetitieSelector";
import CompetitieSelected from "../../view/main/competities/competitie_selected/CompetitieSelected";
import Competitiecreator from "../../view/main/competities/competitie_creator/Competitiecreator";
import Accountsettings from "../../view/main/settings/Accountsettings";
import AccountCreator from "../../view/main/settings/account_components/AccountCreator";
import VeranderWachtwoord from "../../view/main/settings/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/main/settings/account_components/VeranderGebruikersnaam";
import LoginPage from "../../view/main/login/LoginPage";
import Login from "../../view/components/Login";
import Register from "../../view/components/Register";
import Profile from "../../view/components/Profile";

class AppRouter extends Component {

    render() {
        return (
            <Routes>
                {/*<Route path="/" element={<LoginPage/>}/>*/}
                <Route path="/" element={<Login/>}/>
                <Route path='menu' element={<Keuzemenu/>}/>
                <Route path='competities' element={<CompetitieSelector/>}/>
                <Route path='competities/:competitieid' element={<CompetitieSelected/>}/>
                <Route path='competitieCreator' element={<Competitiecreator/>}/>
                <Route path='settings' element={<Accountsettings/>}/>
                {/*<Route path='settings/gebruikersnaam-wijzigen' element={<VeranderGebruikersnaam/>}/>*/}
                <Route path='settings/gebruikersnaam-wijzigen' element={<Profile/>}/>
                <Route path='settings/wachtwoord-wijzigen' element={<VeranderWachtwoord/>}/>
                {/*<Route path='settings/account-maken' element={<AccountCreator/>}/>*/}
                <Route path='settings/account-maken' element={<Register/>}/>
            </Routes>
        );
    }
}

export default AppRouter;