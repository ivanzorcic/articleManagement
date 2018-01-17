package de.zorcic;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Producers {

    @Produces
    @PersistenceContext
    EntityManager em;

}
