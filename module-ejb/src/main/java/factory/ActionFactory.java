package factory;

import command.Command;
import command.CommandEnum;
import command.qualifiers.EmptyCommandQualifier;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class ActionFactory {

    @Inject
    @EmptyCommandQualifier
    private Command command;

    @Inject
    private CommandEnum commandEnum;

    public Command defineCommand(String action) throws IllegalArgumentException {
        if (action == null || action.isEmpty()) {
            return command;
        }
        commandEnum = CommandEnum.valueOf(action.toUpperCase());
        command = commandEnum.getCommand();
        System.out.println(commandEnum.toString());
        System.out.println(command.toString());

        return command;
    }

    @Produces
    public static CommandEnum getEmptyCommandEnum()
    {
        return CommandEnum.EMPTY_COMMAND;
    }
}
