package sampleapplication;

import java.io.File;
import java.io.IOException;

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
            try {
                configFile.mkdirs();
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
