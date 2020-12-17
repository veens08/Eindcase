package org.hoestschaamte.corona.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bezoek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String datum;
    private int tijdSlot;

    @OneToMany(cascade = CascadeType.PERSIST)
//    @NotNull(message = "U moet een gast opgeven")
//    @Min(1)
//    @Max(4)
    private List<Persoon> gasten;

    @OneToOne
    private Tafel tafel;

    public Bezoek() {
    }

    public Bezoek(Tafel tafel, List<Persoon> gasten) {
        super();
        setTafel(tafel);
        setGasten(gasten);
    }

    public int getId() {
        return id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getTijdSlot() {
        return tijdSlot;
    }

    public void setTijdSlot(int tijdSlot) {
        this.tijdSlot = tijdSlot;
    }

    public List<Persoon> getGasten() {
        return gasten;
    }

    public void setGasten(List<Persoon> gasten) {
        this.gasten = gasten;
    }

    public Tafel getTafel() {
        return tafel;
    }

    public void setTafel(Tafel tafel) {
        this.tafel = tafel;
    }

    @Override
    public String toString() {
        return "Bezoek{" +
                "id=" + id +
                ", datum=" + datum +
                ", tijdSlot=" + tijdSlot +
                ", gasten=" + gasten +
                '}';
    }

}
