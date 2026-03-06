package org.example.CP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class AIR {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
            WebElement Country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]")));
            Country.click();

            WebElement AdultFirstname = driver.findElement(By.id("firstnameTraveller1"));
            AdultFirstname.sendKeys("AmarAugust13th2025");

            WebElement AdultLastname = driver.findElement(By.id("lastNameTraveller1"));
            AdultLastname.sendKeys("TestSelenium");

            WebElement Travller1Email = driver.findElement(By.id("emailTraveler1"));
            Travller1Email.sendKeys("Selenium@gmail23.com");

            WebElement Travller1EmailRetype = driver.findElement(By.id("retypeEmailTraveler1"));
            Travller1EmailRetype.sendKeys("Selenium@gmail23.com");

            WebElement Traveller1Gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"genderTraveler1\"]/option[3]")));
            Traveller1Gender.click();
            Assert.assertTrue(Traveller1Gender.isSelected(), "Failed to select gender.");

            WebElement DOB = driver.findElement(By.id("bdayTraveler1"));
            DOB.sendKeys("09081999");
            System.out.println("Fill Traveler Info Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testFillTravelerInfo method. Error: " + e.getMessage());
        }
        WebElement AIRCONSENT = driver.findElement(By.id("travelType_auto_0"));
        AIRCONSENT.click();
        if(AIRCONSENT.isSelected()){
            System.out.println("AIR CONSENT IS CHECKED ");
        }else{
            System.out.println("AIR CONSENT SELECTION FAILED ");
        }
    }

    @Test(dependsOnMethods = "testFillTravelerInfo")
    public void testPrimaryAccountDetails() throws InterruptedException {
        try {
            WebElement PrimaryAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"traveler-1\"]/div/div[2]/div[3]/div[1]/div/div/div/label")));
            PrimaryAccount.click();

            WebElement PrimaryAddress = driver.findElement(By.xpath("//*[@id=\"address1Traveler1\"]"));
            PrimaryAddress.sendKeys("New Street no 4");

            WebElement Cityname = driver.findElement(By.id("cityTraveler1"));
            Cityname.sendKeys("New York");

            WebElement DropCity = driver.findElement(By.id("stateTraveler1"));
            Select CityName = new Select(DropCity);
            CityName.selectByIndex(35);
            String SelectedOption = CityName.getFirstSelectedOption().getText();
            System.out.println("Selected City = " + SelectedOption);

            WebElement PrimaryZipcode = driver.findElement(By.xpath("//*[@id=\"zipTraveler1\"]"));
            PrimaryZipcode.sendKeys("10010");

            WebElement MobileCountryDropdown = driver.findElement(By.id("1countryCodeTraveler1"));
            Select select = new Select(MobileCountryDropdown);
            select.selectByVisibleText("USA(+1)");

            WebElement PrimaryMobileNumber = driver.findElement(By.id("1phoneTraveler1"));
            PrimaryMobileNumber.sendKeys("9989998978");

            WebElement PrimaryUsername = driver.findElement(By.id("usernameTraveler1"));
            PrimaryUsername.sendKeys("Test3August13th2025@gmail.com");

            WebElement PrimaryUserPass = driver.findElement(By.id("passwordTraveler1"));
            PrimaryUserPass.sendKeys("Amar@0601");

            WebElement PrimaryUserRetypePass = driver.findElement(By.id("retypePasswordTraveler1"));
            PrimaryUserRetypePass.sendKeys("Amar@0601");
            System.out.println("Primary Account Details Working");
        } catch (Exception e) {
            System.out.println("Execution stopped after testPrimaryAccountDetails method. Error: " + e.getMessage());
        }
        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContinue.click();
        Thread.sleep(6000);
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
    public void testAgreementAndPayment() throws InterruptedException {
        Thread.sleep(5000); // Wait for the agreement page to load properly

        // Find all agreement option labels within the terms-and-conditions page
        List<WebElement> agreementOptions = driver.findElements(By.xpath("//div[contains(@class,'terms-and-conditions-page')]//label"));

        int optionCount = agreementOptions.size();
        System.out.println("Number of agreement options found: " + optionCount);

        if (optionCount == 0) {
            System.out.println("No agreement options found.");
            return;
        }

        if (optionCount == 2) {
            // Single agreement page - likely Accept and Decline buttons
            System.out.println("Single agreement page detected.");

            // Click the 'Accept' option (assuming first or find by label text)
            WebElement acceptOption = null;
            for (WebElement option : agreementOptions) {
                if (option.getText().toLowerCase().contains("accept")) {
                    acceptOption = option;
                    break;
                }
            }
            if (acceptOption != null) {
                acceptOption.click();
                System.out.println("Clicked Accept option on single agreement page.");
            } else {
                System.out.println("Accept option not found on single agreement page.");
            }

            Thread.sleep(3000);
            WebElement saveContinueBtn = driver.findElement(By.xpath("//button[contains(text(),'Save and Continue')]"));
            saveContinueBtn.click();
            Thread.sleep(5000);

        } else if (optionCount == 4 || optionCount == 6) {
            // Double or triple agreement pages - each section likely has 2 options (Accept/Decline)
            // Click all Accept options (assumed to be every even index or by text)
            System.out.println("Double or triple agreement page detected.");

            for (WebElement option : agreementOptions) {
                if (option.getText().toLowerCase().contains("accept")) {
                    option.click();
                    System.out.println("Clicked an Accept option.");
                    Thread.sleep(3000);
                }
            }

            WebElement saveContinueBtn = driver.findElement(By.xpath("//button[contains(text(),'Save and Continue')]"));
            saveContinueBtn.click();
            Thread.sleep(5000);

        } else {
            System.out.println("Unexpected number of agreement options: " + optionCount);
            // Optionally handle other cases or fail
        }
    }


    @Test(dependsOnMethods = "testAgreementAndPayment")
    public void Only() throws InterruptedException {

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

    @Test(dependsOnMethods = "Only")
    public void testSubmitRegistration() throws IOException {
        try {
            WebElement submitRegistrationButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
            submitRegistrationButton.click();
            System.out.println("Submit Registration button clicked");
            Thread.sleep(50000);

            WebElement congratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]"));

            if(congratulationsMessage.isDisplayed()){
                System.out.println("Registration Success");
            }else{
                System.out.println("Registration Failed ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Execution stopped after testSubmitRegistration method. Error: " + e.getMessage());
        }

    }
}
