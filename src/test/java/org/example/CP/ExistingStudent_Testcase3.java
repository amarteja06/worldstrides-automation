package org.example.CP;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;


public class ExistingStudent_Testcase3 {
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

        WebElement Login = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        Login.click();
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
    public void Agreement() throws InterruptedException {

        // Single Page Agreement
        try {
            WebElement singlePage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[6]/div/div/div[1]/div/div/label"));
            if (singlePage.isDisplayed()) {
                // Single Page found, perform the operation
                singlePage.click();
                Thread.sleep(5000);

                WebElement saveAndContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]"));
                if (saveAndContinue.isDisplayed()) {
                    saveAndContinue.click();
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Single Page Not found");
        }

        // Wait before moving to the next operation
        Thread.sleep(5000);

        // Triple Page Agreement (if Single Page is not found)
        try {
            WebElement triplePage1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[3]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
            if (triplePage1.isDisplayed()) {
                // Triple Page 1 found, perform the operation
                triplePage1.click();
                Thread.sleep(3000);

                WebElement triplePage2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[4]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
                if (triplePage2.isDisplayed()) {
                    triplePage2.click();
                    Thread.sleep(3000);

                    WebElement triplePage3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[5]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
                    if (triplePage3.isDisplayed()) {
                        triplePage3.click();
                        Thread.sleep(3000);

                        WebElement tripleSave = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]"));
                        if (tripleSave.isDisplayed()) {
                            tripleSave.click();
                            Thread.sleep(3000);
                        }
                    }
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Triple Page Not Found");
        }

        // Wait before moving to the next operation
        Thread.sleep(5000);

        // Double Page Agreement (if neither Single nor Triple Pages are found)
        try {
            WebElement doublePage1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[3]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
            if (doublePage1.isDisplayed()) {
                // Double Page 1 found, perform the operation
                doublePage1.click();
                Thread.sleep(5000);

                WebElement doublePage2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[4]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
                if (doublePage2.isDisplayed()) {
                    doublePage2.click();
                    Thread.sleep(5000);

                    WebElement doubleSave = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]"));
                    if (doubleSave.isDisplayed()) {
                        doubleSave.click();
                        Thread.sleep(5000);

                        WebElement doubleFullRefund = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span"));
                        if (doubleFullRefund.isDisplayed()) {
                            doubleFullRefund.click();
                            Thread.sleep(5000);

                            WebElement doubleAgree = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]"));
                            if (doubleAgree.isDisplayed()) {
                                doubleAgree.click();
                                Thread.sleep(5000);
                            }
                        }
                    }
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Double Page Not found");
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
    public void Test() {
        try {
            // Wait for and click on the submit registration button
            WebElement submitRegistrationButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
            submitRegistrationButton.click();
            System.out.println("Submit Registration button clicked");
            Thread.sleep(50000);

            // Wait for the congratulations message to be visible
            WebElement congratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]"));

            if (congratulationsMessage.isDisplayed()) {
                System.out.println("Registration Success");

                // Take a full-page screenshot after registration success
                takeFullPageScreenshot();
            } else {
                System.out.println("Registration Failed");
            }

        } catch (Exception e) {
            // Print full stack trace for better debugging
            e.printStackTrace();
            System.out.println("Execution stopped after testSubmitRegistration method. Error: " + e.getMessage());
        }
    }

    public void takeFullPageScreenshot() {
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
        } catch (IOException e) {
            System.out.println("Error while taking the screenshot: " + e.getMessage());
        }
    }
}

