package command.language.editor;

import command.Command;
import command.qualifiers.SaveSymbolCommandQualifier;
import entity.Culture;
import entity.Language;
import entity.Symbol;
import resource.PagesManager;
import service.CultureEJB;
import service.LanguageEJB;
import service.SymbolEJB;
import utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Enumeration;

@SaveSymbolCommandQualifier
@Transactional
public class SaveSymbolCommand implements Command {

    @Inject
    SymbolEJB symbolEJB;

    @Inject
    CultureEJB cultureEJB;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cultureId = request.getParameter("cultureId");
        String key = request.getParameter("key");
        String imgUrl = request.getParameter("imgUrl");
        byte[] figure = CommonUtils.decodeBase64ToByteArray(imgUrl);
        String transcription = request.getParameter("transcription");
        Symbol symbol = new Symbol(key, figure, transcription);
        symbolEJB.createSymbol(symbol);
        Culture culture = new Culture();
        culture.setId(Long.parseLong(cultureId));
        Culture foundCulture = cultureEJB.findCulture(culture);
        foundCulture.addSymbol(symbol);
        cultureEJB.updateCulture(foundCulture);
        return PagesManager.getProperty("page.languageEditorMain");
    }
}
