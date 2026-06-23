package POM.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {

        EdgeOptions options = new EdgeOptions();

        String headless = System.getProperty("headless", "false");

        if(headless.equalsIgnoreCase("true")){

            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(options);

        }else{

            System.setProperty(
                    "webdriver.edge.driver",
                    "D:\\Selenium Drivers\\msedgedriver.exe"   // your path
            );

            driver = new EdgeDriver(options);

            driver.manage().window().maximize();
        }

        return driver;
    }
}