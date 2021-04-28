package command.name.generation;

import command.Command;
import command.qualifiers.NameGenerationCommandQualifier;
import logic.name.generation.Letter;
import logic.name.generation.NameGenerationLogic;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@NameGenerationCommandQualifier
@Transactional
public class NameGenerationCommand implements Command {

    @Inject
    NameGenerationLogic nameGenerationLogic;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Letter> letterList = (List<Letter>) session.getAttribute("letterList");
        int nameLength = (Integer) session.getAttribute("nameLength");
        boolean generateLastName = (Boolean) session.getAttribute("generateLastName");
        System.out.println(generateLastName);
        nameGenerationLogic.setLetters(letterList);
        nameGenerationLogic.setNameLength(nameLength);
        nameGenerationLogic.setGenerateLastName(generateLastName);
        System.out.println(nameGenerationLogic.getGenerateLastName());
        String generatedName = nameGenerationLogic.generateName();
        response.setContentType("text/plain");
        response.getWriter().write(generatedName);
        return "not redirecting";
    }
}
