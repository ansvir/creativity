package command.auth;
import command.Command;
import command.qualifiers.SigninCommandQualifier;
import entity.User;
import resource.PagesManager;
import service.UserEJB;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SigninCommandQualifier
public class SigninCommand implements Command {

    @Inject
    private UserEJB userEJB;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User signinUser = new User(email, password);
        User foundUser = userEJB.findUser(signinUser);
        if (foundUser != null) {
            request.setAttribute("passedAuth", true);
            return PagesManager.getProperty("page.nameGeneration");
        } else {
            request.setAttribute("passedAuth", false);
            return PagesManager.getProperty("page.signin");
        }
    }
}