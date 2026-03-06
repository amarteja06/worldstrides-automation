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

public class testcase1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-account.worldstrides.com/Login");
        WebElement Advance = driver.findElement(By.id("details-button"));
        Advance.click();
        WebElement Urlclick = driver.findElement(By.id("proceed-link"));
        Urlclick.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void logResult(String testName, String result) {
        try {
            File folder = new File("results");
            if (!folder.exists()) folder.mkdirs();

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
            Assert.assertTrue(element.isDisplayed(), "World Strides Logo is not present on the page.");
            System.out.println("World Strides Logo is present on the page.");
            logResult("verifyLogoPresence", "SUCCESS");
        } catch (Exception e) {
            logResult("verifyLogoPresence", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testSignUpFlow() {
        try {
            WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a")
            ));
            signup.click();
            System.out.println("Sign up working");

            WebElement ProgramRegistration = driver.findElement(By.id("registration-program"));
            ProgramRegistration.sendKeys("198053");
            System.out.println("Program Reg button working Fine ");

            WebElement Continuereg = driver.findElement(By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button"));
            Continuereg.click();
            Thread.sleep(4000);
            System.out.println("Continue Registration Working Fine ");
            logResult("testSignUpFlow", "SUCCESS");
        } catch (Exception e) {
            logResult("testSignUpFlow", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void selectParticipantDetails() {
        try {
            WebElement Select1 = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));
            Select1.click();
            Assert.assertTrue(Select1.isDisplayed(), "Student selection functionality is not working.");
            System.out.println("Selected as STUDENT");

            WebElement grade11 = driver.findElement(By.xpath("//*[@id=\"currentGrade1\"]/option[3]"));
            grade11.click();
            Assert.assertTrue(grade11.isSelected(), "Grade selection is not working.");
            System.out.println("STUDENT GRADE selected");

            WebElement Studentinterest = driver.findElement(By.xpath("//*[@id=\"studentInterest1\"]/option[4]"));
            Studentinterest.click();
            Assert.assertTrue(Studentinterest.isSelected(), "Student Interest selection is not working.");
            System.out.println("STUDENT INTEREST selected ");

            WebElement CountrySelection = driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]"));
            CountrySelection.click();
            String Countryis = CountrySelection.getAttribute("value");
            System.out.println("Country selected " + Countryis);

            logResult("selectParticipantDetails", "SUCCESS");
        } catch (Exception e) {
            logResult("selectParticipantDetails", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void enterStudentPersonalDetails() {
        try {
            driver.findElement(By.id("firstnameTraveller1")).sendKeys("March04th2026");
            driver.findElement(By.id("lastNameTraveller1")).sendKeys("Amar");
            driver.findElement(By.id("emailTraveler1")).sendKeys("Selenium@gmail23.com");
            driver.findElement(By.id("retypeEmailTraveler1")).sendKeys("Selenium@gmail23.com");
            driver.findElement(By.xpath("//*[@id=\"genderTraveler1\"]/option[2]")).click();
            driver.findElement(By.id("bdayTraveler1")).sendKeys("01092010");

            logResult("enterStudentPersonalDetails", "SUCCESS");
        } catch (Exception e) {
            logResult("enterStudentPersonalDetails", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void selectGuardianDetails() throws InterruptedException {
        try {
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

            logResult("selectGuardianDetails", "SUCCESS");
        } catch (Exception e) {
            logResult("selectGuardianDetails", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void AccountDetails() {
        try {
            driver.findElement(By.id("usernameGaurdian")).sendKeys("March04th2026Script");
            driver.findElement(By.id("passwordGaurdian")).sendKeys("Amar@0601");
            driver.findElement(By.id("retypePasswordGaurdian")).sendKeys("Amar@0601");
            driver.findElement(By.xpath("//*[@id=\"parent-acc-form\"]/div[2]/div[2]/label")).click();
            driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button")).click();
            Thread.sleep(5000);

            logResult("AccountDetails", "SUCCESS");
        } catch (Exception e) {
            logResult("AccountDetails", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void Agreement() {
        try {
            By singleCheckbox = By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[6]/div/div/div[1]/div/div/label");
            By singleSaveAndContinue = By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]");

            if (!driver.findElements(singleCheckbox).isEmpty() &&
                    driver.findElement(singleCheckbox).isDisplayed()) {

                WebElement single = wait.until(ExpectedConditions.elementToBeClickable(singleCheckbox));
                single.click();
                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(singleSaveAndContinue));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                saveBtn.click();
                logResult("Agreement", "SUCCESS");
                return;
            }

            By agreementCheckboxes = By.xpath("//*[@id='content']//label/span");
            By genericSaveAndContinue = By.xpath(
                    "//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'save & continue')]"
            );

            while (true) {
                List<WebElement> visibleCheckboxes = driver.findElements(agreementCheckboxes).stream()
                        .filter(WebElement::isDisplayed)
                        .toList();

                if (visibleCheckboxes.isEmpty()) break;

                for (WebElement checkbox : visibleCheckboxes) {
                    wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
                }

                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(genericSaveAndContinue));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                saveBtn.click();
                Thread.sleep(2000);
            }
            logResult("Agreement", "SUCCESS");

        } catch (Exception e) {
            logResult("Agreement", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 8)
    public void Payments() {
        try {
            WebElement payInFull = wait.until(ExpectedConditions.elementToBeClickable(By.id("lblPayInFull")));
            payInFull.click();
            System.out.println("Pay in Full Clicked");

            WebElement saveAndContinue2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndContinue2);
            saveAndContinue2.click();
            System.out.println("Pay in full Save and Continue Clicked");

            WebElement CheckingAcc = wait.until(ExpectedConditions.elementToBeClickable(By.id("listElectronicCheck")));
            CheckingAcc.click();
            System.out.println("Defaultly Selected as Checking Account");

            driver.findElement(By.id("card-name")).sendKeys("Wells Fargo");
            driver.findElement(By.id("card-routing")).sendKeys("051400549");
            driver.findElement(By.id("card-account")).sendKeys("123456");
            driver.findElement(By.id("card-retype-acount")).sendKeys("123456");
            driver.findElement(By.id("card-holders-first-name")).sendKeys("Test");
            driver.findElement(By.id("card-holders-last-name")).sendKeys("Amar");

            WebElement SaveandContinue = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveandContinue);
            SaveandContinue.click();
            System.out.println("Final Save and Continue Clicked");

            logResult("Payments", "SUCCESS");

        } catch (Exception e) {
            logResult("Payments", "FAILED - " + e.getMessage());
        }
    }

    @Test(priority = 9)
    public void submitRegistration() {
           WebElement SubmitRegistration= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
           SubmitRegistration.click();
        try {
            WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(180)); // wait up to 3 minutes
            WebElement congratulationsMessage = waitLong.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='content']/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
            ));
            System.out.println("Registration Success: " + congratulationsMessage.getText());
            logResult("submitRegistration", "SUCCESS");

        } catch (Exception e) {
            logResult("submitRegistration", "FAILED - " + e.getMessage());
        }
    }

}