package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("Username");
    By password = By.id("Password");
    By loginBtn = By.id("btnLogin");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void login(String user,String pass){

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();

    }

}
