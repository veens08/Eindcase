package org.hoestschaamte.corona.services;

import java.util.List;
import java.util.Optional;

public interface DefaultDaoService<T> {

    /**
     * Deze methode persisteert het object in de database
     * @param object
     */
    void save(T object);

    /**
     * Deze methode update het object in de database en geeft het vervolgens weer terug
     * @param object
     */
    T update(T object);

    /**
     * Deze methode haalt alle objecten op van de database
     * @return
     */
    List<T> getAll();

    /**
     * Deze methode haalt een object van de database met een specifieke id
     * @param id
     * @return
     */
    T getById(int id);

    /**
     * Deze methode verwijdert een object uit de database met een specifiek id
     * @param id
     */
    void deleteById(int id);

}
