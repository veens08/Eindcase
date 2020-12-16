package org.hoestschaamte.corona.services;

import org.hoestschaamte.corona.domain.Tafel;

import java.util.List;

public interface TafelDaoService extends DefaultDaoService<Tafel> {
    public Tafel wijsBeschikbareTafelToe(int tijdslot);
}
