package org.hoestschaamte.corona.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate reserveringsDatum;
    private int tijdSlot;
    private String code;
    private int aantalPersonen;
    private static int teller;
//    @OneToOne
//    private Tafel tafel;

    @ManyToOne(optional = false)
    private Persoon contacpersoon;

    public Reservering(Persoon contacpersoon){
        teller++;
        setContacpersoon(contacpersoon);
        this.code = createReserveringsCode();
    }

    public Reservering() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getReserveringsDatum() {
        return reserveringsDatum;
    }

    public void setReserveringsDatum(LocalDate reserveringsDatum) {
        this.reserveringsDatum = reserveringsDatum;
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

    public Persoon getContacpersoon() {
        return contacpersoon;
    }

    public void setContacpersoon(Persoon contacpersoon) {
        this.contacpersoon = contacpersoon;
    }

    private String createReserveringsCode() {
        return "CORONA-" + teller;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "id=" + id +
                ", reserveringsDatum=" + reserveringsDatum +
                ", tijdSlot=" + tijdSlot +
                ", aantalPersonen=" + aantalPersonen +
                '}';
    }
}
