package org.hoestschaamte.corona.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hoestschaamte.corona.config.LocalDateAdapter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Bezoek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonFormat(pattern = "dd-mm-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate bezoekDatum;
    private int tijdSlot;

    @OneToMany(cascade = CascadeType.PERSIST)
    @NotNull(message = "U moet gast opgeven")
    private List<Persoon> gasten;

    public Bezoek() {
    }

    public Bezoek(List<Persoon> gasten) {
        super();
        setGasten (gasten);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBezoekDatum() {
        return bezoekDatum;
    }

    public void setBezoekDatum(LocalDate bezoekDatum) {
        this.bezoekDatum = bezoekDatum;
    }

    public int getTijdSlot() {
        return tijdSlot;
    }

    public void setTijdSlot(int tijdSlot) {
        this.tijdSlot = tijdSlot;
    }

    public void setGasten(List<Persoon> gasten) {
        this.gasten = gasten;
    }

    @Override
    public String toString() {
        return "Bezoek{" +
                "id=" + id +
                ", bezoekDatum=" + bezoekDatum +
                ", tijdSlot=" + tijdSlot +
                ", gasten=" + gasten +
                '}';
    }

}
