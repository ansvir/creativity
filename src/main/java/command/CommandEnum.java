package command;

import command.auth.SigninCommand;
import command.nameGeneration.NameGenerationCommand;
import command.nameGeneration.NameGenerationSettingsCommand;
import command.redirect.EmptyCommand;

import javax.inject.Inject;

public enum CommandEnum {

    EMPTY_COMMAND {
        {
            this.command = emptyCommand;
        }
    },
    NAME_GENERATION {
        {
            this.command = nameGenerationCommand;
        }
    },
    NAME_GENERATION_SETTINGS {
        {
            this.command = nameGenerationSettingsCommand;
        }
    },
    SIGNIN {
        {
            this.command = signinCommand;
        }
    };

    Command command;

    @Inject
    EmptyCommand emptyCommand;
    @Inject
    NameGenerationCommand nameGenerationCommand;
    @Inject
    NameGenerationSettingsCommand nameGenerationSettingsCommand;
    @Inject
    SigninCommand signinCommand;

    public Command getCommand() {
        return command;
    }
}
