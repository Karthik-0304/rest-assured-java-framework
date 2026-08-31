package com.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties props;

    public static String getPropertyFile(String key) {
        if (props == null) {
            loadProperties();
        }
        return props.getProperty(key);
    }

    private static void loadProperties() {
        String path = "src/test/resources/config.properties";
        props = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file at: " + path, e);
        }
    }
}