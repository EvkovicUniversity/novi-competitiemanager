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

}
