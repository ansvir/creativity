package command.nameGeneration;

import command.Command;
import command.qualifiers.NameGenerationSettingsCommandQualifier;
import logic.name.generation.Letter;
import logic.name.generation.Name;
import resource.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@NameGenerationSettingsCommandQualifier
public class NameGenerationSettingsCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("restoreDefaultsValue").equals("true")) {
            List<Letter> letters = Letter.getDefaultLetterSettingsList();
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
            session.setAttribute("nameLength", Name.getDefaultNameLength());
            session.setAttribute("generateLastName", Name.getDefaultGenerateLastName());
            return PagesManager.getProperty("page.generateNameSettings");
        } else {
            List<Letter> letters = returnNewLetterList(request);
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", Letter.convertLetterListToArrayOfJsonObjectsString(letters));
            session.setAttribute("nameLength", Integer.parseInt(request.getParameter("nameLength")));
            session.setAttribute("generateLastName", Boolean.parseBoolean(request.getParameter("generateLastName")));
            return PagesManager.getProperty("page.generateName");
        }
    }

    private List<Letter> returnNewLetterList(HttpServletRequest request) {
        List<Letter> letters = (List<Letter>) request.getSession().getAttribute("letterList");
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
        return letters;
    }
}
