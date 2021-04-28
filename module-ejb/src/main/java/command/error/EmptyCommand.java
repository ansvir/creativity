package command.error;

import command.Command;
import command.qualifiers.EmptyCommandQualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@EmptyCommandQualifier
@Transactional
public class EmptyCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
