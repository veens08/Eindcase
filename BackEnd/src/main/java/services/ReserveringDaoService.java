package services;

import domain.Reservering;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ReserveringDaoService {

    @PersistenceContext(unitName = "Hoestschaamte")
    EntityManager em;

    public List<Reservering> getReserveringen() {
        String jpql = "SELECT reservering FROM Reservering reservering";
        TypedQuery<Reservering> tq = em.createQuery (jpql, Reservering.class);
        return tq.getResultList ();
    }

    public void saveReservering(Reservering reservering) {
        em.persist (reservering);
    }
}
