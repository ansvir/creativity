package service;

import entity.Culture;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static entity.Culture.FIND_ALL;

@Stateless
public class CultureEJB {
    @Inject
    private EntityManager em;
    public List<Culture> findCultures() {
        TypedQuery<Culture> query = em.createNamedQuery(FIND_ALL, Culture.class);
        return query.getResultList();
    }

    public Culture findCulture(@NotNull Culture culture) {
        return em.find(Culture.class, culture.getId());
    }

    public
    @NotNull
    Culture createCulture(@NotNull Culture culture) {
        em.persist(culture);
        return culture;
    }

    public
    @NotNull
    Culture updateCulture(@NotNull Culture culture) {
        return em.merge(culture);
    }

    public void deleteCulture(@NotNull Culture culture) {
        em.remove(em.merge(culture));
    }
}
