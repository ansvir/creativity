package command.auth;
import command.Command;
import command.qualifiers.SigninCommandQualifier;
import entity.Culture;
import entity.User;
import resource.PagesManager;
import service.UserEJB;
import utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SigninCommandQualifier
@Transactional
public class SigninCommand implements Command {

    @Inject
    private UserEJB userEJB;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User signinUser = new User(email, password, "someUsername", null);
        User foundUser = userEJB.findByEmail(signinUser);
        if (foundUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", foundUser);
            session.setAttribute("languages", foundUser.getLanguages());
            List<Culture> cultures = new ArrayList<>();
            session.setAttribute("culturesJsonArray", cultures);
            session.setAttribute("languagesJsonArray", CommonUtils.convertListOfObjectsToJson(foundUser.getLanguages()));
            request.setAttribute("passedAuth", true);
            return PagesManager.getProperty("page.home");
        } else {
            request.setAttribute("passedAuth", false);
            return PagesManager.getProperty("page.signin");
        }
    }
}