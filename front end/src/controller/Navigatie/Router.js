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
import {Route, Switch} from "react-router-dom";

class AppRouter extends Component {

    render() {
        return (

                    <Switch>
                        <Route exact path={["/", "/login"]} component={LoginPage}/>
                        <Route exact path='/menu' component={Keuzemenu}/>
                        <Route exact path='/competities' component={CompetitieSelector}/>
                        <Route exact path='/competities/:competitieid' component={CompetitieSelected}/>
                        <Route exact path='/CompetitieCreator' component={Competitiecreator}/>
                        <Route exact path='/settings' component={Accountsettings}/>
                        <Route exact path='/settings/gebruikersnaam-wijzigen' component={VeranderGebruikersnaam}/>
                        <Route exact path='/settings/wachtwoord-wijzigen' component={VeranderWachtwoord}/>
                        <Route exact path='/settings/account-maken' component={AccountCreator}/>
                    </Switch>
        );
    }
}

export default AppRouter;