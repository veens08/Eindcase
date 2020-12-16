package org.hoestschaamte.corona.domain;

import org.hoestschaamte.corona.config.LocalDateAdapter;
import org.hoestschaamte.corona.config.LocalDateAttributeConverter;
import org.hoestschaamte.corona.resources.TafelResource;
import org.hoestschaamte.corona.services.TafelDaoService;
import org.hoestschaamte.corona.services.impl.TafelDaoServiceImpl;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Entity
public class Reservering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
//    @Convert(converter = LocalDateAttributeConverter.class)
    private String datum;
    private int tijdSlot;
    private String code;
    private int aantalPersonen;
    private static int teller = 10000;

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

    public String getDatum(){
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
        String format = String.format("%05d", teller++);
        String hs = "HS-";

        return hs + format;
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
