package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.services.ReserveringDaoService;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
public class ReserveringDaoServiceImpl extends DefaultDaoServiceImpl<Reservering> implements ReserveringDaoService {

    public ReserveringDaoServiceImpl() {
        super(Reservering.class);
    }

    @Override
    public List<Reservering> getAllReserveringenDieOmgeboektZijn() {
        final String stringQuery = "SELECT r FROM Reservering AS r " +
                "WHERE r.isOmgeboekt = FALSE";

        return haalLijstOpVanQuery(stringQuery);
    }

    @Override
    public Reservering getReserveringenByDatumTijdslotAndTafelNummer(String datum, int tijdslot, int tafelnummer) {
        final String query = "SELECT r FROM Reservering r " +
                "INNER JOIN Tafel t " +
                "WHERE r.datum = :datum " +
                "AND t.nummer = :nummer " +
                "AND r.tijdSlot = :tijdslot";

        final TypedQuery<Reservering> tq = em
                .createQuery(query, Reservering.class)
                .setParameter("datum", datum)
                .setParameter("nummer", tafelnummer)
                .setParameter("tijdslot", tijdslot);

        List<Reservering> reserveringen = tq.getResultList();
        System.out.println(reserveringen);
        if (reserveringen.size() == 0) {
            return reserveringen.get(0);
        }
        return null;
    }

    @Override
    public Reservering getByReserveringsCode(String reserveringsCode) {
        final String stringQuery = "SELECT r FROM Reservering AS r " +
                "WHERE r.code = '" + reserveringsCode + "'";
        Optional<Reservering> reserveringOptional = voerQueryUitEnGeefEnkeleResultaatTerug(stringQuery);
        return reserveringOptional.isPresent() ? reserveringOptional.get() : null;
    }

    @Override
    public List<Reservering> getReserveringenByTijdslot(String datum, int tijdslot) {
        final String stringQuery = "SELECT r FROM Reservering AS r " +
                "WHERE r.datum = '" + datum +  "' AND r.tijdSlot = " + tijdslot;

        return haalLijstOpVanQuery(stringQuery);
    }

}
