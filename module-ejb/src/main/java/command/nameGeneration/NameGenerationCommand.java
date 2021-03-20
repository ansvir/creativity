package command.nameGeneration;

import command.Command;
import command.qualifiers.NameGenerationCommandQualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@NameGenerationCommandQualifier
public class NameGenerationCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return null;
    }
}
