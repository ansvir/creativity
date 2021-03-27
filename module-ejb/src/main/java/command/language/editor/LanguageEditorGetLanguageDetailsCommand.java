package command.language.editor;

import command.Command;
import command.qualifiers.LanguageEditorGetLanguageDetailsCommandQualifier;
import entity.Culture;
import entity.Symbol;
import resource.PagesManager;
import service.CultureEJB;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@LanguageEditorGetLanguageDetailsCommandQualifier
@Transactional
public class LanguageEditorGetLanguageDetailsCommand implements Command {

    @Inject
    CultureEJB cultureEJB;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long cultureId = Long.parseLong(request.getParameter("cultureId"));
        Culture culture = new Culture();
        culture.setId(cultureId);
        Culture foundCulture = cultureEJB.findCulture(culture);
        System.out.println(foundCulture.getId());
        List<Symbol> alphabet = foundCulture.getSymbols();
        request.getSession().setAttribute("alphabet", alphabet);
        request.setAttribute("alphabet", alphabet);
        for (Symbol symbol : (List<Symbol>) request.getSession().getAttribute("alphabet")) {
            System.out.println(symbol.getId());
        }
        for (Symbol symbol : (List<Symbol>) request.getAttribute("alphabet")) {
            System.out.println(symbol.getId());
        }
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String page = PagesManager.getProperty("page.languageEditorDetails");
        out.print(page);
        return "not redirecting";
    }
}
