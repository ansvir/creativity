package command.auth;
import command.Command;
import command.qualifiers.SigninCommandQualifier;
import entity.User;
import resource.PagesManager;
import service.UserEJB;

import javax.inject.Inject;
import javax.inject.Named;
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
        User signinUser = new User(email, password, "someUsername");
        User foundUser = userEJB.findByEmail(signinUser);
        if (foundUser != null) {
            request.getSession().setAttribute("user", foundUser);
            System.out.println(request.getSession().getAttribute("user"));
            request.setAttribute("passedAuth", true);
            return PagesManager.getProperty("page.home");
        } else {
            request.setAttribute("passedAuth", false);
            return PagesManager.getProperty("page.signin");
        }
    }
}