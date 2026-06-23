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

public class testcase3 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate");
        driver = new EdgeDriver(options);
        driver.get("https://account.worldstrides.com/Login");
        driver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void verifyLogoPresence() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img"));
        Assert.assertTrue(element.isDisplayed(), "World Strides Logo is not present on the page.");
        System.out.println("World Strides Logo is present on the page.");

        System.out.println("--------------------------------------");
    }
    @Test(priority = 2)
    public void testSignUpFlow() throws InterruptedException {

        System.out.println("SIGNUP STATUS :");

        WebElement signup = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a"));
        signup.click();
        System.out.println("Sign up working");

        WebElement ProgramRegistration = driver.findElement(By.id("registration-program"));
        ProgramRegistration.sendKeys("110765");
        System.out.println("Program Reg button working Fine ");

        WebElement Continuereg = driver.findElement(By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button"));
        Continuereg.click();
        Thread.sleep(4000);
        System.out.println("Continue Registration Working Fine ");

        System.out.println("--------------------------------------");
    }
    @Test(priority = 3)
    public void selectParticipantDetails() {

        System.out.println("STUDENT DETAILS :-");

        WebElement Student1 = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));
        Student1.click();
        Assert.assertTrue(Student1.isDisplayed(), "Student selection functionality is not working.");
        System.out.println("Selected STUDENT");

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

    }

    @Test(priority = 4)
    public void enterStudentPersonalDetails() {


        WebElement Studentname = driver.findElement(By.id("firstnameTraveller1"));
        Studentname.sendKeys("March27th2026");
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

        System.out.println("--------------------------------------");
    }
    @Test(priority = 5)
    public void AddTraveler (){
        WebElement Addtraveler = driver.findElement(By.className("btn-Add-traveller"));
        Addtraveler.click();

    }
    @Test(priority = 6)
    public void AdultDetails(){
        System.out.println("ADULT DETAILS :-");

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

    }
    @Test(priority = 7)
    public void Resposible(){
        WebElement realtionshipguardian1 = driver.findElement(By.xpath("//*[@id=\"relationshipResponsible\"]/option[3]"));
        realtionshipguardian1.click();

        WebElement realtionshipguardian2 = driver.findElement(By.xpath("//*[@id=\"relationshipResponsible2\"]/option[3]"));
        realtionshipguardian2.click();

        WebElement ResponsibleCountry = driver.findElement(By.xpath("//*[@id=\"countryResponsible\"]/option[2]"));
        ResponsibleCountry.click();

        WebElement FirstnameResponsible = driver.findElement(By.id("firstnameResponsible"));
        FirstnameResponsible.sendKeys("responsible");

        WebElement LastnameResponsible = driver.findElement(By.id("lastnameResponsible"));
        LastnameResponsible.sendKeys("Guardian");

        WebElement addressResponsible = driver.findElement(By.id("addressResponsible"));
        addressResponsible.sendKeys("1-142-2, new york ");

        WebElement zipResponsible = driver.findElement(By.id("zipResponsible"));
        zipResponsible.sendKeys("10010");

        WebElement emailResponsible = driver.findElement(By.id("emailResponsible"));
        emailResponsible.sendKeys("DummyResponsible@gmail.com");

        WebElement RetypemeialResponsible = driver.findElement(By.id("retypeEmailResponsible"));
        RetypemeialResponsible.sendKeys("DummyResponsible@gmail.com");

        WebElement countryCodeResponsible = driver.findElement(By.xpath("//*[@id=\"1countryCodeResponsible\"]/option[2]"));
        countryCodeResponsible.click();

        WebElement phoneResponsible = driver.findElement(By.id("1phoneResponsible"));
        phoneResponsible.sendKeys("6786786789");

        WebElement PhoneNumberType = driver.findElement(By.xpath("//*[@id=\"1phoneTypeResponsible\"]/option[1]"));
        PhoneNumberType.click();

        System.out.println("--------------------------------------");

    }
    @Test(priority = 8)
    public void Username() throws InterruptedException {
        System.out.println("USERNAME DETAILS :-");

        WebElement usernameResponsible = driver.findElement(By.id("usernameResponsible"));
        usernameResponsible.sendKeys("March27th20261Testcase3");
        String Username = usernameResponsible.getAttribute("value");
        System.out.println("Username :"+ Username);


        WebElement passwordResponsible = driver.findElement(By.id("passwordResponsible"));
        passwordResponsible.sendKeys("Amar@0601");
        String Password = usernameResponsible.getAttribute("value");
        System.out.println("Password is :"+ Password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement retypePasswordResponsible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retypePasswordResponsible")));

        retypePasswordResponsible.sendKeys("Amar@0601");

        String RPassword = retypePasswordResponsible.getAttribute("value");
        System.out.println("Retype Password is: " + RPassword);

        //Opting check box for Responsible as Emergency contact
        WebElement serveEmergencyResponsible = driver.findElement(By.id("serveEmergencyResponsible"));
        serveEmergencyResponsible.click();


        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContinue.click();
        Thread.sleep(6000);

        System.out.println("--------------------------------------");
    }

    @Test(priority = 9)
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

    @Test(priority = 10)
    public void Payments() throws InterruptedException{

        WebElement payMonthly;
        payMonthly = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("lblPayInMonthly")));
        payMonthly.click();
        payMonthly.isSelected();
        System.out.println("Defaultly Selected as " + payMonthly);
        Thread.sleep(2000);

        WebElement Ezpay = driver.findElement(By.id("ezpayOption"));
        Ezpay.isSelected();
        System.out.println("Defaultly Selected as " + Ezpay);
        Thread.sleep(2000);

        WebElement Card  = driver.findElement(By.id("listCardPayment_ACH"));
        Card.click();
        Card.isSelected();
        System.out.println("Selected as " + Card.getText());
        Thread.sleep(2000);

        //initialpaymentinput-1
        WebElement priceEnter = driver.findElement(By.id("initialpaymentinput-1"));
        priceEnter.sendKeys("00");
        String PriceIs = priceEnter.getAttribute("value");
        System.out.println("Price Entered is :" + PriceIs);
        Thread.sleep(5000);

        WebElement priceEnter2 = driver.findElement(By.id("initialpaymentinput-2"));
        priceEnter2.sendKeys("00");
        String PriceIs2 = priceEnter.getAttribute("value");
        System.out.println("Price Entered is :" + PriceIs2);
        Thread.sleep(5000);

        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue.click();
        Thread.sleep(2000);

        System.out.println("----------------------------------");
    }
    @Test(priority = 11)
    public void CreditCardDetails () throws InterruptedException {

        WebElement CardNumber;
        CardNumber = driver.findElement(By.id("card-number"));
        CardNumber.sendKeys("4111111111111111");
        String cardNoIs = CardNumber.getAttribute("value");
        System.out.println("Card Number is :"+cardNoIs);

        WebElement cardfirstname = driver.findElement(By.id("card-first-name"));
        cardfirstname.sendKeys("Selenium");
        String cardFirstName = CardNumber.getAttribute("value");
        System.out.println("Card First Name "+cardFirstName);

        WebElement cardLastname = driver.findElement(By.id("card-last-name"));
        cardLastname.sendKeys("Data");
        String cardLName = cardLastname.getAttribute("value");
        System.out.println("Card Last Name :"+cardLName);

        WebElement cardexpiration = driver.findElement(By.id("card-expiration"));
        cardexpiration.sendKeys("0130");
        String CardExp = cardexpiration.getAttribute("value");
        System.out.println("Card Exp is  :"+ CardExp);

        WebElement Cvv = driver.findElement(By.id("card-cvv"));
        Cvv.sendKeys("008");
        String Cvvcard = Cvv.getAttribute("value");
        System.out.println("Card CVV is :"+ Cvvcard);

        WebElement checkedcheckmark = driver.findElement(By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label/span"));
        checkedcheckmark.click();

        WebElement SaveandContinue6 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue6.click();
        Thread.sleep(10000);

        System.out.println("----------------------------------");

    }
    @Test(priority = 12)
    public void submitRegistration() {
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

