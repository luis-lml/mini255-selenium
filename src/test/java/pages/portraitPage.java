package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portraitPage {

    private static WebElement individualSession = null;
    private static WebElement familySession = null;
    private static WebElement personalizadoSession = null;
    private static WebElement buttonSeleccionar = null;
    private static WebElement calendarButton = null;
    private static WebElement nameTextField = null;

    public static WebElement individual_Card (WebDriver driver) {
        individualSession = driver.findElement(By.xpath("//h3[text()='Individual']"));
        return individualSession;
    }

    public static WebElement family_Card (WebDriver driver) {
        familySession =driver.findElement(By.xpath("//h3[text()='Familiar']"));
        return familySession;
    }

    public static WebElement personalizado_Card (WebDriver driver) {
        personalizadoSession = driver.findElement(By.xpath("//h3[text()='Personalizado']"));
        return personalizadoSession;
    }

    public static WebElement buttonSeleccionarYAgendar (WebDriver driver) {
        buttonSeleccionar = driver.findElement(By.xpath("//button[normalize-space(text())='SELECCIONAR Y AGENDAR']"));
        return buttonSeleccionar;
    }

    public static WebElement calendarButton (WebDriver driver) {
        calendarButton = driver.findElement(By.xpath("//input[@type='date']"));
        return calendarButton;
    }

    public static WebElement nameTextField (WebDriver driver) {
        nameTextField = driver.findElement(By.xpath("//input[@name='name']"));
        return nameTextField;

    }
}
