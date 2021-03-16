package service;

import entity.User;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.postgresql.Driver",
        name = "java:global/jdbc/creativityDS",
        user = "postgres",
        password = "zaharova6416!",
        databaseName = "creativity",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    private UserEJB userEJB;

    private User admin;
    private User someUser;

    @PostConstruct
    private void populateDB() {
        admin = new User("svirepa.anton@gmail.com", "admin");
        someUser = new User("user@gmail.com", "user");

        userEJB.createUser(admin);
        userEJB.createUser(someUser);
    }
}