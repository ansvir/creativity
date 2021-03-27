package command.redirect;

import command.Command;
import command.qualifiers.EmptyCommandQualifier;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.Serializable;

@EmptyCommandQualifier
@Transactional
public class EmptyCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
