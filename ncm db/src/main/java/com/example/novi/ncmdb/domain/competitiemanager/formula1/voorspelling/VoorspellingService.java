package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.utils.DataUtils;
import org.springframework.stereotype.Service;

import static java.lang.Long.parseLong;

@Service
public class VoorspellingService {

    private final VoorspellingRepository voorspellingRepository;
    private final CompetitieService competitieService;
    private final DataUtils utils = new DataUtils();

    /**
     * Constructor
     */
    public VoorspellingService(VoorspellingRepository voorspellingRepository, CompetitieService competitieService){
        this.voorspellingRepository = voorspellingRepository;
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

    public void addVoorspelling(String jsonbody) {
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

        //Sla op
        save(voorspelling);
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
