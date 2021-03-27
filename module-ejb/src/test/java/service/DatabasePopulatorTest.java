package service;

import entity.Role;
import entity.User;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import utils.CommonUtils;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulatorTest {

    @Inject
    UserEJB userEJB;

    @Inject
    RoleEJB roleEJB;

    @Ignore
    @Test
    public void populateUserSchema() {
        User user = new User("svirepa.anton@gmail.com", "admin", "admin", null);
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

    @Test
    public void testASymbolFilePath() {
        try {
            byte[] aFigure = Files.readAllBytes(Paths.get("src/defaultSymbols/a.png"));
            for (byte value : aFigure) {
                System.out.print(value+" ");
            }
            System.out.println();
            byte[] aFigure2 = CommonUtils.fileToByteArray("src/defaultSymbols/a.png");
            for (byte value : aFigure2) {
                System.out.print(value+" ");
            }
            System.out.println(CommonUtils.isFileExists("src/defaultSymbols/a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
