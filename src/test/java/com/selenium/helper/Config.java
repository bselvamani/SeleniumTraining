package com.selenium.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static Config instance = null;
    private static Properties prop = null;

    private Config() {
        prop = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        String filePath = Project.ROOT + "/src/test/resources/config/config.properties";
        try {
            prop.load(new FileInputStream(filePath));
            logger.info("Configuration file loaded successfully from: " + filePath);
        } catch (Exception e) {
            logger.error("Failed to load configuration file from: " + filePath, e);
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    // static method to create instance of Singleton class (thread-safe)
    public static synchronized Config getInstance() {
        if (instance == null)
            instance = new Config();
        return instance;
    }

    public String url() {
        String value = prop.getProperty("url");
        if (value == null || value.isEmpty()) {
            logger.error("Property 'url' not found in configuration");
            throw new IllegalArgumentException("Property 'url' not configured");
        }
        return value;
    }

    public String user() {
        String value = prop.getProperty("user");
        if (value == null || value.isEmpty()) {
            logger.error("Property 'user' not found in configuration");
            throw new IllegalArgumentException("Property 'user' not configured");
        }
        return value;
    }

    public String password() {
        String value = prop.getProperty("password");
        if (value == null || value.isEmpty()) {
            logger.error("Property 'password' not found in configuration");
            throw new IllegalArgumentException("Property 'password' not configured");
        }
        return value;
    }

}
