package com.example.novi.ncmdb.domain.Formula1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class F1Competitie {

    @Id
    @GeneratedValue
    private Long id;
    private String competitienaam;
    private String spelers_db_id;
    private LocalDateTime startmoment;
    private int raceAantal;
    private int tijdaantal;
    private String tijdseenheid;

    public F1Competitie(String competitienaam,
                        String spelers_db_id,
                        LocalDateTime startmoment,
                        int raceAantal,
                        int tijdaantal,
                        String tijdseenheid) {
        this.competitienaam = competitienaam;
        this.spelers_db_id = spelers_db_id;
        this.startmoment = startmoment;
        this.raceAantal = raceAantal;
        this.tijdaantal = tijdaantal;
        this.tijdseenheid = tijdseenheid;
    }

    public F1Competitie() {

    }

    public Long getId() {
        return id;
    }

    public String getCompetitienaam() {
        return competitienaam;
    }

    public void setCompetitienaam(String competitienaam) {
        this.competitienaam = competitienaam;
    }

    public String getSpelers_db_id() {
        return spelers_db_id;
    }

    public void setSpelers_db_id(String spelers_db_id) {
        this.spelers_db_id = spelers_db_id;
    }

    public LocalDateTime getStartmoment() {
        return startmoment;
    }

    public void setStartmoment(LocalDateTime startmoment) {
        this.startmoment = startmoment;
    }

    public int getRaceAantal() {
        return raceAantal;
    }

    public void setRaceAantal(int raceAantal) {
        this.raceAantal = raceAantal;
    }

    public int getTijdaantal() {
        return tijdaantal;
    }

    public void setTijdaantal(int tijdaantal) {
        this.tijdaantal = tijdaantal;
    }

    public String getTijdseenheid() {
        return tijdseenheid;
    }

    public void setTijdseenheid(String tijdseenheid) {
        this.tijdseenheid = tijdseenheid;
    }
}
