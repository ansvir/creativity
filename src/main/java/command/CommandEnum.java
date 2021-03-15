package command;

import command.nameGeneration.NameGenerationCommand;
import command.nameGeneration.NameGenerationSettingsCommand;

public enum CommandEnum {

    NAME_GENERATION {
        {
            this.command = new NameGenerationCommand();
        }
    },
    NAME_GENERATION_SETTINGS {
        {
            this.command = new NameGenerationSettingsCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}
