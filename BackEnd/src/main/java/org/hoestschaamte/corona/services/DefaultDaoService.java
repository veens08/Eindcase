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
}
