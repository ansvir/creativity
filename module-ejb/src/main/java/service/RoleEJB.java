package service;

import entity.Role;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import static entity.Role.FIND_ALL;
import static entity.Role.FIND_BY_NAME;

@Stateless
public class RoleEJB {
    @Inject
    private EntityManager em;
    public List<Role> findRoles() {
        TypedQuery<Role> query = em.createNamedQuery(FIND_ALL, Role.class);
        return query.getResultList();
    }

    public Role findRole(@NotNull Role role) {
        return em.find(Role.class, role.getId());
    }

    public Role findByName(@NotNull Role role) {
        String name = role.getName();
        TypedQuery<Role> query = em.createNamedQuery(FIND_BY_NAME, Role.class);
        query.setParameter("name", name);
        List<Role> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return query.getSingleResult();
        } else {
            return null;
        }
    }

    public
    @NotNull
    Role createRole(@NotNull Role role) {
        em.persist(role);
        return role;
    }

    public
    @NotNull
    Role updateRole(@NotNull Role role) {
        return em.merge(role);
    }

    public void deleteRole(@NotNull Role role) {
        em.remove(em.merge(role));
    }
}
