package org.hoestschaamte.corona.db;

import org.hoestschaamte.corona.builder.TafelBuilder;
import org.hoestschaamte.corona.domain.*;

import javax.ejb.Local;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VulDatabase {

    public void maakReserveringenVoorTestAan() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Tafel t1 = TafelBuilder
                .createTafel(10)
                .metAantalPersonen(4)
                .metCluster(1)
                .build();

        Tafel t2 = TafelBuilder
                .createTafel(11)
                .metAantalPersonen(4)
                .metCluster(2)
                .build();

        Tafel t3 = TafelBuilder
                .createTafel(12)
                .metAantalPersonen(3)
                .metCluster(1)
                .build();

        List<Tafel> tafels = Arrays.asList(t1, t2, t3);

        tx.begin();
        for (Tafel t : tafels) {
            em.persist(t);
        }
        tx.commit();
        em.clear();
        emf.getCache().evictAll();

        Persoon evan = slaPersoonOpEnHaalUitDatabase("Evan", "06-12345678", "evan@gmail.com");
        Persoon joshua = slaPersoonOpEnHaalUitDatabase("Joshua", "06-11223344", "joshua@gmail.com");
        Persoon sjoerd = slaPersoonOpEnHaalUitDatabase("Sjoerd", "06-87654321", "sjoerd@gmail.com");

        Reservering r1 = ReserveringBuilder
                .createReservering(evan, t1)
                .metAantalPersonen(3)
                .metDatum(LocalDate.of(2020, 12, 25))
//                .metDatum("2020-12-25")
                .metTijdslot(1)
                .build();

        Reservering r2 = ReserveringBuilder
                .createReservering(joshua,t2)
                .metAantalPersonen(2)
                .metDatum(LocalDate.of(2020, 12, 25))
//                .metDatum("2020-12-25")
                .metTijdslot(1)
                .build();

        Reservering r3 = ReserveringBuilder
                .createReservering(sjoerd, t1)
                .metAantalPersonen(2)
                .metDatum(LocalDate.of(2020, 12, 21))
//                .metDatum("2020-12-21")
                .metTijdslot(2)
                .build();

        List<Reservering> reserveringen = Arrays.asList(r1, r2, r3);

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
        return haalPersoonOpUitDatabase (naam);
    }

    private Tafel slaTafelOpEnHaalUitDatabase(Tafel tafel) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(tafel);
        tx.commit();
        System.out.println(tafel);
        em.clear();
        emf.getCache().evictAll();
        return tafel;
    }

    public void maakBezoekenAanVoorTest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        ArrayList<Bezoek> bezoeken = new ArrayList<Bezoek> ();

        Persoon evan = haalPersoonOpUitDatabase("Evan");
        Persoon joshua = haalPersoonOpUitDatabase("Joshua");
        Persoon sjoerd = haalPersoonOpUitDatabase("Sjoerd");
        ArrayList<Persoon> gastenBezoek1 =new ArrayList<Persoon> ();
        gastenBezoek1.add(evan);
        gastenBezoek1.add(joshua);

        Tafel t1 = TafelBuilder
                .createTafel(4)
                .metAantalPersonen(4)
                .metCluster(3)
                .build();

        Tafel t2 = TafelBuilder
                .createTafel(5)
                .metAantalPersonen(4)
                .metCluster(3)
                .build();

        Tafel t3 = TafelBuilder
                .createTafel(6)
                .metAantalPersonen(3)
                .metCluster(4)
                .build();

        List<Tafel> tafels = Arrays.asList(t1, t2, t3);

        tx.begin();
        for (Tafel t : tafels) {
            em.persist(t);
        }
        tx.commit();
        em.clear();
        emf.getCache().evictAll();

        Bezoek b1 = BezoekBuilder
                .createBezoek(t1, gastenBezoek1)
                .metDatum(LocalDate.of(2020,12,15))
                .metTijdslot(1)
                .build();

        ArrayList<Persoon> gastenBezoek2 =new ArrayList<Persoon> ();
        gastenBezoek2.add(sjoerd);
        gastenBezoek2.add(evan);

        Bezoek b2 = BezoekBuilder
                .createBezoek(t2, gastenBezoek2)
                .metDatum(LocalDate.of(2020,12,14))
                .metTijdslot(2)
                .build();
        tx.begin();

        bezoeken.addAll(Arrays.asList(b1, b2));

        for (Bezoek b : bezoeken) {
            em.persist(b);
        }
        tx.commit();
        em.clear();
        emf.getCache().evictAll();
    }

    private Reservering haalReserveringOpOpNaam(String naam){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Reservering> typedQuery = em.createQuery("SELECT r FROM Reservering r WHERE r.contactpersoon.naam = :naam",
                Reservering.class);
        typedQuery.setParameter ("naam", naam);
        List<Reservering> reserveringen = typedQuery.getResultList();

        if (reserveringen.isEmpty ()) {
            return null;
        }

        final Reservering reservering = reserveringen.get (0);

        em.clear();
        emf.getCache().evictAll();
        return reservering;
    }

    private Persoon haalPersoonOpUitDatabase(String naam) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        TypedQuery<Persoon> typedQuery = em.createQuery("SELECT persoon FROM Persoon persoon WHERE persoon.naam = :naam",
                Persoon.class);
        typedQuery.setParameter ("naam", naam);

        List<Persoon> personen = typedQuery.getResultList();

        if (personen.isEmpty ()) {
            return null;
        }
        Persoon persoon = personen.get (0);
        System.out.println(persoon);

        em.clear();
        emf.getCache().evictAll();
        return persoon;
    }
}
