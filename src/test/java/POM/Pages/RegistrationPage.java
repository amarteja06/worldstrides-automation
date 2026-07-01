package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver){

        this.driver = driver;

    }

    By submitBtn = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]");

    public void submitRegistration(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]")).click();

    }

}
