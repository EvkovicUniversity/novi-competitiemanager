import React, {Component} from "react";

import {Route, Routes} from "react-router-dom";
import Keuzemenu from "../../view/main/keuzemenu/Keuzemenu";
import CompetitieSelector from "../../view/main/competities/competitie_selector/CompetitieSelector";
import CompetitieSelected from "../../view/main/competities/competitie_selected/CompetitieSelected";
import Competitiecreator from "../../view/main/competities/competitie_creator/Competitiecreator";
import VeranderWachtwoord from "../../view/main/settings/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/main/settings/account_components/VeranderGebruikersnaam";
import LoginPage from "../../view/main/login/LoginPage";
import Profile from "../../view/main/settings/Profile";
import AccountCreator from "../../view/main/settings/account_components/AccountCreator";
import BoardUser from "../../view/components/BoardUser";
import BoardModerator from "../../view/components/BoardModerator";
import BoardAdmin from "../../view/components/BoardAdmin";

class AppRouter extends Component {

    render() {
        return (
            <Routes>
                <Route path="/" element={<LoginPage/>}/>
                <Route path='menu' element={<Keuzemenu/>}/>
                {/*<Route path='menu' element={<BoardUser/>}/>*/}
                {/*<Route path='menu' element={<BoardModerator/>}/>*/}
                {/*<Route path='menu' element={<BoardAdmin/>}/>*/}
                <Route path='competities' element={<CompetitieSelector/>}/>
                <Route path='competities/:competitieid' element={<CompetitieSelected/>}/>
                <Route path='competitieCreator' element={<Competitiecreator/>}/>
                <Route path='profile' element={<Profile/>}/>
                <Route path='profile/gebruikersnaam-wijzigen' element={<VeranderGebruikersnaam/>}/>
                <Route path='profile/wachtwoord-wijzigen' element={<VeranderWachtwoord/>}/>
                <Route path='profile/account-maken' element={<AccountCreator/>}/>
            </Routes>
        );
    }
}

export default AppRouter;