Aangemaakt account:
    Gebruikersnaam: 'noviadmin'
    Wachtwoord: 'noviadmin'



lijst met EndPoints:

Competitie:
localhost:8080/competitiemanager/formula1/competities                                        GET
localhost:8080/competitiemanager/formula1/competities/raceuitslagen/raceId/{competitieId}    GET
localhost:8080/competitiemanager/formula1/competities/{id}                                   GET
localhost:8080/competitiemanager/formula1/competities                                        POST

Coureurs:
localhost:8080/competitiemanager/formula1/vanillaCoureurs                                     GET

Races:
localhost:8080/competitiemanager/formula1/races/getAll                                        GET
localhost:8080/competitiemanager/formula1/competities/raceuitslagen/racesId/{raceId           GET

Raceuitslagen:
localhost:8080/competitiemanager/formula1/competities/raceuitslagen                           GET
localhost:8080/competitiemanager/formula1/competities/raceuitslagen/{uitslagId}               GET
localhost:8080/competitiemanager/formula1/competities/user/voorspelling/raceuitslag/{raceuitslagId}      GET
localhost:8080/competitiemanager/formula1/competities/raceuitslagen/racesId/{raceId}          POST

Voorspellingen:
localhost:8080/competitiemanager/formula1/user/voorspelling/{voorspellingId}                  GET
localhost:8080/competitiemanager/formula1/user/formula1/voorspelling/{competitieId}           POST

Autorisatie:
localhost:8080/api/auth/signin                                                                GET
localhost:8080/api/auth/signup                                                                POST

Role:
localhost:8080/api/roles                                                                      PUT

User details wijzigen:
localhost:8080/user/changeUsername/{username}                                                 PUT
localhost:8080/user/changePassword/{password}                                                 PUT
