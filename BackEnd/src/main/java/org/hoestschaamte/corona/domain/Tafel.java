package org.hoestschaamte.corona.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tafel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tafelNummer;
    private int aantalZitplaatsen;

    public Tafel() {
    }

    public Tafel(int tafelNummer, int aantalZitplaatsen) {
        this.tafelNummer = tafelNummer;
        this.aantalZitplaatsen = aantalZitplaatsen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTafelNummer() {
        return tafelNummer;
    }

    public void setTafelNummer(int tafelNummer) {
        this.tafelNummer = tafelNummer;
    }

    public int getAantalZitplaatsen() {
        return aantalZitplaatsen;
    }

    public void setAantalZitplaatsen(int aantalZitplaatsen) {
        this.aantalZitplaatsen = aantalZitplaatsen;
    }

    @Override
    public String toString() {
        return "Tafel{" +
                "id=" + id +
                ", tafelNummer=" + tafelNummer +
                ", aantalZitplaatsen=" + aantalZitplaatsen +
                '}';
    }
}
