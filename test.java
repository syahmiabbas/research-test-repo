public class ConfigurationManager {
    // Private static instance variable
    private static ConfigurationManager instance;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {}

    // Public static method to provide a single access point
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfiguration() {
        System.out.println("Configuration loaded");
    }
}
