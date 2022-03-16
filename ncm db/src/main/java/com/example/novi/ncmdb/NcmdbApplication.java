package com.example.novi.ncmdb;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.competitie.CompetitieRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurController;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
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
        RaceuitslagRepository raceuitslagRepository =
                configurableApplicationContext.getBean(RaceuitslagRepository.class);


        NcmdbApplication app = new NcmdbApplication();
        app.db_init(
                coureurRepository,
                competitieRepository,
                raceuitslagRepository
        );

    }

    private void db_init(
            CoureurRepository coureurRep,
            CompetitieRepository competitieRep,
            RaceuitslagRepository raceuitslagRep
    ) {
        init_coureurs(coureurRep);
        init_competities(competitieRep);
        init_raceuitslagen(coureurRep, raceuitslagRep);
    }

    private void init_gebruikers() {

    }

    private void init_coureurs(CoureurRepository coureurRepository) {
        List<Coureur> coureurs = getCoureurList();

        coureurRepository.saveAll(coureurs);
    }

    private void init_competities(CompetitieRepository competitieRepository) {
        List<Competitie> competities = getCompetities();

        competitieRepository.saveAll(competities);
    }

    private void init_raceuitslagen(CoureurRepository coureurRepository, RaceuitslagRepository raceuitslagRepository) {
        List<Raceuitslag> raceresultaten = getRaceresultaten(coureurRepository);

        raceuitslagRepository.saveAll(raceresultaten);
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
//        LocalDateTime tijdnu = LocalDateTime.now();

        competities.add(new Competitie("OTS"));
        competities.add(new Competitie("Evan"));
        competities.add(new Competitie("Herman"));
        competities.add(new Competitie("Nivea"));
        competities.add(new Competitie("Roos"));
        competities.add(new Competitie("Duyvis"));

        return competities;
    }

    private List<Raceuitslag> getRaceresultaten(CoureurRepository coureurRep){
        List<Raceuitslag> raceuitslagen = new ArrayList<>();
        CoureurService service = new CoureurService(coureurRep);
//        List<Coureur> generatedRace1 = service.generateF1Match();

//        raceuitslagen.add(new Raceuitslag("Henk", generatedRace1));
//        raceuitslagen.add(new Raceuitslag("John", generatedRace1));
//        raceuitslagen.add(new Raceuitslag("Floris", generatedRace1));
//        raceuitslagen.add(new Raceuitslag("Boris", generatedRace1));
//        raceuitslagen.add(new Raceuitslag("Joost", generatedRace1));

        raceuitslagen.add(new Raceuitslag("Henk"));
        raceuitslagen.add(new Raceuitslag("John"));
        raceuitslagen.add(new Raceuitslag("Floris"));
        raceuitslagen.add(new Raceuitslag("Boris"));
        raceuitslagen.add(new Raceuitslag("Joost"));




        return raceuitslagen;
    }

}
