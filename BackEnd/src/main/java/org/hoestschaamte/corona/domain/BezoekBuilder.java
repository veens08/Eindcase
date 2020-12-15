package org.hoestschaamte.corona.domain;

import java.time.LocalDate;
import java.util.List;

public class BezoekBuilder {

    private Bezoek bezoek;

    private BezoekBuilder(Tafel tafel, List<Persoon> gasten) {
        this.bezoek = new Bezoek(tafel, gasten);
    }

    public static BezoekBuilder createBezoek(Tafel tafel, List<Persoon> gasten) {
        return new BezoekBuilder(tafel, gasten);
    }

    public BezoekBuilder metDatum(LocalDate datum) {
        this.bezoek.setDatum(datum);
        return this;
    }

    public BezoekBuilder metTijdslot(int tijdSlot) {
        this.bezoek.setTijdSlot(tijdSlot);
        return this;
    }

    public Bezoek build() {
        return this.bezoek;
    }
}
