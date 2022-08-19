package com.example.novi.ncmdb.model.formula1.raceuitslag;

import com.example.novi.ncmdb.model.formula1.competitie.Competitie;
import com.example.novi.ncmdb.model.formula1.competitie.CompetitieService;
import com.example.novi.ncmdb.model.formula1.coureur.Coureur;
import com.example.novi.ncmdb.model.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.model.formula1.races.Races;
import com.example.novi.ncmdb.model.formula1.races.RacesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RaceuitslagService {

    private final RaceuitslagRepository raceuitslagRepository;
    private final CompetitieService competitieService;
    private final CoureurService coureurService;
    private final RacesService racesService;

    public RaceuitslagService(RaceuitslagRepository raceuitslagRepository, CompetitieService competitieService, CoureurService coureurService, RacesService racesService) {
        this.raceuitslagRepository = raceuitslagRepository;
        this.competitieService = competitieService;
        this.coureurService = coureurService;
        this.racesService = racesService;
    }

    public void save(Raceuitslag raceuitslag) {
        raceuitslagRepository.save(raceuitslag);
    }

    public List<Raceuitslag> findAll() {
        return raceuitslagRepository.findAll();
    }

    public Raceuitslag findById(String id) {
        return raceuitslagRepository.findById(id).get();
    }

    public void doRace(Long competitieId) {
        Competitie competitie = competitieService.findById(competitieId);
        Races races = competitie.getRaces();

        //Eerst kijken of er een voorspelling gedaan is. Zo ja, dan bestaat het object Raceuitslag al.
        int index = races.getRaceResultaten().size();
        Raceuitslag laatsteRace = findById(ifExists());

        if (!laatsteRace.isPlayed()) {

            List<Coureur> genmatch = coureurService.generateF1Match();
            coureurService.koppelCoureurAanRaceuitslag(genmatch, laatsteRace);

            laatsteRace.setPlayed();
            raceuitslagRepository.save(laatsteRace);
        } else {

            Raceuitslag nieuweUitslag = new Raceuitslag(races);

            nieuweUitslag.setId(false);
            raceuitslagRepository.save(nieuweUitslag);

            List<Coureur> genmatch = coureurService.generateF1Match();

            coureurService.koppelCoureurAanRaceuitslag(genmatch, nieuweUitslag);
            nieuweUitslag.setRaceuitkomst(genmatch);

            racesService.save(races);
            raceuitslagRepository.save(nieuweUitslag);
            competitieService.save(competitie);

        }
    }

    public String ifExists() {
        String competitieId = "22";
        String filler = "Race";
        String string = "";
        int i = 0;

        try {

            for (i = 0; ; i++) {
                string = "";

                if (i < 10) {
                    filler = "Race0" + i;
                } else {
                    filler = "Race" + i;
                }
                findById(competitieId+filler+string);

            }
        } catch (NoSuchElementException e) {
            filler = "Race0";
            return competitieId+filler+(i-1);
        }

    }

}
