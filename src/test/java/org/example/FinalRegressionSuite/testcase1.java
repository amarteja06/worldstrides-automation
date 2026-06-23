package org.example.FinalRegressionSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

import static io.opentelemetry.api.internal.ApiUsageLogger.log;

public class testcase1 {
    
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.edge.driver","D:\\Selenium Drivers\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://account.worldstrides.com/Login");
    }

    private void logResult(String testName, String result) {

        try {

            File folder = new File("results");

            if (!folder.exists())
                folder.mkdirs();

            FileWriter fw = new FileWriter("results/test-results.txt", true);

            fw.write(java.time.LocalDateTime.now() + " | " + testName + " | " + result + "\n");

            fw.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Test(priority = 1)
    public void verifyLogoPresence() {

        try {

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img")
            ));

            Assert.assertTrue(element.isDisplayed());

            System.out.println("World Strides Logo is present");

            logResult("verifyLogoPresence","SUCCESS");

        }

        catch (Exception e){

            logResult("verifyLogoPresence","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 2)
    public void testSignUpFlow(){

        try{

            WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a")
            ));

            signup.click();

            WebElement ProgramRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("registration-program")
            ));

            ProgramRegistration.sendKeys("110765");

            WebElement Continuereg = driver.findElement(By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button"));

            Continuereg.click();

            Thread.sleep(4000);

            logResult("testSignUpFlow","SUCCESS");

        }

        catch(Exception e){

            logResult("testSignUpFlow","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 3)
    public void selectParticipantDetails(){

        try{

            WebElement Select1 = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));

            Select1.click();

            WebElement grade11 = driver.findElement(By.xpath("//*[@id=\"currentGrade1\"]/option[3]"));

            grade11.click();

            WebElement Studentinterest = driver.findElement(By.xpath("//*[@id=\"studentInterest1\"]/option[4]"));

            Studentinterest.click();

            WebElement CountrySelection = driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]"));

            CountrySelection.click();

            logResult("selectParticipantDetails","SUCCESS");

        }

        catch(Exception e){

            logResult("selectParticipantDetails","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 4)
    public void enterStudentPersonalDetails(){

        try{

            driver.findElement(By.id("firstnameTraveller1")).sendKeys("March20th2026");

            driver.findElement(By.id("lastNameTraveller1")).sendKeys("Amar");

            driver.findElement(By.id("emailTraveler1")).sendKeys("Selenium@gmail23.com");

            driver.findElement(By.id("retypeEmailTraveler1")).sendKeys("Selenium@gmail23.com");

            driver.findElement(By.xpath("//*[@id=\"genderTraveler1\"]/option[2]")).click();

            driver.findElement(By.id("bdayTraveler1")).sendKeys("01092010");

            logResult("enterStudentPersonalDetails","SUCCESS");

        }

        catch(Exception e){

            logResult("enterStudentPersonalDetails","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 5)
    public void selectGuardianDetails(){

        try{

            driver.findElement(By.xpath("//*[@id=\"relationshipGuardian\"]/option[3]")).click();

            driver.findElement(By.xpath("//*[@id=\"countryGuardian\"]/option[2]")).click();

            driver.findElement(By.id("firstnameGaurdian")).sendKeys("Selenium");

            driver.findElement(By.id("lastnameGaurdian")).sendKeys("Test");

            driver.findElement(By.id("addressGaurdian")).sendKeys("1-142");

            driver.findElement(By.id("cityGaurdian")).sendKeys("Denver");

            driver.findElement(By.xpath("//*[@id=\"stateGuardian\"]/option[36]")).click();

            driver.findElement(By.id("zipGaurdian")).sendKeys("80010");

            driver.findElement(By.id("emailGaurdian")).sendKeys("Test@Emailtest.com");

            driver.findElement(By.id("retypeEmailGaurdian")).sendKeys("Test@Emailtest.com");

            driver.findElement(By.xpath("//*[@id=\"1countryCodeGuardian\"]/option[2]")).click();

            driver.findElement(By.id("1phoneGaurdian")).sendKeys("8908908909");

            logResult("selectGuardianDetails","SUCCESS");

        }

        catch(Exception e){

            logResult("selectGuardianDetails","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 6)
    public void AccountDetails(){

        try{

            driver.findElement(By.id("usernameGaurdian")).sendKeys("March20th2026Script2");

            driver.findElement(By.id("passwordGaurdian")).sendKeys("Amar@0601");

            driver.findElement(By.id("retypePasswordGaurdian")).sendKeys("Amar@0601");

            driver.findElement(By.xpath("//*[@id=\"parent-acc-form\"]/div[2]/div[2]/label")).click();

            driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button")).click();

            Thread.sleep(5000);

            logResult("AccountDetails","SUCCESS");

        }

        catch(Exception e){

            logResult("AccountDetails","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 7)
    public void Agreement() throws InterruptedException {
        try {
            By genericSaveAndContinue = By.xpath(
                    "//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'save & continue')]"
            );

            while (true) {
                List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='content']//label/span"));
                List<WebElement> visibleCheckboxes = checkboxes.stream().filter(WebElement::isDisplayed).toList();
                if (visibleCheckboxes.isEmpty()) break;

                for (WebElement cb : visibleCheckboxes) {
                    wait.until(ExpectedConditions.elementToBeClickable(cb)).click();
                }

                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(genericSaveAndContinue));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                saveBtn.click();
                Thread.sleep(500);
            }
            log("Agreement pages completed successfully");
        } catch (Exception e) {
            log("Error in Agreement: " + e.getMessage());
        }
    }


    @Test(priority = 8)
    public void Payments(){

        try{

            WebElement payInFull = wait.until(ExpectedConditions.elementToBeClickable(By.id("lblPayInFull")));

            payInFull.click();

            WebElement saveAndContinue2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            ));

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",saveAndContinue2);

            saveAndContinue2.click();

            WebElement CheckingAcc = wait.until(ExpectedConditions.elementToBeClickable(By.id("listElectronicCheck")));

            CheckingAcc.click();

            driver.findElement(By.id("card-name")).sendKeys("Wells Fargo");

            driver.findElement(By.id("card-routing")).sendKeys("051400549");

            driver.findElement(By.id("card-account")).sendKeys("123456");

            driver.findElement(By.id("card-retype-acount")).sendKeys("123456");

            driver.findElement(By.id("card-holders-first-name")).sendKeys("Test");

            driver.findElement(By.id("card-holders-last-name")).sendKeys("Amar");

            WebElement SaveandContinue = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            ));

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",SaveandContinue);

            SaveandContinue.click();

            logResult("Payments","SUCCESS");

        }

        catch(Exception e){

            logResult("Payments","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }

    @Test(priority = 9)
    public void submitRegistration(){

        try{

            WebElement SubmitRegistration = driver.findElement(By.xpath(
                    "//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"
            ));

            SubmitRegistration.click();

            WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(180));

            WebElement congratulationsMessage = waitLong.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='content']/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
            ));

            System.out.println("Registration Success : "+congratulationsMessage.getText());

            logResult("submitRegistration","SUCCESS");

        }

        catch(Exception e){

            logResult("submitRegistration","FAILED - "+e.getMessage());

            Assert.fail(e.getMessage());

        }

    }


}
