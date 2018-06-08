package com.n11.challenge.config;

import com.google.common.io.Resources;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public final class ConfigReader {

    private static ConfigReader configReader;

    private JSONObject configJson;

    private ConfigReader() {
        try {
            String configFileContent = Resources.toString(Resources.getResource("config.json"), StandardCharsets.UTF_8);
            configJson = new JSONObject(configFileContent);
        } catch (Exception e) {
            System.out.println("Please provide valid config file: ");
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getPlatform() {
        return configJson.getString("platform");
    }

    public String getHost() {
        return configJson.getString("host");
    }

    public String getUserName() {
        return configJson.getString("user");
    }

    public String getPassword() {
        return configJson.getString("password");
    }

    public String getScreenshotsFolder() {
        return configJson.getString("screenshotsFolder");
    }

    public String getFacebookUser() {
        return configJson.getString("facebookUser");
    }

    public String getFacebookPassword() {
        return configJson.getString("facebookPassword");
    }
}
