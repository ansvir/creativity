package service;

import entity.Role;
import entity.User;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;

public class DatabasePopulator {

    @Inject
    UserEJB userEJB;

    @Inject
    RoleEJB roleEJB;

    @Ignore
    @Test
    public void populateUserSchema() {
        User user = new User("svirepa.anton@gmail.com", "admin");
        userEJB.createUser(user);
    }

    @Ignore
    @Test
    public void populateRoleSchema() {
        Role admin = new Role("admin");
        Role user = new Role("user");
        roleEJB.createRole(admin);
        roleEJB.createRole(user);
    }
}
