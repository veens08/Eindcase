package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Tafel;
import org.hoestschaamte.corona.services.TafelDaoService;

import javax.transaction.Transactional;

@Transactional
public class TafelDaoServiceImpl extends DefaultDaoServiceImpl<Tafel> implements TafelDaoService {

    public TafelDaoServiceImpl() {
        super(Tafel.class);
    }
}
