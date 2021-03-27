package command;

import command.auth.LogoutCommand;
import command.auth.SigninCommand;
import command.language.editor.LanguageEditorGetCulturesCommand;
import command.language.editor.LanguageEditorGetLanguageDetailsCommand;
import command.name.generation.NameGenerationCommand;
import command.name.generation.NameGenerationSettingsCommand;
import command.qualifiers.*;
import command.redirect.EmptyCommand;

import javax.inject.Inject;

public class Commands {
    public enum CommandEnum {
        EMPTY_COMMAND,
        NAME_GENERATION,
        NAME_GENERATION_SETTINGS,
        SIGNIN,
        LOGOUT,
        LANGUAGE_EDITOR_GET_CULTURES,
        LANGUAGE_EDITOR_GET_DETAILS
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
    @Inject
    @LogoutCommandQualifier
    LogoutCommand logoutCommand;
    @Inject
    @LanguageEditorGetCulturesCommandQualifier
    LanguageEditorGetCulturesCommand languageEditorGetCulturesCommand;
    @Inject
    @LanguageEditorGetLanguageDetailsCommandQualifier
    LanguageEditorGetLanguageDetailsCommand languageEditorGetLanguageDetailsCommand;

    public CommandEnum getCommandEnum(String action) {
        return CommandEnum.valueOf(action.toUpperCase());
    }

    public Command getCommand(CommandEnum commandEnum) {
        switch (commandEnum) {
            case NAME_GENERATION: return nameGenerationCommand;
            case NAME_GENERATION_SETTINGS: return nameGenerationSettingsCommand;
            case SIGNIN: return signinCommand;
            case LOGOUT: return logoutCommand;
            case LANGUAGE_EDITOR_GET_CULTURES: return languageEditorGetCulturesCommand;
            case LANGUAGE_EDITOR_GET_DETAILS: return languageEditorGetLanguageDetailsCommand;
            default: return emptyCommand;
        }
    }
}
