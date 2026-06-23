package POM.Pages;

import POM.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TravellerPage {

    WebDriver driver;
    WaitUtils wait;

    public TravellerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    // -------- STUDENT LOCATORS --------
    By travellingAs = By.id("tavellingAs1");
    By grade = By.id("currentGrade1");
    By interest = By.id("studentInterest1");
    By country = By.id("countryTraveler1");

    By firstName = By.id("firstnameTraveller1");
    By lastName = By.id("lastNameTraveller1");
    By email = By.id("emailTraveler1");
    By retypeEmail = By.id("retypeEmailTraveler1");
    By gender = By.id("genderTraveler1");
    By dob = By.id("bdayTraveler1");

    // -------- GUARDIAN LOCATORS --------
    By guardianRelation = By.id("relationshipGuardian");
    By guardianCountry = By.id("countryGuardian");
    By guardianFirst = By.id("firstnameGaurdian");
    By guardianLast = By.id("lastnameGaurdian");
    By guardianAddress = By.id("addressGaurdian");
    By guardianCity = By.id("cityGaurdian");
    By guardianState = By.id("stateGuardian");
    By guardianZip = By.id("zipGaurdian");
    By guardianEmail = By.id("emailGaurdian");
    By guardianEmailRetype = By.id("retypeEmailGaurdian");
    By guardianCountryCode = By.id("1countryCodeGuardian");
    By guardianPhone = By.id("1phoneGaurdian");

    // -------- ACCOUNT LOCATORS --------
    By username = By.id("usernameGaurdian");
    By password = By.id("passwordGaurdian");
    By retypePassword = By.id("retypePasswordGaurdian");
    By terms = By.xpath("//*[@id=\"parent-acc-form\"]/div[2]/div[2]/label");
    By saveContinue = By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button");

    // -------- METHODS --------

    public void selectStudent() {
        new Select(wait.waitForVisibility(travellingAs)).selectByIndex(1);
    }

    public void selectGrade() {
        new Select(wait.waitForVisibility(grade)).selectByIndex(2);
    }

    public void selectInterest() {
        new Select(wait.waitForVisibility(interest)).selectByIndex(3);
    }

    public void selectCountry() {
        new Select(wait.waitForVisibility(country)).selectByIndex(1);
    }

    public void enterStudentDetails(String fn, String ln, String em, String dobValue) {

        wait.waitForVisibility(firstName).sendKeys(fn);
        wait.waitForVisibility(lastName).sendKeys(ln);
        wait.waitForVisibility(email).sendKeys(em);
        wait.waitForVisibility(retypeEmail).sendKeys(em);

        new Select(wait.waitForVisibility(gender)).selectByIndex(1);

        wait.waitForVisibility(dob).sendKeys(dobValue);
    }

    public void enterGuardianDetails() {

        new Select(wait.waitForVisibility(guardianRelation)).selectByIndex(2);
        new Select(wait.waitForVisibility(guardianCountry)).selectByIndex(1);

        wait.waitForVisibility(guardianFirst).sendKeys("Selenium");
        wait.waitForVisibility(guardianLast).sendKeys("Test");
        wait.waitForVisibility(guardianAddress).sendKeys("1-142");
        wait.waitForVisibility(guardianCity).sendKeys("Denver");

        new Select(wait.waitForVisibility(guardianState)).selectByIndex(35);

        wait.waitForVisibility(guardianZip).sendKeys("80010");
        wait.waitForVisibility(guardianEmail).sendKeys("test@email.com");
        wait.waitForVisibility(guardianEmailRetype).sendKeys("test@email.com");

        new Select(wait.waitForVisibility(guardianCountryCode)).selectByIndex(1);

        wait.waitForVisibility(guardianPhone).sendKeys("8908908909");
    }

    public void createAccount(String user, String pass) {

        wait.waitForVisibility(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(retypePassword).sendKeys(pass);

        driver.findElement(terms).click();
        driver.findElement(saveContinue).click();

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }

    // SELECT ADULT
    public void selectAdult() {
        new Select(wait.waitForVisibility(By.id("tavellingAs1")))
                .selectByIndex(2);   // Adult
    }

    // BASIC TRAVELLER INFO
    public void enterAdultDetails(String fn, String ln, String email, String dob) {

        driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]")).click();

        wait.waitForVisibility(By.id("firstnameTraveller1")).sendKeys(fn);
        driver.findElement(By.id("lastNameTraveller1")).sendKeys(ln);

        driver.findElement(By.id("emailTraveler1")).sendKeys(email);
        driver.findElement(By.id("retypeEmailTraveler1")).sendKeys(email);

        wait.waitForClickable(By.xpath("//*[@id=\"genderTraveler1\"]/option[3]")).click();

        driver.findElement(By.id("bdayTraveler1")).sendKeys(dob);
    }

    // -------- ADULT ACCOUNT --------
    public void enterAdultAccountDetails(String user, String pass) {

        driver.findElement(By.xpath("//*[@id=\"traveler-1\"]/div/div[2]/div[3]/div[1]/div/div/div/label")).click();

        driver.findElement(By.id("address1Traveler1")).sendKeys("New Street no 4");
        driver.findElement(By.id("zipTraveler1")).sendKeys("80010");

        new Select(driver.findElement(By.id("1countryCodeTraveler1")))
                .selectByVisibleText("USA(+1)");

        driver.findElement(By.id("1phoneTraveler1")).sendKeys("9989998978");

        driver.findElement(By.id("usernameTraveler1")).sendKeys(user);
        driver.findElement(By.id("passwordTraveler1")).sendKeys(pass);
        driver.findElement(By.id("retypePasswordTraveler1")).sendKeys(pass);
    }


    // -------- EMERGENCY CONTACT --------
    public void enterEmergencyContact() {

        new Select(driver.findElement(By.id("relationshipEmergencyContact")))
                .selectByVisibleText("Mother");

        driver.findElement(By.id("firstnameEmergencyContact")).sendKeys("Selenium");
        driver.findElement(By.id("lastnameEmergencyContact")).sendKeys("Selenium");

        driver.findElement(By.id("emailEmergencyContact")).sendKeys("test@mail.com");
        driver.findElement(By.id("retypeEmailEmergencyContact")).sendKeys("test@mail.com");

        new Select(driver.findElement(By.id("1countryCodeEmergencyContact")))
                .selectByVisibleText("USA(+1)");

        driver.findElement(By.id("1phoneEmergencyContact")).sendKeys("7897897898");

        driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button")).click();

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    public void enterStudentTraveler1(
            String fn,
            String ln,
            String email,
            String dob){

        selectStudent();
        selectGrade();
        selectInterest();
        selectCountry();

        enterStudentDetails(fn, ln, email, dob);
    }
    public void enterAdultTraveler2(
            String fn,
            String ln,
            String email,
            String dob){

        new Select(wait.waitForVisibility(
                By.id("tavellingAs2")))
                .selectByIndex(2);

        new Select(wait.waitForVisibility(
                By.id("countryTraveler2")))
                .selectByIndex(1);

        wait.waitForVisibility(
                        By.id("firstnameTraveller2"))
                .sendKeys(fn);

        driver.findElement(
                        By.id("lastNameTraveller2"))
                .sendKeys(ln);

        driver.findElement(
                        By.id("emailTraveler2"))
                .sendKeys(email);

        driver.findElement(
                        By.id("retypeEmailTraveler2"))
                .sendKeys(email);

        new Select(driver.findElement(
                By.id("genderTraveler2")))
                .selectByIndex(1);

        driver.findElement(
                        By.id("bdayTraveler2"))
                .sendKeys(dob);
    }
    public void enterResponsibleAdult(
            String fn,
            String ln,
            String email,
            String username,
            String password){

        new Select(wait.waitForVisibility(
                By.id("relationshipResponsible")))
                .selectByIndex(2);

        new Select(driver.findElement(
                By.id("relationshipResponsible2")))
                .selectByIndex(2);

        new Select(driver.findElement(
                By.id("countryResponsible")))
                .selectByIndex(1);

        driver.findElement(
                        By.id("firstnameResponsible"))
                .sendKeys(fn);

        driver.findElement(
                        By.id("lastnameResponsible"))
                .sendKeys(ln);

        driver.findElement(
                        By.id("addressResponsible"))
                .sendKeys("1-142 New York");

        driver.findElement(
                        By.id("zipResponsible"))
                .sendKeys("10010");

        driver.findElement(
                        By.id("emailResponsible"))
                .sendKeys(email);

        driver.findElement(
                        By.id("retypeEmailResponsible"))
                .sendKeys(email);

        new Select(driver.findElement(
                By.id("1countryCodeResponsible")))
                .selectByIndex(1);

        driver.findElement(
                        By.id("1phoneResponsible"))
                .sendKeys("6786786789");

        driver.findElement(
                        By.id("usernameResponsible"))
                .sendKeys(username);

        driver.findElement(
                        By.id("passwordResponsible"))
                .sendKeys(password);

        driver.findElement(
                        By.id("retypePasswordResponsible"))
                .sendKeys(password);

        driver.findElement(
                        By.id("serveEmergencyResponsible"))
                .click();

        driver.findElement(
                        By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"))
                .click();

        try {
            Thread.sleep(4000);
        } catch (Exception e) {}
    }
    By addTraveler = By.className("btn-Add-traveller");

    public void clickAddTraveler(){

        wait.waitForClickable(addTraveler).click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
}

