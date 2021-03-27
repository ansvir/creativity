package command.name.generation;

import command.Command;
import command.qualifiers.NameGenerationCommandQualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;

@NameGenerationCommandQualifier
@Transactional
public class NameGenerationCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return null;
    }
}
