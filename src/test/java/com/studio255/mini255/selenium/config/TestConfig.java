package com.studio255.mini255.selenium.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final String CONFIG_FILE = "config.properties";
    private static final String DEFAULT_BROWSER = "firefox";
    private static final String DEFAULT_BASE_URL = "https://www.255.com.mx/";
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    private final Properties properties;

    private TestConfig(Properties properties) {
        this.properties = properties;
    }

    public static TestConfig load() {
        Properties properties = new Properties();

        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load " + CONFIG_FILE, exception);
        }
        return new TestConfig(properties);
    }

    public String browser() {
        return value("browser", DEFAULT_BROWSER).toLowerCase();
    }

    public String baseUrl() {
        return value("baseUrl", DEFAULT_BASE_URL);
    }

    public int timeoutSeconds() {
        String value = value("timeoutSeconds", String.valueOf(DEFAULT_TIMEOUT_SECONDS));
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("timeoutSeconds must be a number: " + value, exception);
        }
    }

    private String value(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue.trim();
        }
        return properties.getProperty(key, defaultValue).trim();
    }
}
