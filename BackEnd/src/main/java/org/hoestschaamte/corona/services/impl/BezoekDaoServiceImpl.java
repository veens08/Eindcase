package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.services.BezoekDaoService;

import javax.transaction.Transactional;

@Transactional
public class BezoekDaoServiceImpl extends DefaultDaoServiceImpl<Bezoek> implements BezoekDaoService {

    public BezoekDaoServiceImpl() {
            super(Bezoek.class);
        }
}
