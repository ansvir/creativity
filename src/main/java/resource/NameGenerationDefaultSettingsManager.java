package resource;

import java.util.ResourceBundle;
import java.util.Set;

public class NameGenerationDefaultSettingsManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("generateNameDefaultSettings");
    private NameGenerationDefaultSettingsManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
    public static Set<String> getProperties() {return resourceBundle.keySet();}}
