package command.auth;
import command.Command;
import command.qualifiers.LogoutCommandQualifier;
import command.qualifiers.SigninCommandQualifier;
import entity.Culture;
import logic.name.generation.Letter;
import logic.name.generation.Name;
import resource.PagesManager;
import utils.CommonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@LogoutCommandQualifier
@Transactional
public class LogoutCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        session.setAttribute("passedAuth", null);
        session.setAttribute("cultures", null);
        session.setAttribute("culturesJsonArray", null);
        session.setAttribute("description", null);
        session.setAttribute("alphabet", null);
        List<Letter> letters = Letter.getDefaultLetterSettingsList();
        session.setAttribute("letterList", letters);
        session.setAttribute("letterListString", CommonUtils.convertListOfObjectsToJson(letters));
        session.setAttribute("nameLength", Name.getDefaultNameLength());
        session.setAttribute("generateLastName", Name.getDefaultGenerateLastName());
        return PagesManager.getProperty("page.signin");
    }
}