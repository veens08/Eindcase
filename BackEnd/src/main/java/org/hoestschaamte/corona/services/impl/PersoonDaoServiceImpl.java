package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Persoon;
import org.hoestschaamte.corona.services.PersoonDaoService;

import javax.transaction.Transactional;

@Transactional
public class PersoonDaoServiceImpl extends DefaultDaoServiceImpl<Persoon> implements PersoonDaoService {

    public PersoonDaoServiceImpl() {
        super(Persoon.class);
    }
}
