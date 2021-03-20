package service;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "creativity")
    private EntityManager em;
}
