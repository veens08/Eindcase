package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.ws.rs.GET;

@Entity
public class Persoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    private String telNr;
    private String email;

    public Persoon() {
    }

    public Persoon(String naam, String telNr, String email) {
        this.naam = naam;
        this.telNr = telNr;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", telNr='" + telNr + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
