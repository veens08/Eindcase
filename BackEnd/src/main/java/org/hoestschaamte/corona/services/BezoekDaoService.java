package org.hoestschaamte.corona.services;

import org.hoestschaamte.corona.domain.Bezoek;

import java.util.Set;

public interface BezoekDaoService extends DefaultDaoService<Bezoek> {

    Set<Bezoek> getBezoekenFromDatumTijdslotAndCluster(String datum, int tijdslot, int tafelcluster);
}
