package competitiemanager.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COUREURS")
public class Coureurs implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "winfactor")
    private double winfactor;

    public Coureurs(long id, String naam, double winfactor) {
        setId(id);
        setNaam(naam);
        setWinfactor(winfactor);
    }

    public Coureurs(){}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setWinfactor(double winfactor) {
        this.winfactor = winfactor;
    }

    public double getWinfactor() {
        return winfactor;
    }
}
