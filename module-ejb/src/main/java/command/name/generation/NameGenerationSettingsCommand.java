package command.name.generation;

import command.Command;
import command.qualifiers.NameGenerationSettingsCommandQualifier;
import logic.name.generation.Letter;
import logic.name.generation.Name;
import resource.PagesManager;
import utils.CommonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

@NameGenerationSettingsCommandQualifier
@Transactional
public class NameGenerationSettingsCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("restoreDefaultsValue").equals("true")) {
            List<Letter> letters = Letter.getDefaultLetterSettingsList();
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", CommonUtils.convertListOfObjectsToJson(letters));
            session.setAttribute("nameLength", Name.getDefaultNameLength());
            session.setAttribute("generateLastName", Name.getDefaultGenerateLastName());
            return PagesManager.getProperty("page.generateNameSettings");
        } else {
            System.out.println(Boolean.parseBoolean(request.getParameter("generateLastName")));
            List<Letter> letters = returnNewLetterList(request);
            session.setAttribute("letterList", letters);
            session.setAttribute("letterListString", CommonUtils.convertListOfObjectsToJson(letters));
            session.setAttribute("nameLength", Integer.parseInt(request.getParameter("nameLength")));
            session.setAttribute("generateLastName", Boolean.parseBoolean(request.getParameter("generateLastName")));
            return PagesManager.getProperty("page.generateName");
        }
    }

    private List<Letter> returnNewLetterList(HttpServletRequest request) {
        List<Letter> letters = (List<Letter>) request.getSession().getAttribute("letterList");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            for (Letter letter : letters) {
                if (paramName.startsWith("range-") && paramName.substring(paramName.length() - 1).equals(letter.getSymbol())) {
                    letter.setPriority(Short.parseShort(request.getParameter(paramName)));
                }
            }
        }
        return letters;
    }
}
