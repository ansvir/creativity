package command;

import command.nameGeneration.NameGenerationCommand;

public enum CommandEnum {

    NAME_GENERATION {
        {
            this.command = new NameGenerationCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}
