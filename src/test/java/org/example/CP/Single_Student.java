package org.example.CP;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class Single_Student {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://account.worldstrides.com/Login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyLogoPresence() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img"));
        Assert.assertTrue(element.isDisplayed(), "World Strides Logo is not present on the page.");
        System.out.println("World Strides Logo is present on the page.");
    }

    @Test(priority = 2)

    public void testSignUpFlow() throws InterruptedException {
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
    }

    @Test(priority = 3)
    public void selectParticipantDetails() {
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

    }

    @Test(priority = 4)
    public void enterStudentPersonalDetails() {
        WebElement Studentname = driver.findElement(By.id("firstnameTraveller1"));
        Studentname.sendKeys("December23rd2025");
        String enteredName = Studentname.getAttribute("value");
        System.out.println("Student First name : " + enteredName);

        WebElement StudentLastname = driver.findElement(By.id("lastNameTraveller1"));
        StudentLastname.sendKeys("Test2");
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
        Dob.sendKeys("01092010");
    }

    @Test(priority = 5)
    public void selectGuardianDetails() throws InterruptedException {
        WebElement GuardianRealtion = driver.findElement(By.xpath("//*[@id=\"relationshipGuardian\"]/option[3]"));
        GuardianRealtion.click();
        String GuardianRealtion1 = GuardianRealtion.getAttribute("value");
        System.out.println("Guardian Relation : " + GuardianRealtion1);

        WebElement GuardianCountry = driver.findElement(By.xpath("//*[@id=\"countryGuardian\"]/option[2]"));
        GuardianCountry.click();
        String GuardianCountry1 = GuardianCountry.getAttribute("value");
        System.out.println("Guardian Country : " + GuardianCountry1);

        WebElement GuardianFirst = driver.findElement(By.id("firstnameGaurdian"));
        GuardianFirst.sendKeys("Selenium");

        WebElement GuardianLast = driver.findElement(By.id("lastnameGaurdian"));
        GuardianLast.sendKeys("Test");

        WebElement Address = driver.findElement(By.id("addressGaurdian"));
        Address.sendKeys("1-142");

        WebElement City = driver.findElement(By.id("cityGaurdian"));
        String Cityname = City.getAttribute("value");
        System.out.println("City name is "+ Cityname);
        Thread.sleep(1000);

        WebElement State = driver.findElement(By.xpath("//*[@id=\"stateGuardian\"]/option[36]"));
        String StateName = State.getAttribute("value");
        System.out.println("State is " + StateName);
        Thread.sleep(1000);

        WebElement Zipcode = driver.findElement(By.id("zipGaurdian"));
        Zipcode.sendKeys("80010");
        Thread.sleep(1000);

        WebElement ParentEmail = driver.findElement(By.id("emailGaurdian"));
        ParentEmail.sendKeys("Test@Emailtest.com");
        Thread.sleep(1000);

        WebElement ParentRetype = driver.findElement(By.id("retypeEmailGaurdian"));
        ParentRetype.sendKeys("Test@Emailtest.com");
        Thread.sleep(1000);

        WebElement MobileNumCountry = driver.findElement(By.xpath("//*[@id=\"1countryCodeGuardian\"]/option[2]"));
        MobileNumCountry.click();
        String MObile = MobileNumCountry.getAttribute("value");
        System.out.println("Mobile Country is " + MObile);
        Thread.sleep(1000);

        WebElement Mobilenumber = driver.findElement(By.id("1phoneGaurdian"));
        Mobilenumber.sendKeys("8908908909");
        Thread.sleep(1000);

    }

    @Test(priority = 6)
    public void AccountDetails() throws InterruptedException {
        WebElement Username = driver.findElement(By.id("usernameGaurdian"));
        Username.sendKeys("December23rd2025Script1");
        String UsernameDetails = Username.getAttribute("value");
        System.out.println(UsernameDetails);


        WebElement Password = driver.findElement(By.id("passwordGaurdian"));
        Password.sendKeys("Amar@0601");
        String PasswordIs = Password.getAttribute("value");
        System.out.println(PasswordIs);


        WebElement Retype = driver.findElement(By.id("retypePasswordGaurdian"));
        Retype.sendKeys("Amar@0601");

        WebElement Checkbox = driver.findElement(By.xpath("//*[@id=\"parent-acc-form\"]/div[2]/div[2]/label"));
        Checkbox.click();

        WebElement SaveandContine = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContine.click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
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
        // Wait before moving to the next operation
        Thread.sleep(5000);


                        }
                    }
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Double Page Not found");
        }
    }


    @Test(priority = 8)
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
    @Test(priority = 10)
    public void takeFullPageScreenshot() {
        try {
            EdgeDriver chromeDriver = (EdgeDriver) driver;
            DevTools devTools = chromeDriver.getDevTools();
            devTools.createSession();

            String base64Image = devTools.send(
                    Page.captureScreenshot(
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(true),
                            Optional.empty()
                    )
            );

            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            FileOutputStream fos = new FileOutputStream("D:\\SeleniumProject\\CP_Automation_Results\\23rdDec2025testcase1.png");
            fos.write(imageBytes);
            fos.close();

            System.out.println("Full-page screenshot saved successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





