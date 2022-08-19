import React, {useState} from "react";

import {Route, Routes} from "react-router-dom";
import Keuzemenu from "../../view/main/keuzemenu/Keuzemenu";
import CompetitieSelector from "../../view/main/competities/competitie_selector/CompetitieSelector";
import CompetitieSelected from "../../view/main/competities/competitie_selected/CompetitieSelected";
import Competitiecreator from "../../view/main/competities/competitie_creator/Competitiecreator";
import VeranderWachtwoord from "../../view/main/profiel/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/main/profiel/account_components/VeranderGebruikersnaam";
import LoginPage from "../../view/main/login/LoginPage";
import Profiel from "../../view/main/profiel/Profiel";
import AccountCreator from "../../view/main/profiel/account_components/AccountCreator";
import ProtectedRoutes from "./ProtectedRoutes";

function AppRouter() {

    return (
        <Routes>

            <Route path="/" element={<LoginPage/>}/>

            <Route element={<ProtectedRoutes/>}>
                    <Route path='menu' element={<Keuzemenu/>}/>
                    <Route path='competities' element={<CompetitieSelector/>}/>
                    <Route path='competities/:competitieid' element={<CompetitieSelected/>}/>
                    <Route path='competitieCreator' element={<Competitiecreator/>}/>
                    <Route path='profiel' element={<Profiel/>}/>
                    <Route path='profiel/gebruikersnaam-wijzigen' element={<VeranderGebruikersnaam/>}/>
                    <Route path='profiel/wachtwoord-wijzigen' element={<VeranderWachtwoord/>}/>
                    <Route path='profiel/account-maken' element={<AccountCreator/>}/>
            </Route>

        </Routes>
    );
}

export default AppRouter;