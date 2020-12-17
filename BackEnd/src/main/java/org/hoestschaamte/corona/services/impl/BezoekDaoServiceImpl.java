package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.services.BezoekDaoService;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public class BezoekDaoServiceImpl extends DefaultDaoServiceImpl<Bezoek> implements BezoekDaoService {

    public BezoekDaoServiceImpl() {
            super(Bezoek.class);
    }

    @Override
    public Set<Bezoek> getBezoekenFromDatumTijdslotAndCluster(String datum, int tijdslot, int tafelcluster) {
        final String query = "SELECT b FROM Bezoek b " +
                "INNER JOIN Tafel t " +
                "WHERE b.datum = :datum " +
                "AND t.cluster = :cluster " +
                "AND b.tijdSlot = :tijdslot";

        final TypedQuery<Bezoek> tq = em
                .createQuery(query, typeParameterClass)
                .setParameter("datum", datum)
                .setParameter("cluster", tafelcluster)
                .setParameter("tijdslot", tijdslot);
        return new HashSet<>(tq.getResultList());
    }
}
