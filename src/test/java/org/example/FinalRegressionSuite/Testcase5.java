package org.example.FinalRegressionSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.naming.ldap.PagedResultsControl;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Testcase5 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate");
        driver = new EdgeDriver(options);
        driver.get("https://account.worldstrides.com/Login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        WebElement Username = driver.findElement(By.id("Username"));
        Username.sendKeys("AmarTest2Dec8th2025");

        WebElement Password = driver.findElement(By.id("Password"));
        Password.sendKeys("Amar@0601");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        LoginButton.click();
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void addTraveller() throws InterruptedException {

        WebElement Addtraveller = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/h6/a"));
        Addtraveller.click();
        Thread.sleep(4000);

        WebElement ViewTrip = driver.findElement(By.xpath("//*[@id=\"Active\"]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button"));
        ViewTrip.click();
        Thread.sleep(4000);

        WebElement AddTrav = driver.findElement(By.xpath("//*[@id=\"nav-portal-traveler\"]/div/div[2]/a[1]"));
        AddTrav.click();
        Thread.sleep(4000);

    }

    @Test(priority = 3)
    public void TravellerDetails() {
        WebElement SelectNew = driver.findElement(By.xpath("//*[@id=\"traveler-1\"]/div/div[1]/span/select/option[2]"));
        SelectNew.click();

        WebElement SelectStudent = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));
        SelectStudent.click();

        WebElement Grade = driver.findElement(By.xpath("//*[@id=\"currentGrade1\"]/option[3]"));
        Grade.click();

        WebElement Interest = driver.findElement(By.xpath("//*[@id=\"studentInterest1\"]/option[4]"));
        Interest.click();

        WebElement Country = driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]"));
        Country.click();

        WebElement Firstname = driver.findElement(By.id("firstnameTraveller1"));
        Firstname.sendKeys("AmarExist2");

        WebElement StudentLastname = driver.findElement(By.id("lastNameTraveller1"));
        StudentLastname.sendKeys("Dec18th");

        WebElement StudentEmail = driver.findElement(By.id("emailTraveler1"));
        StudentEmail.sendKeys("SeleniumDec18thtest@gmail.com");


        WebElement StudentEmailRetype = driver.findElement(By.id("retypeEmailTraveler1"));
        StudentEmailRetype.sendKeys("SeleniumDec18thtest@gmail.com");


        WebElement Traveller1Gender = driver.findElement(By.xpath("//*[@id=\"genderTraveler1\"]/option[2]"));
        Traveller1Gender.click();

        WebElement DOB = driver.findElement(By.id("bdayTraveler1"));
        DOB.sendKeys("09032011");

    }

    @Test(priority = 4)
    public void AccountInfo() throws InterruptedException {
        WebElement SelectResposible = driver.findElement(By.xpath("//*[@id=\"primaryAccRelation1\"]/option[13]"));
        SelectResposible.click();

        WebElement SelectEmergency = driver.findElement(By.xpath("//*[@id=\"selectEmergency1\"]/option[2]"));
        SelectEmergency.click();

        WebElement SelectRelationEmer = driver.findElement(By.xpath("//*[@id=\"relationshipEmergencyContact1\"]/option[13]"));
        SelectRelationEmer.click();

        WebElement Save = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        Save.click();
        Thread.sleep(4000);
    }

    @Test(priority = 5)
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

    @Test(priority = 6)
    public void Payments() throws InterruptedException {

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

    @Test(priority = 7)
    public void SubmitRegistration() throws InterruptedException {
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

    @Test(priority = 8)
    public void Screenshot() {
        try {
            // Check if the browser supports full-page screenshots (Edge/Chrome)
            if (driver instanceof TakesScreenshot) {
                // Cast the driver to TakesScreenshot to use its screenshot capabilities
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                // Define the destination file path
                String screenshotPath = "C:\\Users\\amartejac\\Pictures\\Screenshots\\CP\\Selenium\\fullPageScreenshot1.png";
                File destinationFile = new File(screenshotPath);

                // Save the screenshot
                FileHandler.copy(screenshotFile, destinationFile);
                System.out.println("Full-page screenshot saved at: " + destinationFile.getAbsolutePath());
            } else {
                System.out.println("Full page screenshot is not supported by this driver.");
            }
        }
        catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }


