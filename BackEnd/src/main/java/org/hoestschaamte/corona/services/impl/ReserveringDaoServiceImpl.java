package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.services.ReserveringDaoService;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class ReserveringDaoServiceImpl extends DefaultDaoServiceImpl<Reservering> implements ReserveringDaoService {

    public ReserveringDaoServiceImpl() {
        super(Reservering.class);
    }

    @Override
    public Reservering getByReserveringsCode(String reserveringsCode) {
        final String stringQuery = "SELECT r FROM Reservering AS r " +
                "WHERE r.code = '" + reserveringsCode + "'";
        Optional<Reservering> reserveringOptional = voerQueryUitEnGeefEnkeleResultaatTerug(stringQuery);
        return reserveringOptional.isPresent() ? reserveringOptional.get() : null;
    }
}
