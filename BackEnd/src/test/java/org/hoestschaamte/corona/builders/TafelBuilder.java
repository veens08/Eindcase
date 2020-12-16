package org.hoestschaamte.corona.builders;

import org.hoestschaamte.corona.domain.Tafel;

public class TafelBuilder {

    private Tafel tafel;

    private TafelBuilder(int tafelNummer) {
        this.tafel = new Tafel(tafelNummer);
    }

    public static TafelBuilder createTafel(int tafelNummer) {
        return new TafelBuilder(tafelNummer);
    }

    public TafelBuilder metAantalPersonen(int aantalPersonen) {
        this.tafel.setAantalZitplaatsen(aantalPersonen);
        return this;
    }

    public TafelBuilder metCluster(int cluster) {
        this.tafel.setCluster(cluster);
        return this;
    }

    public Tafel build() {
        return this.tafel;
    }
}
