package com.studio255.mini255.selenium.tests;

import com.studio255.mini255.selenium.config.TestConfig;
import com.studio255.mini255.selenium.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    protected TestConfig config;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setUp() {
        config = TestConfig.load();
        driver = DriverFactory.createDriver(config);
        wait = new WebDriverWait(driver, Duration.ofSeconds(config.timeoutSeconds()));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
