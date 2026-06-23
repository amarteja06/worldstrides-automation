package POM.Pages;

import POM.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;
    WaitUtils wait;

    public SignupPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By signup = By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a");
    By programReg = By.id("registration-program");
    By continueBtn = By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button");

    public void clickSignup(){
        wait.waitForClickable(signup).click();

        //  wait for next page load
        wait.waitForVisibility(programReg);
    }

    public void enterProgramCode(String code){
        wait.waitForVisibility(programReg).sendKeys(code);
    }

    public void continueRegistration(){
        wait.waitForClickable(continueBtn).click();

        // IMPORTANT FIX: wait for traveller page
        wait.waitForVisibility(By.id("tavellingAs1"));
    }
}