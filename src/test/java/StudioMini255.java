import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import pages.portraitPage;

public class StudioMini255  {

    public static String browser;
    static WebDriver driver;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
//        setBrowser();
        PropertiesFile.readPropertiesFile();
        setBrowserConfig();
        portraitTest();
    }

    public static void setBrowser(){
        browser = "Firefox";
    }

    public static void setBrowserConfig(){
        driver = new FirefoxDriver();
    }

    public static void portraitTest() throws InterruptedException {
        driver.get("https://www.255.com.mx/");
        portraitPage.individual_Card(driver).click();
        Thread.sleep(3000);
        portraitPage.buttonSeleccionarYAgendar(driver).click();
        Thread.sleep(3000);
        portraitPage.nameTextField(driver).sendKeys("Test Name");
        Thread.sleep(3000);
        portraitPage.calendarButton(driver).click();
        Thread.sleep(3000);

        driver.close();

//        driver.get("https://www.255.com.mx/");
//        WebElement retratoIndividual = driver.findElement(By.xpath("//h3[text()='Individual']"));
//        retratoIndividual.click();
//        Thread.sleep(3000);
//        WebElement buttonSeleccionar = driver.findElement(By.xpath("//button[normalize-space(text())='SELECCIONAR Y AGENDAR']"));
//        buttonSeleccionar.click();
//        Thread.sleep(3000);
//        driver.quit();
    }
}