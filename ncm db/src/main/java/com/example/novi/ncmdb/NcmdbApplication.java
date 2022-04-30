package com.example.novi.ncmdb;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.Voorspelling;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.VoorspellingRepository;
import com.example.novi.ncmdb.domain.competitiemanager.gebruikers.Gebruiker;
import com.example.novi.ncmdb.domain.competitiemanager.gebruikers.GebruikerRepository;
import com.example.novi.ncmdb.domain.competitiemanager.gebruikers.GebruikerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NcmdbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(NcmdbApplication.class, args);

        CoureurRepository coureurRepository =
                configurableApplicationContext.getBean(CoureurRepository.class);
        CompetitieRepository competitieRepository =
                configurableApplicationContext.getBean(CompetitieRepository.class);
        RacesRepository racesRepository =
                configurableApplicationContext.getBean(RacesRepository.class);
        RaceuitslagRepository raceuitslagRepository =
                configurableApplicationContext.getBean(RaceuitslagRepository.class);
        VoorspellingRepository voorspellingRepository =
                configurableApplicationContext.getBean(VoorspellingRepository.class);
        GebruikerRepository gebruikerRepository =
                configurableApplicationContext.getBean(GebruikerRepository.class);


        NcmdbApplication app = new NcmdbApplication();

        app.db_init(
                coureurRepository,
                competitieRepository,
                raceuitslagRepository,
                racesRepository,
                voorspellingRepository
        );

        app.init_gebruikers(gebruikerRepository);


    }

    /**
     *
     *
     **/
    private void db_init(
            CoureurRepository coureurRep,
            CompetitieRepository competitieRep,
            RaceuitslagRepository raceuitslagRep,
            RacesRepository racesRep,
            VoorspellingRepository voorspellingRep
    ) {
        init_coureurs(coureurRep);

        getCompetitiesMetRaces(coureurRep, raceuitslagRep, racesRep, competitieRep, voorspellingRep);


    }

    /**
     *  De 20 deelnemende coureurs worden hier aangemaakt.
     *  De coureurs hebben een naam en een winfactor. Alleen 'Hamilton' en 'Verstappen' hebben een hogere winfactor gekregen.
     **/
    private List<Coureur> getCoureurList() {

        List<Coureur> coureurs = new ArrayList<>();

        coureurs.add(new Coureur("Alexander Albon", 1));
        coureurs.add(new Coureur("Fernando Alonso", 1));
        coureurs.add(new Coureur("Valtteri Bottas", 1));
        coureurs.add(new Coureur("Pierre Gasly", 1));
        coureurs.add(new Coureur("Lewis Hamilton", 6));
        coureurs.add(new Coureur("Nicholas Latifi", 1));
        coureurs.add(new Coureur("Charles Leclerc", 1));
        coureurs.add(new Coureur("Nikita Mazepin", 1));
        coureurs.add(new Coureur("Lando Norris", 1));
        coureurs.add(new Coureur("Esteban Ocon", 1));
        coureurs.add(new Coureur("Sergio Pérez", 1));
        coureurs.add(new Coureur("Daniel Ricciardo", 1));
        coureurs.add(new Coureur("George Russell", 1));
        coureurs.add(new Coureur("Carlos Sainz jr.", 1));
        coureurs.add(new Coureur("Mick Schumacher", 1));
        coureurs.add(new Coureur("Yuki Tsunoda", 1));
        coureurs.add(new Coureur("Lance Stroll", 1));
        coureurs.add(new Coureur("Max Verstappen", 7));
        coureurs.add(new Coureur("Sebastian Vettel", 1));
        coureurs.add(new Coureur("Guanyu Zhou", 1));

        return coureurs;
    }
    /**
     *  Hier worden de coureurs met bovenstaande methode opgehaald en opgeslagen in de database.
     **/
    private void init_coureurs(CoureurRepository coureurRepository) {
        List<Coureur> coureurs = getCoureurList();

        coureurRepository.saveAll(coureurs);
    }

    /**
     *  Hier wordt een lijst gecreërd waarin competities worden gestopt.
     **/
    private List<Competitie> getCompetities() {
        List<Competitie> competities = new ArrayList<>();

        competities.add(new Competitie("OTS"));
        competities.add(new Competitie("Evan"));
        competities.add(new Competitie("Herman"));
        competities.add(new Competitie("Nivea"));
        competities.add(new Competitie("Roos"));
        competities.add(new Competitie("Duyvis"));

        return competities;
    }

    private void getCompetitiesMetRaces(CoureurRepository coureurRepository,
                                        RaceuitslagRepository raceuitslagRepository,
                                        RacesRepository racesRepository,
                                        CompetitieRepository competitieRepository,
                                        VoorspellingRepository voorspellingRepository
    ) {
        // Maak Competities.
        Competitie competitie1 = new Competitie("CompetitieCompleet1");
        Competitie competitie2 = new Competitie("CompetitieCompleet2");

        // Maak de containers waarin de races worden opgeslagen.
        Races races1 = new Races(competitie1);
        Races races2 = new Races(competitie2);

        // Maak de raceuitslag containers.
        // Bind 4 uitslagen aan racecontainer 'races1'
        Raceuitslag uitslag11 = new Raceuitslag(races1);
        Raceuitslag uitslag12 = new Raceuitslag(races1);
        Raceuitslag uitslag13 = new Raceuitslag(races1);
        Raceuitslag uitslag14 = new Raceuitslag(races1);

        //Bind 4 uitslagen aan racecontainer 'races2'
        Raceuitslag uitslag21 = new Raceuitslag(races2);
        Raceuitslag uitslag22 = new Raceuitslag(races2);
        Raceuitslag uitslag23 = new Raceuitslag(races2);
        Raceuitslag uitslag24 = new Raceuitslag(races2);
        Raceuitslag uitslag25 = new Raceuitslag(races2);

        // Sla de racecontainers op in DB
        racesRepository.save(races1);
        racesRepository.save(races2);

        // Sla de raceuitslagen op in DB
        List<Raceuitslag> raceuitslagen1 = Arrays.asList(uitslag11, uitslag12, uitslag13, uitslag14);
        List<Raceuitslag> raceuitslagen2 = Arrays.asList(uitslag21, uitslag22, uitslag23, uitslag24,uitslag25);
        raceuitslagRepository.saveAll(raceuitslagen1);
        raceuitslagRepository.saveAll(raceuitslagen2);

//         Zet de races in een lijst
        List<Raceuitslag> uitslagVoor1 = new ArrayList<>();

        uitslagVoor1.add(uitslag11);
        races1.setRaceResultaten(uitslagVoor1);
        uitslag11.setId();
        raceuitslagRepository.save(uitslag11);
        racesRepository.save(races1);

        uitslagVoor1.add(uitslag12);
        races1.setRaceResultaten(uitslagVoor1);
        uitslag12.setId();
        raceuitslagRepository.save(uitslag12);
        racesRepository.save(races1);

        uitslagVoor1.add(uitslag13);
        races1.setRaceResultaten(uitslagVoor1);
        uitslag13.setId();
        raceuitslagRepository.save(uitslag13);
        racesRepository.save(races1);

        uitslagVoor1.add(uitslag14);
        races1.setRaceResultaten(uitslagVoor1);
        uitslag14.setId();
        raceuitslagRepository.save(uitslag14);
        racesRepository.save(races1);

        List<Raceuitslag> uitslagVoor2 = new ArrayList<>();

        uitslagVoor2.add(uitslag21);
        races2.setRaceResultaten(uitslagVoor2);
        uitslag21.setId();
        raceuitslagRepository.save(uitslag21);
        racesRepository.save(races2);

        uitslagVoor2.add(uitslag22);
        races2.setRaceResultaten(uitslagVoor2);
        uitslag22.setId();
        raceuitslagRepository.save(uitslag22);
        racesRepository.save(races2);

        uitslagVoor2.add(uitslag23);
        races2.setRaceResultaten(uitslagVoor2);
        uitslag23.setId();
        raceuitslagRepository.save(uitslag23);
        racesRepository.save(races2);

        uitslagVoor2.add(uitslag24);
        races2.setRaceResultaten(uitslagVoor2);
        uitslag24.setId();
        raceuitslagRepository.save(uitslag24);
        racesRepository.save(races2);

        uitslagVoor2.add(uitslag25);
        races2.setRaceResultaten(uitslagVoor2);
        uitslag25.setId();
        raceuitslagRepository.save(uitslag25);
        racesRepository.save(races2);
//
//        // Koppel de races aan een racecontainer
//        races1.setRaceResultaten(uitslagVoor1);
//        races2.setRaceResultaten(uitslagVoor2);
//
        doVoorspelling(voorspellingRepository, uitslag11);
//
//        // Sla op in DB
//        racesRepository.save(races1);
//        racesRepository.save(races2);

        //Genereer F1 Matches
        CoureurService coureurService = new CoureurService(coureurRepository);
        List<Coureur> genmatch1 = coureurService.generateF1Match();
        List<Coureur> genmatch2 = coureurService.generateF1Match();
        List<Coureur> genmatch3 = coureurService.generateF1Match();
        List<Coureur> genmatch4 = coureurService.generateF1Match();
        List<Coureur> genmatch5 = coureurService.generateF1Match();
        List<Coureur> genmatch6 = coureurService.generateF1Match();
        List<Coureur> genmatch7 = coureurService.generateF1Match();
        List<Coureur> genmatch8 = coureurService.generateF1Match();
        List<Coureur> genmatch9 = coureurService.generateF1Match();

        coureurService.koppelCoureurAanRaceuitslag(genmatch1, uitslag11);
        coureurService.koppelCoureurAanRaceuitslag(genmatch2, uitslag12);
        coureurService.koppelCoureurAanRaceuitslag(genmatch3, uitslag13);
        coureurService.koppelCoureurAanRaceuitslag(genmatch4, uitslag14);
        coureurService.koppelCoureurAanRaceuitslag(genmatch5, uitslag21);
        coureurService.koppelCoureurAanRaceuitslag(genmatch6, uitslag22);
        coureurService.koppelCoureurAanRaceuitslag(genmatch7, uitslag23);
        coureurService.koppelCoureurAanRaceuitslag(genmatch8, uitslag24);
        coureurService.koppelCoureurAanRaceuitslag(genmatch9, uitslag25);

        // Koppel de racecontainer aan competitie
        competitie1.setRaces(races1);
        competitie2.setRaces(races2);

        // Sla de competities op in DB
        competitieRepository.save(competitie1);
        competitieRepository.save(competitie2);

    }

    /**
     * @param raceresultaten:       Dit is een lijst met de uitkomst van een gegenereerde formule1 race.
     * @param koppelAanRaceuitslag: dit de raceuitslag waar de uitkomst van raceresultaten aan gekoppeld moet worden
     **/
    private List<Coureur> geefLijstMetNieuweCoureurObjecten(List<Coureur> raceresultaten, Raceuitslag koppelAanRaceuitslag) {
        List<Coureur> lijstMetNieuweCoureurObjecten = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Coureur eenCoureur = raceresultaten.get(i);
            lijstMetNieuweCoureurObjecten.add(new Coureur(eenCoureur.getName(), eenCoureur.getEindpositie(), koppelAanRaceuitslag));
        }
        return lijstMetNieuweCoureurObjecten;
    }

    private void doVoorspelling(VoorspellingRepository voorspellingRepository, Raceuitslag raceuitslag){
        Voorspelling voorspelling1 = new Voorspelling();
        voorspelling1.setRace(raceuitslag);
        voorspelling1.setCoureurId(7L);
        voorspelling1.setCoureurNaam("Lewis Hamilton");
        voorspelling1.setVoorspellingEindpositie(2);

        voorspellingRepository.save(voorspelling1);

        Voorspelling voorspelling2 = new Voorspelling();
        voorspelling2.setRace(raceuitslag);
        voorspelling2.setCoureurId(3L);
        voorspelling2.setCoureurNaam("Alexander Albon");
        voorspelling2.setVoorspellingEindpositie(3);

        voorspellingRepository.save(voorspelling2);

        Voorspelling voorspelling3 = new Voorspelling();
        voorspelling3.setRace(raceuitslag);
        voorspelling3.setCoureurId(20L);
        voorspelling3.setCoureurNaam("Max Verstappen");
        voorspelling3.setVoorspellingEindpositie(1);

        voorspellingRepository.save(voorspelling3);

    }

    private void init_gebruikers(GebruikerRepository gebruikerRepository){
        List<Gebruiker> gebruikers = new ArrayList<>();
        GebruikerService service = new GebruikerService(gebruikerRepository);

        Gebruiker user1 = new Gebruiker("noviadmin", "noviadmin");
        Gebruiker user2 = new Gebruiker("evan", "evan");

        gebruikerRepository.save(user1);
        gebruikerRepository.save(user2);
        service.gebruikerToevoegen(user1);
        service.gebruikerToevoegen(user2);

    }

}
