package org.hoestschaamte.corona.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hoestschaamte.corona.config.LocalDateAdapter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Entity
public class Reservering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonFormat(pattern = "dd-mm-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate datum;
    private int tijdSlot;
    private String code;
    private int aantalPersonen;
    private static int teller;
    @OneToOne
    private Tafel tafel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "U moet een contactpersoon opgeven")
    private Persoon contactpersoon;

    public Reservering(Persoon contacpersoon, Tafel tafel){
        setContactpersoon(contacpersoon);
        setTafel (tafel);
        setCode(createReserveringsCode());
    }

    public Reservering() { }

    public int getId() {
        return id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getTijdSlot() {
        return tijdSlot;
    }

    public void setTijdSlot(int tijdSlot) {
        this.tijdSlot = tijdSlot;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Persoon getContactpersoon() {
        return contactpersoon;
    }

    public void setContactpersoon(Persoon contactpersoon) {
        this.contactpersoon = contactpersoon;
    }

    public static String createReserveringsCode() {
        return "CORONA-" + teller++;
    }

    public Tafel getTafel() {
        return tafel;
    }

    public void setTafel(Tafel tafel) {
        this.tafel = tafel;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "id=" + id +
                ", datum=" + datum +
                ", tijdSlot=" + tijdSlot +
                ", code='" + code + '\'' +
                ", aantalPersonen=" + aantalPersonen +
                ", contactpersoon=" + contactpersoon +
                '}';
    }

}
