package command.nameGeneration;

import command.Command;
import logic.nameGeneration.NameGeneration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NameGenerationCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String generatedName = new NameGeneration().generateName();
        response.setContentType("text/plain");
        response.getWriter().write(generatedName);
        return "not redirecting";
    }
}
