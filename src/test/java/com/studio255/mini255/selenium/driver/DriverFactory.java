package com.studio255.mini255.selenium.driver;

import com.studio255.mini255.selenium.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver(TestConfig config) {
        WebDriver driver = switch (config.browser()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + config.browser());
        };

        driver.manage().window().maximize();
        return driver;
    }
}
