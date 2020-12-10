package services.impl;

import domain.Persoon;
import services.PersoonDaoService;

import javax.transaction.Transactional;

@Transactional
public class PersoonDaoServiceImpl extends DefaultDaoServiceImpl<Persoon> implements PersoonDaoService {

    public PersoonDaoServiceImpl() {
        super(Persoon.class);
    }
}
