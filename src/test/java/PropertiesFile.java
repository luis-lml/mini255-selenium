import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties properties = new Properties();

    public static void main(String[] args) throws FileNotFoundException {
        readPropertiesFile();
        writeProperties();
        readPropertiesFile();
    }

    public static void readPropertiesFile() throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/255_Studio/Documents/255_Studio/mini255-selenium/config.properties");
            properties.load(input);
            StudioMini255.browser = properties.getProperty("browser");
            System.out.println(StudioMini255.browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeProperties()  {
        try {
            OutputStream output = new FileOutputStream("/Users/255_Studio/Documents/255_Studio/mini255-selenium/config.properties");
            properties.setProperty("result", "Pass");
            properties.store(output, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

