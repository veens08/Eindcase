package org.hoestschaamte.corona.domain;

import java.time.LocalDate;
import java.util.List;

public class BezoekBuilder {

    private Bezoek bezoek;

    private BezoekBuilder(List<Persoon> gasten) {
        this.bezoek = new Bezoek(gasten);
    }

    public static BezoekBuilder createBezoek(List<Persoon> gasten) {
        return new BezoekBuilder(gasten);
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
