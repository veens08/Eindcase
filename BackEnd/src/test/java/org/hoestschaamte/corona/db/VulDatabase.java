package org.hoestschaamte.corona.db;

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
        ArrayList<Reservering> reserveringen = new ArrayList<Reservering> ();

        Tafel t1 = slaTafelOpEnHaalUitDatabase (10,4);
        Tafel t2 = slaTafelOpEnHaalUitDatabase (11,4);
        Tafel t3 = slaTafelOpEnHaalUitDatabase (12,4);

        Persoon evan = slaPersoonOpEnHaalUitDatabase("Evan", "06-12345678", "evan@gmail.com");
        Persoon joshua = slaPersoonOpEnHaalUitDatabase("Joshua", "06-11223344", "joshua@gmail.com");
        Persoon sjoerd = slaPersoonOpEnHaalUitDatabase("Sjoerd", "06-87654321", "sjoerd@gmail.com");

        Reservering r1 = ReserveringBuilder
                .createReservering(evan, t1)
                .metAantalPersonen(3)
                .metDatum(LocalDate.of(2020, 12, 25))
                .metTijdslot(1)
                .build();

        Reservering r2 = ReserveringBuilder
                .createReservering(joshua,t2)
                .metAantalPersonen(2)
                .metDatum(LocalDate.of(2020, 12, 25))
                .metTijdslot(1)
                .build();

        Reservering r3 = ReserveringBuilder
                .createReservering(sjoerd, t1)
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
        return haalPersoonOpUitDatabase (naam);
    }

    private Tafel slaTafelOpEnHaalUitDatabase(int tafelNummer, int aantalPersonen) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("test-corona-app-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Tafel tafel = new Tafel (tafelNummer, aantalPersonen);
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

        Bezoek b1 = BezoekBuilder
                .createBezoek(gastenBezoek1)
                .metDatum(LocalDate.of(2020,12,15))
                .metTijdslot(1)
                .build();

        ArrayList<Persoon> gastenBezoek2 =new ArrayList<Persoon> ();
        gastenBezoek2.add(sjoerd);
        gastenBezoek2.add(evan);

        Bezoek b2 = BezoekBuilder
                .createBezoek(gastenBezoek2)
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
