package resource;

import java.util.ResourceBundle;

public class NameGenerationSettingsManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("generateNameSettings");
    private NameGenerationSettingsManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
