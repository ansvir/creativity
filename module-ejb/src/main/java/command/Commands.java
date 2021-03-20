package command;

import command.auth.SigninCommand;
import command.nameGeneration.NameGenerationCommand;
import command.nameGeneration.NameGenerationSettingsCommand;
import command.qualifiers.EmptyCommandQualifier;
import command.qualifiers.NameGenerationCommandQualifier;
import command.qualifiers.NameGenerationSettingsCommandQualifier;
import command.qualifiers.SigninCommandQualifier;
import command.redirect.EmptyCommand;

import javax.inject.Inject;

public class Commands {
    public enum CommandEnum {
        EMPTY_COMMAND,
        NAME_GENERATION,
        NAME_GENERATION_SETTINGS,
        SIGNIN
    }

    @Inject
    @EmptyCommandQualifier
    EmptyCommand emptyCommand;
    @Inject
    @NameGenerationCommandQualifier
    NameGenerationCommand nameGenerationCommand;
    @Inject
    @NameGenerationSettingsCommandQualifier
    NameGenerationSettingsCommand nameGenerationSettingsCommand;
    @Inject
    @SigninCommandQualifier
    SigninCommand signinCommand;

    public CommandEnum getCommandEnum(String action) {
        return CommandEnum.valueOf(action.toUpperCase());
    }

    public Command getCommand(CommandEnum commandEnum) {
        switch (commandEnum) {
            case NAME_GENERATION: return nameGenerationCommand;
            case NAME_GENERATION_SETTINGS: return nameGenerationSettingsCommand;
            case SIGNIN: return signinCommand;
            default: return emptyCommand;
        }
    }
}
