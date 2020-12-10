package org.hoestschaamte.corona.services;

import org.hoestschaamte.corona.domain.Reservering;

public interface ReserveringDaoService extends DefaultDaoService<Reservering> {

    /**
     * Deze methode haalt een Reservering object op van de database met een specifieke code
     * @param reserveringsCode
     * @return
     */
    Reservering getByReserveringsCode(String reserveringsCode);
}
