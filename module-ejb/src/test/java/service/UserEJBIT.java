package service;

import entity.User;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserEJBIT {

    @Test
    public void shouldCreateAUser() throws Exception {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();

            // Check JNDI dependencies
            assertNotNull(ctx.lookup("java:jboss/datasources/creativityDS"));
            assertNotNull(ctx.lookup("java:global/classes/UserEJB!service.UserEJBRemote"));
            assertNotNull(ctx.lookup("java:global/classes/UserEJB!service.UserEJB"));

            // Looks up the EJB
            UserEJB userEJB = (UserEJB) ctx.lookup("java:global/classes/UserEJB!service.UserEJB");

            // Finds all the users and makes sure there are two (inserted by the DBPopulator Singleton)
            assertEquals(2, userEJB.findUsers().size());

            // Creates an instance of user
            User user = new User("user1@gmail.com","user1", "user1", null);

            // Persists the user to the database
            user = userEJB.createUser(user);
            assertNotNull("ID should not be null", user.getEmail());

            // Finds all the users and makes sure there is an extra one
            assertEquals(3, userEJB.findUsers().size());

            // Removes the created user
            userEJB.deleteUser(user);

            // Finds all the users and makes sure there is one less
            assertEquals(2, userEJB.findUsers().size());
        }
    }
}
