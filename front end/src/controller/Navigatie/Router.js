import React, {Component} from "react";
import LoginPage from "../../view/components/authorisatie/login/Login-page";
import Keuzemenu from "../../view/components/keuzemenu/Keuzemenu";
import CompetitieSelector from "../../view/components/keuzemenu/competities/competitie_selector/CompetitieSelector";
import CompetitieSelected from "../../view/components/keuzemenu/competities/competitie_selected/CompetitieSelected";
import Competitiecreator from "../../view/components/keuzemenu/competities/competitie_creator/Competitiecreator";
import Accountsettings from "../../view/components/keuzemenu/settings/Accountsettings";
import AccountCreator from "../../view/components/authorisatie/register/AccountCreator";
import VeranderWachtwoord from "../../view/components/keuzemenu/settings/account_components/VeranderWachtwoord";
import VeranderGebruikersnaam from "../../view/components/keuzemenu/settings/account_components/VeranderGebruikersnaam";
import {BrowserRouter, Route, Switch} from "react-router-dom";

class AppRouter extends Component {

    render() {
        return (

                <BrowserRouter>
                    <Switch>
                        <Route path="/login" component={LoginPage}/>
                        <Route exact path='/menu' component={Keuzemenu}/>
                        <Route path='competities' component={CompetitieSelector}/>
                        <Route path='competities/:competitieid' component={CompetitieSelected}/>
                        <Route path='competities/creator' component={Competitiecreator}/>
                        <Route path='settings' component={Accountsettings}/>
                        <Route path='settings/gebruikersnaam-veranderen' component={VeranderGebruikersnaam}/>
                        <Route path='settings/wachtwoord-veranderen' component={VeranderWachtwoord}/>
                        <Route path='settings/account-maken' component={AccountCreator}/>
                    </Switch>
                </BrowserRouter>
        );
    }
}

export default AppRouter;