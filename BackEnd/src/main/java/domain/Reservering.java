package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservering {

    @Id
    @GeneratedValue
    private int id;
    private String naam;

    public Reservering(String naam){
        setId(id);
        setNaam(naam);
    }

    public Reservering() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
