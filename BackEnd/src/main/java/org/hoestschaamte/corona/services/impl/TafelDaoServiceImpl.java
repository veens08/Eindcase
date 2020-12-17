package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TafelDaoServiceImpl extends DefaultDaoServiceImpl<Tafel> implements TafelDaoService {

    public TafelDaoServiceImpl() {
        super(Tafel.class);
    }

    @Override
    public Tafel wijsBeschikbareTafelToe(String datum, int tijdslot){
        final String query = "SELECT ta FROM Tafel ta " +
                "WHERE ta not in (" +
                "SELECT r.tafel FROM Reservering r " +
                "WHERE r.datum = :datum AND r.tijdSlot = :tijdslot)";

        final TypedQuery<Tafel> tq = em
                .createQuery(query, Tafel.class)
                .setParameter("datum", datum)
                .setParameter("tijdslot", tijdslot);

        List<Tafel> tafellijst = tq.getResultList();
        if (tafellijst.size() > 0){
            return tafellijst.get(0);
        }
        return null;

    }

}
