package sampleapplication;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {

    public String mongoHost;

    public Configuration(String configPath) {
        File configFile = new File(configPath);

        if (!configFile.exists()) {
            System.out.println("No configuration file found.");
            return;
        }

        try (FileReader fr = new FileReader(configFile)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                StringBuilder data = new StringBuilder();
                while (br.ready()) {
                    data.append(br.readLine());
                }
                Gson gson = new Gson();
                this.mongoHost = gson.fromJson(data.toString(), Configuration.class).mongoHost;
            }
        } catch (IOException ignored) {
        }
    }

    public String getHost() {
        return this.mongoHost;
    }

}
