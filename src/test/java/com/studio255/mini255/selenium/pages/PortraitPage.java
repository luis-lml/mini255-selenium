package com.studio255.mini255.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PortraitPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Portrait Cards
    private final By individualCard = By.xpath("//h3[normalize-space()='Individual']");
    private final By familiarCard = By.xpath("//h3[normalize-space()='Familiar']");

    //Gallery Buttons
    private final By nextButton = By.id("[data-testid=\"portrait-carousel-next\"]");
    private final By prevButton = By.id("[data-testid=\"portrait-carousel-prev\"]");


    private final By scheduleButton = By.xpath("//button[normalize-space()='SELECCIONAR Y AGENDAR']");
    private final By calendarInput = By.cssSelector("input[type='date']");
    private final By nameInput = By.cssSelector("input[name='name']");

    public PortraitPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public PortraitPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public boolean isIndividualPortraitVisible() {
        return visibleElement(individualCard).isDisplayed();
    }

    public PortraitPage selectIndividualPortrait() {
        click(visibleElement(individualCard));
        return this;
    }

    public boolean isFamiliarPortraitVisible() {
        return visibleElement(familiarCard).isDisplayed();
    }

    public PortraitPage selectFamiliarPortrait() {
        click(visibleElement(familiarCard));
        return this;
    }

    public boolean isScheduleButtonVisible() {
        return visibleElement(scheduleButton).isDisplayed();
    }

    public PortraitPage goToNextPortraitOption() {
        click(wait.until(ExpectedConditions.elementToBeClickable(nextButton)));
        return this;
    }

    public PortraitPage startScheduling() {
        click(visibleElement(scheduleButton));
        return this;
    }

    public PortraitPage enterName(String name) {
        WebElement field = visibleElement(nameInput);
        field.clear();
        field.sendKeys(name);
        return this;
    }

    public boolean isCalendarVisible() {
        return visibleElement(calendarInput).isDisplayed();
    }

    private WebElement visibleElement(By locator) {
        return wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);
            return elements.stream()
                    .filter(WebElement::isDisplayed)
                    .findFirst()
                    .orElse(null);
        });
    }

    private void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
