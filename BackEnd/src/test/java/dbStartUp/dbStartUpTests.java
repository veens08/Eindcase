package dbStartUp;

import domain.Reservering;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class dbStartUpTests {
    @Test
    void maakTabellenInDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hoestschaamteCoronaApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        ArrayList<Reservering> reserveringen = new ArrayList<Reservering>();
        reserveringen.add(new Reservering("Evan"));

        tx.begin();
        for (Reservering reservering : reserveringen) {
            em.persist(reservering);
        }
        tx.commit();
    }
}
