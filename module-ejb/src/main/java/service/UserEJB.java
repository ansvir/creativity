package service;

import entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static entity.User.*;

@Stateless
public class UserEJB {
    @Inject
    private EntityManager em;
    public List<User> findUsers() {
        TypedQuery<User> query = em.createNamedQuery(FIND_ALL, User.class);
        return query.getResultList();
    }

    public User findUser(@NotNull User user) {
        return em.find(User.class, user.getId());
    }

    public User findByEmail(@NotNull User user) {
        String email = user.getEmail();
        TypedQuery<User> query = em.createNamedQuery(FIND_BY_EMAIL, User.class);
        query.setParameter("email", email);
        List<User> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return query.getSingleResult();
        } else {
            return null;
        }
    }

    public User findByName(@NotNull User user) {
        String name = user.getName();
        TypedQuery<User> query = em.createNamedQuery(FIND_BY_NAME, User.class);
        query.setParameter("name", name);
        List<User> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return query.getSingleResult();
        } else {
            return null;
        }
    }

    public
    @NotNull
    User createUser(@NotNull User user) {
        em.persist(user);
        return user;
    }

    public
    @NotNull
    User updateUser(@NotNull User user) {
        return em.merge(user);
    }

    public void deleteUser(@NotNull User user) {
        em.remove(em.merge(user));
    }
}
