package command.language.editor;

import command.Command;
import command.qualifiers.LanguageEditorGetAlphabetCommandQualifier;
import entity.Culture;
import entity.Symbol;
import redirect.Response;
import resource.PagesManager;
import service.CultureEJB;
import utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LanguageEditorGetAlphabetCommandQualifier
@Transactional
public class LanguageEditorGetAlphabetCommand implements Command {

    @Inject
    CultureEJB cultureEJB;

    public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Long cultureId = Long.parseLong(httpServletRequest.getParameter("cultureId"));
        Culture culture = new Culture();
        culture.setId(cultureId);
        Culture foundCulture = cultureEJB.findCulture(culture);
        List<Symbol> alphabet = foundCulture.getSymbols();
        httpServletResponse.setContentType("text/plain");
        PrintWriter out = httpServletResponse.getWriter();
        String page = PagesManager.getProperty("page.languageEditorDetails");
        Map<String, String> attributes = new HashMap<>();
        attributes.put("alphabet", CommonUtils.convertListOfObjectsToJson(alphabet));
        Response response = new Response(page, attributes);
        String jsonResponse = CommonUtils.convertObjectToJson(response);
        out.print(jsonResponse);
        return "not redirecting";
    }
}
