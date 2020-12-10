package dbStartUp;

import org.hoestschaamte.corona.domain.Persoon;
import org.hoestschaamte.corona.domain.Reservering;
import org.hoestschaamte.corona.domain.ReserveringBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class VulDatabaseTabellen {

    public void maakReserveringenVoorTestAan() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        ArrayList<Reservering> reserveringen = new ArrayList<Reservering> ();

        Persoon evan = slaPersoonOpEnHaalUitDatabase("Evan", "06-12345678", "evan@gmail.com");
        Persoon joshua = slaPersoonOpEnHaalUitDatabase("Joshua", "06-11223344", "joshua@gmail.com");
        Persoon sjoerd = slaPersoonOpEnHaalUitDatabase("Sjoerd", "06-87654321", "sjoerd@gmail.com");

        Reservering r1 = ReserveringBuilder
                .createReservering(evan)
                .metAantalPersonen(3)
                .metDatum(LocalDate.of(2020, 12, 25))
                .metTijdslot(3)
                .build();

        Reservering r2 = ReserveringBuilder
                .createReservering(joshua)
                .metAantalPersonen(2)
                .metDatum(LocalDate.of(2020, 12, 24))
                .metTijdslot(1)
                .build();

        Reservering r3 = ReserveringBuilder
                .createReservering(sjoerd)
                .metAantalPersonen(2)
                .metDatum(LocalDate.of(2020, 12, 21))
                .metTijdslot(2)
                .build();

        reserveringen.addAll(Arrays.asList(r1, r2, r3));

        tx.begin();
        for (Reservering r : reserveringen) {
            em.persist(r);
        }
        tx.commit();
        em.clear();
        emf.getCache().evictAll();
    }

    private Persoon slaPersoonOpEnHaalUitDatabase(String naam, String telefoonnummer, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persoon persoon = new Persoon(naam, telefoonnummer, email);
        em.persist(persoon);
        tx.commit();
        System.out.println(persoon);
        em.clear();
        emf.getCache().evictAll();
        return persoon;
    }
}
