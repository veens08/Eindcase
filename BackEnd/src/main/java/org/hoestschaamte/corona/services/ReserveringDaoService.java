package org.hoestschaamte.corona.services;

import org.hoestschaamte.corona.domain.Reservering;

import java.time.LocalDate;
import java.util.List;

public interface ReserveringDaoService extends DefaultDaoService<Reservering> {

    /**
     * Deze methode haalt een Reservering object op van de database met een specifieke code
     * @param reserveringsCode
     * @return
     */
    Reservering getByReserveringsCode(String reserveringsCode);

    List<Reservering> getReserveringenByTijdslot(String datum, int tijdslot);

    /**
     * Pardon my English..
     * Deze methode haalt alle reserveringen op die al omgeboekt zijn naar een bezoek
     * @return
     */
    List<Reservering> getAllReserveringenDieOmgeboektZijn();

}
