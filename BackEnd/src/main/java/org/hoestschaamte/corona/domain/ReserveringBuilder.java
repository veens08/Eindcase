package org.hoestschaamte.corona.domain;

import java.time.LocalDate;

public class ReserveringBuilder {

    private Reservering reservering;

    private ReserveringBuilder(Persoon contactpersoon) {
        this.reservering = new Reservering(contactpersoon);
    }

    public static ReserveringBuilder createReservering(Persoon contactpersoon) {
        return new ReserveringBuilder(contactpersoon);
    }

    public ReserveringBuilder metDatum(LocalDate reserveringsDatum) {
        this.reservering.setDatum(reserveringsDatum);
        return this;
    }

    public ReserveringBuilder metTijdslot(int tijdSlot) {
        this.reservering.setTijdSlot(tijdSlot);
        return this;
    }

    public ReserveringBuilder metAantalPersonen(int aantalPersonen) {
        this.reservering.setAantalPersonen(aantalPersonen);
        return this;
    }

    public Reservering build() {
        return this.reservering;
    }
}
