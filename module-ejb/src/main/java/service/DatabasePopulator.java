package service;

import entity.Role;
import entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;

@Singleton
@Startup
//@DataSourceDefinition(
//        className = "org.postgresql.Driver",
//        name = "java:global/jdbc/creativityDS",
//        user = "postgres",
//        password = "zaharova6416!",
//        databaseName = "creativity",
//        properties = {"connectionAttributes=;create=true"}
//)
public class DatabasePopulator {

    @Inject
    private UserEJB userEJB;

    @Inject
    private RoleEJB roleEJB;

    @PostConstruct
    private void populateDB() {
        User adminUser = new User("svirepa.anton@gmail.com", "admin", "admin");
        User someUser = new User("user@gmail.com", "user", "user");

        if (userEJB.findByEmail(adminUser) == null) {
            userEJB.createUser(adminUser);
        }
        if (userEJB.findByEmail(someUser) == null) {
            userEJB.createUser(someUser);
        }

        Role adminRole = new Role("admin");
        Role userRole = new Role("user");

        if (roleEJB.findByName(adminRole) == null) {
            roleEJB.createRole(adminRole);
        }
        if (roleEJB.findByName(userRole) == null) {
            roleEJB.createRole(userRole);
        }
    }
}
