package command.nameGeneration;

import command.Command;
import logic.nameGeneration.Letter;
import logic.nameGeneration.Name;
import org.apache.log4j.Logger;
import resource.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

public class NameGenerationSettingsCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("restoreDefaultsValue").equals("true")) {
            List<Letter> letters = Letter.getDefaultLetterSettingsList();
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
            session.setAttribute("nameLength", Name.getDefaultNameLength());
            return PagesManager.getProperty("page.generateNameSettings");
        } else {
            List<Letter> letters = (List<Letter>) session.getAttribute("letterList");
            Enumeration<String> parameterNames = request.getParameterNames();
            for (Letter letter : letters) {
                while (parameterNames.hasMoreElements()) {
                    String paramName = parameterNames.nextElement();
                    if (paramName.substring(paramName.length() - 1).equals(letter.getSymbol())) {
                        letter.setPriority(Short.parseShort(request.getParameter(paramName)));
                        break;
                    }
                }
            }
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
            session.setAttribute("nameLength", Integer.parseInt(request.getParameter("nameLength")));
            return PagesManager.getProperty("page.generateName");
        }
    }
}
