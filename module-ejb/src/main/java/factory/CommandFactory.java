package factory;

import command.Command;
import command.Commands;
import command.qualifiers.EmptyCommandQualifier;
import javax.inject.Inject;
import java.io.Serializable;

public class CommandFactory implements Serializable{

    @Inject
    @EmptyCommandQualifier
    private Command command;

//    @Inject
//    private CommandEnum commandEnum;

    @Inject
    Commands commands;

    public Command defineCommand(String action) throws IllegalArgumentException {
        if (action == null || action.isEmpty()) {
            return command;
        }
//        commandEnum = CommandEnum.valueOf(action.toUpperCase());
//        command = commandEnum.getCommand();

        Commands.CommandEnum commandEnum = commands.getCommandEnum(action);
        command = commands.getCommand(commandEnum);
        return command;
    }
}
