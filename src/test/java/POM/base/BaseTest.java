package POM.base;

import POM.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import POM.utils.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setup(){

        driver = DriverFactory.initDriver();
        driver.get("https://account.worldstrides.com/Login");

    }

    }

