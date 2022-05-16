package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagService;
import com.example.novi.ncmdb.domain.competitiemanager.utils.DataUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

import static java.lang.Long.parseLong;

@Service
public class VoorspellingService {

    private final VoorspellingRepository voorspellingRepository;
    private final RaceuitslagService raceuitslagService;
    private final RacesService racesService;
    private final CompetitieService competitieService;
    private final DataUtils utils = new DataUtils();

    /**
     * Constructor
     */
    public VoorspellingService(VoorspellingRepository voorspellingRepository, RaceuitslagService raceuitslagService, RacesService racesService, CompetitieService competitieService){
        this.voorspellingRepository = voorspellingRepository;
        this.raceuitslagService = raceuitslagService;
        this.racesService = racesService;
        this.competitieService = competitieService;
    }

    /**
     * Methods
     */
    public Voorspelling findById(Long voorspellingId) {
        return voorspellingRepository.findById(voorspellingId).get();
    }

    public void save(Voorspelling voorspelling) {
        voorspellingRepository.save(voorspelling);
    }

    public Voorspelling maakVoorspelling(String coureurnaam) {
        Voorspelling voorspelling = new Voorspelling();
        voorspelling.setVoorspellingEindpositie(1);
        voorspelling.setCoureurNaam(coureurnaam);

        return voorspelling;
    }

    public void addVoorspelling(String jsonbody) throws EntityExistsException {
        String competitieId = getCompetitieId(jsonbody);
        String coureurNaam = getCoureurNaam(jsonbody);

        Competitie competitie = getCompetitie(competitieId);

        //Creër voorspelling Object
        Voorspelling voorspelling = maakVoorspelling(coureurNaam);

        //Creër de nog-niet-gespeelde Raceuitslag
        Raceuitslag futureRaceuitslag = new Raceuitslag();
        futureRaceuitslag.setRaces(competitie.getRaces());
        futureRaceuitslag.setId(false);

        //Koppel de race aan de container
        Races racecontainer = competitie.getRaces();
        racecontainer.addRaceResultaat(futureRaceuitslag);
        voorspelling.setRaceuitslag(futureRaceuitslag);
        competitie.setRaces(racecontainer);

        //Sla op
        save(voorspelling);
        raceuitslagService.save(futureRaceuitslag);
        racesService.save(racecontainer);
        competitieService.save(competitie);
    }

    public String getCompetitieId(String jsonbody) {
        return utils.extractCompetitieId(jsonbody);
    }

    public String getCoureurNaam(String jsonbody) {
        return utils.extractName(jsonbody);
    }

    private Competitie getCompetitie(String competitieId) {
        Long competitieIdLong = parseLong(competitieId);

        return competitieService.findById(competitieIdLong);
    }
}
