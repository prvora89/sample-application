package sampleapplication;

import java.io.File;

public class Configuration {

    private class ConfigContainer {
        public String mongoHost;

        public ConfigContainer(String mongoHost) {
            this.mongoHost = mongoHost;
        }
    }

    public Configuration(String configPath) {
        File configFile = new File(configPath);

        if (!configFile.exists()) {
            System.out.println("No configuration file found.");
        }

    }

}
