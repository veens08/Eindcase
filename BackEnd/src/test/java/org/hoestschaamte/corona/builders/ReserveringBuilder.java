package org.hoestschaamte.corona.builders;

import org.hoestschaamte.corona.domain.Persoon;
import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.domain.Tafel;

public class ReserveringBuilder {

    private Reservering reservering;

    private ReserveringBuilder(Persoon contactpersoon, Tafel tafel) {
        this.reservering = new Reservering(contactpersoon, tafel);
    }

    public static ReserveringBuilder createReservering(Persoon contactpersoon, Tafel tafel) {
        return new ReserveringBuilder(contactpersoon, tafel);
    }

    public ReserveringBuilder metDatum(String reserveringsDatum){
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

    public ReserveringBuilder isOmgeboekt(boolean isOmgeboekt) {
        this.reservering.setOmgeboekt(isOmgeboekt);
        return this;
    }

    public Reservering build() {
        return this.reservering;
    }
}
