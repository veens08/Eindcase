package org.hoestschaamte.corona.services;

import java.util.List;

public interface DefaultDaoService<T> {

    /**
     * Deze methode persisteert het object in de database
     * @param object
     */
    T save(T object);

    /**
     * Deze methode haalt alle objecten op van de database
     * @return
     */
    List<T> getAll();
}
