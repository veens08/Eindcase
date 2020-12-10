package services.impl;

import domain.Reservering;
import services.ReserveringDaoService;
import services.impl.DefaultDaoServiceImpl;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class ReserveringDaoServiceImpl extends DefaultDaoServiceImpl<Reservering> implements ReserveringDaoService {

    public ReserveringDaoServiceImpl() {
        super(Reservering.class);
    }

    @Override
    public Reservering getByReserveringsCode(String reserveringsCode) {
        final String stringQuery = "SELECT r FROM Reservering AS r " +
                "WHERE r.code = '" + reserveringsCode + "'";
        Optional<Reservering> reserveringOptional = voerQueryUitEnGeefEnkeleResultaatTerug(stringQuery);
        return reserveringOptional.isPresent() ? reserveringOptional.get() : null;
    }
}
