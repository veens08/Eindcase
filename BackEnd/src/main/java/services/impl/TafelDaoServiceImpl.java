package services.impl;

import domain.Tafel;
import services.TafelDaoService;

import javax.transaction.Transactional;

@Transactional
public class TafelDaoServiceImpl extends DefaultDaoServiceImpl<Tafel> implements TafelDaoService {

    public TafelDaoServiceImpl() {
        super(Tafel.class);
    }
}
