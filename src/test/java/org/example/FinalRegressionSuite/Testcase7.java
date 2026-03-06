package org.example.FinalRegressionSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Testcase7 {
    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate");
        driver = new EdgeDriver(options);
        driver.get("https://account.worldstrides.com/Login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        WebElement username = driver.findElement(By.id("Username"));
        username.sendKeys("Script2April18th2025@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Amar@0601");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        LoginButton.click();
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    public void AddTraveler() throws InterruptedException {
        WebElement ClickAdd = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/h6/a"));
        ClickAdd.click();

        WebElement ViewTrip = driver.findElement(By.xpath("//*[@id=\"Active\"]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button"));
        ViewTrip.click();
        Thread.sleep(4000);

        WebElement AddTrav = driver.findElement(By.xpath("//*[@id=\"nav-portal-traveler\"]/div/div[2]/a[1]"));
        AddTrav.click();
        Thread.sleep(4000);
    }

    @Test(priority = 3)
    public void TravelerDetails() {
        WebElement NewTraveler = driver.findElement(By.xpath("//*[@id=\"traveler-1\"]/div/div[1]/span/select/option[2]"));
        NewTraveler.click();

        WebElement Student = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));
        Student.click();

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

        WebElement Studentname = driver.findElement(By.id("firstnameTraveller1"));
        Studentname.sendKeys("january29th2026");
        String enteredName = Studentname.getAttribute("value");
        System.out.println("Student First name : " + enteredName);

        WebElement StudentLastname = driver.findElement(By.id("lastNameTraveller1"));
        StudentLastname.sendKeys("test1");
        String LastnameEntered = StudentLastname.getAttribute("value");
        System.out.println("Student Lastname : " + LastnameEntered);

        WebElement StudentEmail = driver.findElement(By.id("emailTraveler1"));
        StudentEmail.sendKeys("Selenium@gmail23.com");
        String StudentEmailEnter = StudentEmail.getAttribute("value");
        System.out.println("Student Email :" + StudentEmailEnter);

        WebElement StudentEmailRetype = driver.findElement(By.id("retypeEmailTraveler1"));
        StudentEmailRetype.sendKeys("Selenium@gmail23.com");
        String StudentReTypeEmailEnter = StudentEmailRetype.getAttribute("value");
        System.out.println("Student Retype Email : " + StudentReTypeEmailEnter);

        WebElement Gender = driver.findElement(By.xpath("//*[@id=\"genderTraveler1\"]/option[2]"));
        Gender.click();
        String Gender2 = Gender.getAttribute("value");
        System.out.println("Guardian Country : " + Gender2);

        WebElement Dob = driver.findElement(By.id("bdayTraveler1"));
        Dob.sendKeys("01012010");

        WebElement SelectResp = driver.findElement(By.xpath("//*[@id=\"primaryAccRelation1\"]/option[13]"));
        SelectResp.click();

        WebElement SelectEmer = driver.findElement(By.xpath("//*[@id=\"selectEmergency1\"]/option[2]"));
        SelectEmer.click();

        WebElement SelectEmerRelation = driver.findElement(By.xpath("//*[@id=\"relationshipEmergencyContact1\"]/option[13]"));
        SelectEmerRelation.click();

    }

    @Test(priority = 4)
    public void AddTravelerExtra() throws InterruptedException{
        WebElement Addtraveler = driver.findElement(By.className("add-traveller-btn "));
        Addtraveler.click();
        System.out.println("ADULT DETAILS :-");

        WebElement SelectNew = driver.findElement(By.xpath("//*[@id=\"2\"]/option[2]"));
        SelectNew.click();

        WebElement Select2 = driver.findElement(By.xpath("//*[@id=\"tavellingAs2\"]/option[3]"));
        Select2.click();
        Assert.assertTrue(Select2.isDisplayed(), "Adult selection functionality is not working.");
        System.out.println("Selected Adult");

        WebElement State = driver.findElement(By.xpath("//*[@id=\"countryTraveler2\"]/option[2]"));
        State.click();
        String enteredName = State.getAttribute("value");
        System.out.println("Selected State : " + enteredName);

        WebElement Firstname = driver.findElement(By.id("firstnameTraveller2"));
        Firstname.sendKeys("Adultjanuary26th");
        String FirstenteredName = Firstname.getAttribute("value");
        System.out.println("First name : " + FirstenteredName);

        WebElement Lastname = driver.findElement(By.id("lastNameTraveller2"));
        Lastname.sendKeys("test1");
        String LastenteredName = Lastname.getAttribute("value");
        System.out.println("Last name : " + LastenteredName);

        WebElement Email = driver.findElement(By.id("emailTraveler2"));
        Email.sendKeys("Emailtest@test.com");
        String EmailEntered = Email.getAttribute("value");
        System.out.println("Email : " + EmailEntered);

        WebElement retypeEmail = driver.findElement(By.id("retypeEmailTraveler2"));
        retypeEmail.sendKeys("Emailtest@test.com");
        String retypeenetered = retypeEmail.getAttribute("value");
        System.out.println("Retype Email : " + retypeenetered);

        WebElement Gender = driver.findElement(By.xpath("//*[@id=\"genderTraveler2\"]/option[2]"));
        Gender.click();
        String Genderselect = Lastname.getAttribute("value");
        System.out.println("Gender Selected as : " + Genderselect);

        WebElement Dob = driver.findElement(By.id("bdayTraveler2"));
        Dob.sendKeys("08022000");
        String dobentered = Dob.getAttribute("value");
        System.out.println(" DOB : " + dobentered);

        WebElement SelectResp = driver.findElement(By.xpath("//*[@id=\"primaryAccRelation2\"]/option[13]"));
        SelectResp.click();

        WebElement SelctEmer = driver.findElement(By.xpath("//*[@id=\"selectEmergency2\"]/option[2]"));
        SelctEmer.click();

        WebElement SelectEmerType = driver.findElement(By.xpath("//*[@id=\"relationshipEmergencyContact2\"]/option[13]"));
        SelectEmerType.click();

        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContinue.click();
        Thread.sleep(3000);

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

        WebElement CheckingAcc = driver.findElement(By.id("listElectronicCheck"));
        CheckingAcc.isSelected();
        System.out.println("Defaultly Selected as " + CheckingAcc);
        Thread.sleep(2000);

        WebElement BankName = driver.findElement(By.id("card-name"));
        BankName.sendKeys("Wells Fargo");
        Thread.sleep(2000);

        WebElement RoutingNumber = driver.findElement(By.id("card-routing"));
        RoutingNumber.sendKeys("051400549");
        Thread.sleep(2000);

        WebElement AccountNumber = driver.findElement(By.id("card-account"));
        AccountNumber.sendKeys("123456");
        Thread.sleep(2000);

        WebElement RetypeAcc = driver.findElement(By.id("card-retype-acount"));
        RetypeAcc.sendKeys("123456");
        Thread.sleep(2000);

        WebElement AccHolderName = driver.findElement(By.id("card-holders-first-name"));
        AccHolderName.sendKeys("Test");
        Thread.sleep(2000);

        WebElement AccLastname = driver.findElement(By.id("card-holders-last-name"));
        AccLastname.sendKeys("Amar");
        Thread.sleep(2000);

        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue.click();
        Thread.sleep(5000);

    }
    @Test(priority = 9)
    public void submitRegistration() throws InterruptedException {
        try {
            // Wait for and click on the submit registration button
            WebElement submitRegistrationButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
            submitRegistrationButton.click();
            System.out.println("Submit Registration button clicked");
            Thread.sleep(50000);

            // Wait for the congratulations message to be visible
            WebElement congratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]"));

            if (congratulationsMessage.isDisplayed()) {
                System.out.println("Registration Suceess");
            } else {
                System.out.println("Registration Failed ");
            }


        } catch (Exception e) {
            // Print full stack trace for better debugging
            e.printStackTrace();
            System.out.println("Execution stopped after testSubmitRegistration method. Error: " + e.getMessage());
        }

    }

}


