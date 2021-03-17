package command.redirect;

import command.Command;
import command.qualifiers.EmptyCommandQualifier;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EmptyCommandQualifier
public class EmptyCommand implements Command {

    private final static Logger log = Logger.getLogger(EmptyCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
