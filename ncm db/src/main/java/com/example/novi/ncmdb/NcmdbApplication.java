package com.example.novi.ncmdb;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.competitie.CompetitieRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
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







        NcmdbApplication app = new NcmdbApplication();

        app.db_init(
                coureurRepository,
                competitieRepository,
                raceuitslagRepository,
                racesRepository
        );

    }

    private void db_init(
            CoureurRepository coureurRep,
            CompetitieRepository competitieRep,
            RaceuitslagRepository raceuitslagRep,
            RacesRepository racesRep
    ) {
        init_coureurs(coureurRep);

        getCompetitiesMetRaces(coureurRep, raceuitslagRep, racesRep, competitieRep);


    }

    private void init_coureurs(CoureurRepository coureurRepository) {
        List<Coureur> coureurs = getCoureurList();

        coureurRepository.saveAll(coureurs);
    }

    private List<Coureur> getCoureurList() {

        List<Coureur> coureurs = new ArrayList<>();

        coureurs.add(new Coureur("Alexander Albon", 1));
        coureurs.add(new Coureur("Fernando Alonso", 1));
        coureurs.add(new Coureur("Valtteri Bottas", 1));
        coureurs.add(new Coureur("Pierre Gasly", 1));
        coureurs.add(new Coureur("Lewis Hamilton", 1));
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
        coureurs.add(new Coureur("Max Verstappen", 1));
        coureurs.add(new Coureur("Sebastian Vettel", 1));
        coureurs.add(new Coureur("Guanyu Zhou", 1));

        return coureurs;
    }

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

    private void getCompetitiesMetRaces(CoureurRepository coureurRepository, RaceuitslagRepository raceuitslagRepository, RacesRepository racesRepository, CompetitieRepository competitieRepository){
        // Maak Competities.
        Competitie competitie1 = new Competitie("CompetitieCompleet1");
        Competitie competitie2 = new Competitie("CompetitieCompleet2");

        // Maak de containers waarin de races worden opgeslagen.
        Races races1 = new Races();
        Races races2 = new Races();

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

        // Sla de racecontainers op in DB
        racesRepository.save(races1);
        racesRepository.save(races2);

        // Sla de races op in DB
        // Uitslagen voor 'races1'
        raceuitslagRepository.save(uitslag11);
        raceuitslagRepository.save(uitslag12);
        raceuitslagRepository.save(uitslag13);
        raceuitslagRepository.save(uitslag14);

        // Uitslagen voor 'races2'
        raceuitslagRepository.save(uitslag21);
        raceuitslagRepository.save(uitslag22);
        raceuitslagRepository.save(uitslag23);
        raceuitslagRepository.save(uitslag24);


        CoureurService coureurService = new CoureurService(coureurRepository);

        // Genereer een raceuitkomst
        List<Coureur> eenRace = coureurService.generateF1Match();

        // Maak nieuwe coureurobjecten. In dit nieuwe object zijn coureur (dus zijn eindpositie) & uitslag met elkaar verbonden
        List<Coureur> lijstMetNieuweCoureurObjecten1 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag11);
        List<Coureur> lijstMetNieuweCoureurObjecten2 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag12);
        List<Coureur> lijstMetNieuweCoureurObjecten3 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag13);
        List<Coureur> lijstMetNieuweCoureurObjecten4 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag14);
        List<Coureur> lijstMetNieuweCoureurObjecten5 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag21);
        List<Coureur> lijstMetNieuweCoureurObjecten6 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag22);
        List<Coureur> lijstMetNieuweCoureurObjecten7 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag23);
        List<Coureur> lijstMetNieuweCoureurObjecten8 = geefLijstMetNieuweCoureurObjecten(eenRace, uitslag24);

        // Sla op in DB
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten1);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten2);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten3);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten4);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten5);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten6);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten7);
        coureurRepository.saveAll(lijstMetNieuweCoureurObjecten8);

        // Zet de races in een lijst
        List<Raceuitslag> uitslagVoor1 = Arrays.asList(uitslag11, uitslag12, uitslag13, uitslag14);
        List<Raceuitslag> uitslagVoor2 = Arrays.asList(uitslag21, uitslag22, uitslag23, uitslag24);

        // Koppel de races aan een racecontainer
        races1.setRaceResultaten(uitslagVoor1);
        races2.setRaceResultaten(uitslagVoor2);

        // Sla op in DB
        racesRepository.save(races1);
        racesRepository.save(races2);

        // Koppel de racecontainer aan competitie
        competitie1.setRaces(races1);
        competitie2.setRaces(races2);

        // Sla de competities op in DB
        competitieRepository.save(competitie1);
        competitieRepository.save(competitie2);
    }

    /**
     *
     * @param raceresultaten: Dit is een lijst met de uitkomst van een gegenereerde formule1 race.
     * @param koppelAanRaceuitslag: dit de raceuitslag waar de uitkomst van raceresultaten aan gekoppeld moet worden
     *
     **/
    private List<Coureur> geefLijstMetNieuweCoureurObjecten(List<Coureur> raceresultaten, Raceuitslag koppelAanRaceuitslag) {
        List<Coureur> lijstMetNieuweCoureurObjecten = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Coureur eenCoureur = raceresultaten.get(i);
            lijstMetNieuweCoureurObjecten.add(new Coureur(eenCoureur.getName(), eenCoureur.getEindpositie(), koppelAanRaceuitslag));
        }
        return lijstMetNieuweCoureurObjecten;
    }

}
