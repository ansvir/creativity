package command.language.editor;

import command.Command;
import command.qualifiers.LanguageEditorGetCulturesCommandQualifier;
import entity.Culture;
import entity.Language;
import resource.PagesManager;
import service.LanguageEJB;
import utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@LanguageEditorGetCulturesCommandQualifier
@Transactional
public class LanguageEditorGetCulturesCommand implements Command {

    @Inject
    LanguageEJB languageEJB;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long languageId = Long.parseLong(request.getParameter("languageId"));
        Language language = new Language();
        language.setId(languageId);
        Language foundLanguage = languageEJB.findLanguage(language);
        HttpSession session = request.getSession();
        System.out.println(foundLanguage.getName()+" "+foundLanguage.getId());
        session.setAttribute("cultures", foundLanguage.getCultures());
        for (Culture culture : (List<Culture>) session.getAttribute("cultures")) {
            System.out.println(culture.getName()+" " +culture.getId());
        }
        session.setAttribute("culturesJsonArray", CommonUtils.convertListOfObjectsToJson(foundLanguage.getCultures()));
        session.setAttribute("description", foundLanguage.getDescription());
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String page = PagesManager.getProperty("page.languageEditorCultures");
        out.print(page);
        return "not redirecting";
    }
}
