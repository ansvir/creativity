package factory;

import command.Command;
import command.CommandEnum;
import command.redirect.EmptyCommand;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public Command defineCommand(HttpServletRequest request) {
        Command current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("msg", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
