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
    private int nummer;
    private int aantalZitplaatsen;
    private int cluster;

    public Tafel() {
    }

    public Tafel(int nummer) {
        this.nummer = nummer;
    }

    public int getId() {
        return id;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getAantalZitplaatsen() {
        return aantalZitplaatsen;
    }

    public void setAantalZitplaatsen(int aantalZitplaatsen) {
        this.aantalZitplaatsen = aantalZitplaatsen;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        return "Tafel{" +
                "id=" + id +
                ", nummer=" + nummer +
                ", aantalZitplaatsen=" + aantalZitplaatsen +
                '}';
    }
}
