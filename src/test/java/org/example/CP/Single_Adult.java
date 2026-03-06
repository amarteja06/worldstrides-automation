package org.example.CP;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Single_Adult {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws IOException {
        // Set the path for Edge driver
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
        // Initialize the Edge WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait for 10 seconds
    }

    @Test
    public void testWorldStridesLogo() {
        try {
            driver.get("https://account.worldstrides.com/Login");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img")));
            Assert.assertTrue(element.isDisplayed(), "World Strides Logo is not present on the page.");
            System.out.println("World Strides Logo test working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testWorldStridesLogo method. Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testWorldStridesLogo")
    public void testSignup() {
        try {
            WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a")));
            signup.click();

            WebElement ProgramRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-program")));
            ProgramRegistration.sendKeys("110765");

            WebElement Continuereg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button")));
            Continuereg.click();
            System.out.println("Signup Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testSignup method. Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testSignup")
    public void testSelectAsAdult() {
        try {
            // Selecting as Adult
            WebElement Select1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tavellingAs1\"]/option[3]")));
            Select1.click();
            Assert.assertTrue(Select1.isDisplayed(), "Failed to select Adult option.");
            System.out.println("Select As Adult Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testSelectAsAdult method. Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testSelectAsAdult")
    public void testFillTravelerInfo() {
        try {
            // Selecting Traveler1 Country
            WebElement Country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]")));
            Country.click();

            // Entering Traveler1 First Name
            WebElement AdultFirstname = driver.findElement(By.id("firstnameTraveller1"));
            AdultFirstname.sendKeys("AmarDecember22nd2025");

            // Entering Traveler1 Last Name
            WebElement AdultLastname = driver.findElement(By.id("lastNameTraveller1"));
            AdultLastname.sendKeys("TestSelenium1");

            // Entering Traveler1 Email
            WebElement Travller1Email = driver.findElement(By.id("emailTraveler1"));
            Travller1Email.sendKeys("Selenium@gmail23.com");

            // Confirm the Email of Traveler1
            WebElement Travller1EmailRetype = driver.findElement(By.id("retypeEmailTraveler1"));
            Travller1EmailRetype.sendKeys("Selenium@gmail23.com");

            // Confirm the Traveler1 Gender
            WebElement Traveller1Gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"genderTraveler1\"]/option[3]")));
            Traveller1Gender.click();
            Assert.assertTrue(Traveller1Gender.isSelected(), "Failed to select gender.");

            WebElement DOB = driver.findElement(By.id("bdayTraveler1"));
            DOB.sendKeys("09081999");
            System.out.println("Fill Traveler Info Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testFillTravelerInfo method. Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testFillTravelerInfo")
    public void testPrimaryAccountDetails() {
        try {
            // Select as Primary Account Holder
            WebElement PrimaryAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"traveler-1\"]/div/div[2]/div[3]/div[1]/div/div/div/label")));
            PrimaryAccount.click();

            WebElement PrimaryAddress = driver.findElement(By.xpath("//*[@id=\"address1Traveler1\"]"));
            PrimaryAddress.sendKeys("New Street no 4");


            WebElement PrimaryZipcode = driver.findElement(By.xpath("//*[@id=\"zipTraveler1\"]"));
            PrimaryZipcode.sendKeys("80010");

            WebElement MobileCountryDropdown = driver.findElement(By.id("1countryCodeTraveler1"));
            Select select = new Select(MobileCountryDropdown);
            select.selectByVisibleText("USA(+1)");

            WebElement PrimaryMobileNumber = driver.findElement(By.id("1phoneTraveler1"));
            PrimaryMobileNumber.sendKeys("9989998978");

            WebElement PrimaryUsername = driver.findElement(By.id("usernameTraveler1"));
            PrimaryUsername.sendKeys("December22nd20251@gmail.com");

            WebElement PrimaryUserPass = driver.findElement(By.id("passwordTraveler1"));
            PrimaryUserPass.sendKeys("Amar@0601");

            WebElement PrimaryUserRetypePass = driver.findElement(By.id("retypePasswordTraveler1"));
            PrimaryUserRetypePass.sendKeys("Amar@0601");
            System.out.println("Primary Account Details Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testPrimaryAccountDetails method. Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "testPrimaryAccountDetails")
    public void testEmergencyContactDetails() throws InterruptedException {
        try {
            WebElement EmergencyDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("relationshipEmergencyContact")));
            Select select1 = new Select(EmergencyDropdown);
            select1.selectByVisibleText("Mother");

            WebElement emergencyfirstname = driver.findElement(By.id("firstnameEmergencyContact"));
            emergencyfirstname.sendKeys("Selenium");

            WebElement emergencylastname = driver.findElement(By.id("lastnameEmergencyContact"));
            emergencylastname.sendKeys("Selenium");

            WebElement EmergencyEmail = driver.findElement(By.id("emailEmergencyContact"));
            EmergencyEmail.sendKeys("SeleniumTest@email.com");

            WebElement EmergencyRetypeEmail = driver.findElement(By.id("retypeEmailEmergencyContact"));
            EmergencyRetypeEmail.sendKeys("SeleniumTest@email.com");

            WebElement EmergencyMobileDropdown = driver.findElement(By.id("1countryCodeEmergencyContact"));
            Select select2 = new Select(EmergencyMobileDropdown);
            select2.selectByVisibleText("USA(+1)");

            WebElement EmergencyMobilenNumber = driver.findElement(By.id("1phoneEmergencyContact"));
            EmergencyMobilenNumber.sendKeys("7897897898");

            WebElement SaveContinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button")));
            SaveContinue.click();
            System.out.println("Emergency Contact Details Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testEmergencyContactDetails method. Error: " + e.getMessage());
        }
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = "testEmergencyContactDetails")
    public void Agreement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // ------------------- 1. Single Page -------------------
            By singleCheckbox = By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[6]/div/div/div[1]/div/div/label");
            By singleSaveAndContinue = By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]");

            if (!driver.findElements(singleCheckbox).isEmpty() &&
                    driver.findElement(singleCheckbox).isDisplayed()) {
                System.out.println("Single Page Agreement detected");

                WebElement single = wait.until(ExpectedConditions.elementToBeClickable(singleCheckbox));
                single.click();

                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(singleSaveAndContinue));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                saveBtn.click();

                System.out.println("Single Page Agreement completed");
                return; // Done, exit the method
            }

            // ------------------- 2. Double or Triple Page -------------------
            By agreementCheckboxes = By.xpath("//*[@id='content']//label/span");

            // Case-insensitive Save & Continue button
            By genericSaveAndContinue = By.xpath(
                    "//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'save & continue')]"
            );

            while (true) {
                // Get all visible checkboxes on current page
                List<WebElement> visibleCheckboxes = driver.findElements(agreementCheckboxes).stream()
                        .filter(WebElement::isDisplayed)
                        .toList();

                if (visibleCheckboxes.isEmpty()) break; // No more checkboxes, exit loop

                System.out.println("Agreement page detected with " + visibleCheckboxes.size() + " visible checkbox(es)");

                // Click all checkboxes
                for (WebElement checkbox : visibleCheckboxes) {
                    wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
                }

                // Scroll to Save & Continue button and click
                WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(genericSaveAndContinue));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                saveBtn.click();

                // Small wait for next page to load
                Thread.sleep(500);
            }

            System.out.println("Agreement pages completed successfully");

        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Agreement page did not appear or failed: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "Agreement")
    public void PaymentFull() throws InterruptedException {

        WebElement PayinFull = driver.findElement(By.id("listPayInFull"));
        PayinFull.click();
        Thread.sleep(2000);
        System.out.println("Pay in Full Clicked");

        WebElement SaveandContinue2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue2.click();
        System.out.println("Pay in full Save and Continue Clicked");
        Thread.sleep(4000);

        WebElement Card = driver.findElement(By.id("listCardPayment"));
        Card.click();
        Thread.sleep(2000);

        WebElement CardNumber = driver.findElement(By.xpath("//*[@id=\"card-number\"]"));
        CardNumber.sendKeys("4111 1111 1111 1111");
        Thread.sleep(2000);

        WebElement CardFirstName = driver.findElement(By.id("card-first-name"));
        CardFirstName.sendKeys("Test");
        Thread.sleep(2000);

        WebElement cardlastname = driver.findElement(By.id("card-last-name"));
        cardlastname.sendKeys("Test");
        Thread.sleep(2000);

        WebElement CardExpiry = driver.findElement(By.id("card-expiration"));
        CardExpiry.sendKeys("01/30");
        Thread.sleep(2000);

        WebElement cvv = driver.findElement(By.id("card-cvv"));
        cvv.sendKeys("909");
        Thread.sleep(2000);

        WebElement AddressCheck = driver.findElement(By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label"));
        AddressCheck.click();

        WebElement SaveandContinue3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue3.click();
        Thread.sleep(5000);
        System.out.println("Save and Continue for payment success");
    }

    @Test(dependsOnMethods = "PaymentFull")
    public void testSubmitRegistration() throws IOException {
        try {
            // Click on the Submit Registration button
            WebElement submitRegistrationButton = driver.findElement(By.xpath(
                    "//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
            submitRegistrationButton.click();
            System.out.println("Submit Registration button clicked");

            // Explicit wait for the congratulations message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            By congratulationsLocator = By.xpath(
                    "//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]");

            WebElement congratulationsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(congratulationsLocator));

            if (congratulationsMessage.isDisplayed()) {
                System.out.println("Registration Success");
            } else {
                System.out.println("Registration Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Execution stopped after testSubmitRegistration method. Error: " + e.getMessage());
        }
    }
}
