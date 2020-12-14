package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.domain.Bezoek;
import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.services.BezoekDaoService;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class BezoekDaoServiceImpl extends DefaultDaoServiceImpl<Bezoek> implements BezoekDaoService {

    public BezoekDaoServiceImpl() {
            super(Bezoek.class);
        }

}
