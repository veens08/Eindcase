package org.hoestschaamte.corona.services.impl;

import org.hoestschaamte.corona.services.DefaultDaoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class DefaultDaoServiceImpl<T> implements DefaultDaoService<T> {

    @PersistenceContext(unitName = "hoestschaamteCoronaApp")
    EntityManager em;

    final Class<T> typeParameterClass;

    public DefaultDaoServiceImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public void save(T object) {
        em.persist(object);
    }

    @Override
    public List<T> getAll() {
        final String query = "SELECT t FROM " + typeParameterClass.getSimpleName() + " t";
        final TypedQuery<T> typedQuery = em.createQuery(query, typeParameterClass);
        return typedQuery.getResultList();
    }

    /**
     * This method queries a list from the database
     * @param stringQuery
     * @return
     */
    List<T> haalLijstOpVanQuery(String stringQuery) {
        // Maak Query aan om te communiceren met de database
        final TypedQuery<T> query = em.createQuery(stringQuery, typeParameterClass);
        // Haal lijst van objecten terug
        List<T> objectList = query.getResultList();
        return objectList;
    }

    /**
     * This method queries a list from the database and returns a single Optional object as a result
     * @param stringQuery
     * @return
     */
    Optional<T> voerQueryUitEnGeefEnkeleResultaatTerug(String stringQuery) {
        // Haal lijst op van de database
        List<T> objectList = haalLijstOpVanQuery(stringQuery);
        // By using an optional, we can check if the object is not null
        return objectList.size() == 1 ? Optional.of(objectList.get(0)) : Optional.empty();
    }
}
