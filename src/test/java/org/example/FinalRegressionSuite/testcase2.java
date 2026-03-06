package org.example.FinalRegressionSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class testcase2 {
    WebDriver driver;
    WebDriverWait wait;
    FileWriter logWriter;

    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize log file
        logWriter = new FileWriter("D:\\SeleniumProject\\CP_Automation_Results\\test-results.txt", true);
        logWriter.write("===== Test Run Started at " + java.time.LocalDateTime.now() + " =====\n");
        logWriter.flush();
    }

    private void log(String message) {
        System.out.println(message);
        try {
            logWriter.write(message + "\n");
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWorldStridesLogo() {
        try {
            driver.get("https://account.worldstrides.com/Login");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img")
            ));
            Assert.assertTrue(element.isDisplayed(), "World Strides Logo is not present.");
            log("World Strides Logo test passed");
        } catch (Exception e) {
            log("Error in testWorldStridesLogo: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testWorldStridesLogo")
    public void testSignup() {
        try {
            WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a")
            ));
            signup.click();

            WebElement ProgramRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("registration-program")
            ));
            ProgramRegistration.sendKeys("228614");

            WebElement continueReg = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button")
            ));
            continueReg.click();

            log("Signup flow executed successfully");
        } catch (Exception e) {
            log("Error in testSignup: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testSignup")
    public void testSelectAsAdult() {
        try {
            WebElement Select1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"tavellingAs1\"]/option[3]")
            ));
            Select1.click();
            Assert.assertTrue(Select1.isDisplayed());
            log("Select As Adult Working");
        } catch (Exception e) {
            log("Error in testSelectAsAdult: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testSelectAsAdult")
    public void testFillTravelerInfo() {
        try {
            driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]")).click();
            driver.findElement(By.id("firstnameTraveller1")).sendKeys("AmarMarch04th2026");
            driver.findElement(By.id("lastNameTraveller1")).sendKeys("TestSelenium1");
            driver.findElement(By.id("emailTraveler1")).sendKeys("Selenium@gmail23.com");
            driver.findElement(By.id("retypeEmailTraveler1")).sendKeys("Selenium@gmail23.com");
            WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"genderTraveler1\"]/option[3]")
            ));
            gender.click();
            Assert.assertTrue(gender.isSelected());
            driver.findElement(By.id("bdayTraveler1")).sendKeys("09081999");
            log("Traveler Info filled successfully");
        } catch (Exception e) {
            log("Error in testFillTravelerInfo: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testFillTravelerInfo")
    public void testPrimaryAccountDetails() {
        try {
            driver.findElement(By.xpath("//*[@id=\"traveler-1\"]/div/div[2]/div[3]/div[1]/div/div/div/label")).click();
            driver.findElement(By.xpath("//*[@id=\"address1Traveler1\"]")).sendKeys("New Street no 4");
            driver.findElement(By.xpath("//*[@id=\"zipTraveler1\"]")).sendKeys("80010");

            Select select = new Select(driver.findElement(By.id("1countryCodeTraveler1")));
            select.selectByVisibleText("USA(+1)");

            driver.findElement(By.id("1phoneTraveler1")).sendKeys("9989998978");
            driver.findElement(By.id("usernameTraveler1")).sendKeys("Testcase2March04th2026");
            driver.findElement(By.id("passwordTraveler1")).sendKeys("Amar@0601");
            driver.findElement(By.id("retypePasswordTraveler1")).sendKeys("Amar@0601");

            log("Primary Account Details filled successfully");
        } catch (Exception e) {
            log("Error in testPrimaryAccountDetails: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testPrimaryAccountDetails")
    public void testEmergencyContactDetails() throws InterruptedException {
        try {
            Select select1 = new Select(driver.findElement(By.id("relationshipEmergencyContact")));
            select1.selectByVisibleText("Mother");
            driver.findElement(By.id("firstnameEmergencyContact")).sendKeys("Selenium");
            driver.findElement(By.id("lastnameEmergencyContact")).sendKeys("Selenium");
            driver.findElement(By.id("emailEmergencyContact")).sendKeys("SeleniumTest@email.com");
            driver.findElement(By.id("retypeEmailEmergencyContact")).sendKeys("SeleniumTest@email.com");

            Select select2 = new Select(driver.findElement(By.id("1countryCodeEmergencyContact")));
            select2.selectByVisibleText("USA(+1)");

            driver.findElement(By.id("1phoneEmergencyContact")).sendKeys("7897897898");

            driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button")).click();

            log("Emergency Contact Details saved successfully");
            Thread.sleep(4000);
        } catch (Exception e) {
            log("Error in testEmergencyContactDetails: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testEmergencyContactDetails")
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

    @Test(dependsOnMethods = "Agreement")
    public void PaymentFull() throws InterruptedException {
        try {
            driver.findElement(By.id("listPayInFull")).click();
            Thread.sleep(2000);
            log("Pay in Full selected");

            // Use class locator instead of brittle XPath
            WebElement saveContinueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveContinueBtn);
            saveContinueBtn.click();
            Thread.sleep(4000);

            driver.findElement(By.id("listCardPayment")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
            driver.findElement(By.id("card-first-name")).sendKeys("Test");
            driver.findElement(By.id("card-last-name")).sendKeys("Test");
            driver.findElement(By.id("card-expiration")).sendKeys("01/30");
            driver.findElement(By.id("card-cvv")).sendKeys("909");
            driver.findElement(By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label")).click();

            WebElement saveAndContinuePayment = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndContinuePayment);
            saveAndContinuePayment.click();
            Thread.sleep(5000);

            log("Payment completed successfully");
        } catch (Exception e) {
            log("Error in PaymentFull: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "PaymentFull")
    public void testSubmitRegistration() {
        try {
            WebElement submitBtn = driver.findElement(By.xpath(
                    "//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
            submitBtn.click();
            log("Submit Registration clicked");

            WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(180));
            WebElement congrats = waitLong.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
            ));

            if (congrats.isDisplayed()) {
                log("Registration Success: " + congrats.getText());
            } else {
                log("Registration Failed");
            }
        } catch (Exception e) {
            log("Error in testSubmitRegistration: " + e.getMessage());
        }
        driver.quit();
    }
}