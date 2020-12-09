package domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate reserveringsDatum;
    private int tijdSlot;
    private String naam;
    private int aantalPersonen;
//    @OneToOne
//    private Tafel tafel;
//    @OneToOne
//    private Persoon persoon;

    public Reservering(LocalDate reserveringsDatum, int tijdSlot, String naam, int aantalPersonen){
         setReserveringsDatum (reserveringsDatum);
         setTijdSlot (tijdSlot);
         setNaam(naam);
         setAantalPersonen (aantalPersonen);
    }

    public Reservering() {
    }

    public void setId(int id) {
        this.id = id;
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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "id=" + id +
                ", reserveringsDatum=" + reserveringsDatum +
                ", tijdSlot=" + tijdSlot +
                ", naam='" + naam + '\'' +
                ", aantalPersonen=" + aantalPersonen +
                '}';
    }
}
