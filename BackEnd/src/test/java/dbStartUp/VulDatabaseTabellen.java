package dbStartUp;

import domain.Persoon;
import domain.Reservering;
import domain.Tafel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;

public class VulDatabaseTabellen {

    public void maakTafelsVoorTestAan() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager ();
        EntityTransaction tx = em.getTransaction ();
        tx.begin ();

        ArrayList<Tafel> tafels = new ArrayList<Tafel> ();
        for (int tafelnummer = 1; tafelnummer < 9; tafelnummer++) {
            tafels.add (new Tafel (tafelnummer, 4));
            em.persist (tafels);
        }
        tx.commit ();
    }

    public void vulPersonenVoorTest () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager ();
        EntityTransaction tx = em.getTransaction ();

        ArrayList<Persoon> personen = new ArrayList<Persoon> ();
        personen.add (new Persoon ("Evan", "06-12345678", "evan@gmail.com"));
        personen.add (new Persoon ("Joshua", "06-11223344", "joshua@gmail.com"));
        personen.add (new Persoon ("Sjoerd", "06-87654321", "sjoerd@gmail.com"));

        tx.begin ();
        for (Persoon persoon : personen) {
            em.persist(persoon);
        }
        tx.commit ();
    }

    public void maakReserveringenVoorTestAan() {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
         EntityManager em = emf.createEntityManager ();
         EntityTransaction tx = em.getTransaction ();

         ArrayList<Reservering> reserveringen = new ArrayList<Reservering> ();
         reserveringen.add (new Reservering (LocalDate.of(2020,12, 24), 1,"Evan",3 ));
         reserveringen.add (new Reservering (LocalDate.of (2020,12,25), 1,"Joshua",4 ));
         reserveringen.add (new Reservering (LocalDate.of (2020,12,26), 1,"Sjoerd",3 ));

         tx.begin ();
         for (Reservering reservering : reserveringen) {
             em.persist (reservering);
         }
         tx.commit ();

    }
}
