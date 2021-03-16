package service;

import entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

import static entity.User.FIND_ALL;

@Stateless
public class UserEJB implements UserEJBRemote{
    @Inject
    private EntityManager em;
    public List<User> findUsers() {
        TypedQuery<User> query = em.createNamedQuery(FIND_ALL, User.class);
        return query.getResultList();
    }

    public User findUser(@NotNull User user) {
        return em.find(User.class, user);
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
