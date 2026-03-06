import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\amartejac\\Downloads\\edgedriver_win64 (7)\\msedgedriver.exe");

        // Initialize the Edge WebDriver
        WebDriver driver = new EdgeDriver();
/*
        EdgeOptions edgeOptions = new EdgeOptions();

        // Set mobile emulation settings for iPhone SE
        edgeOptions.setCapability("browserName", "MicrosoftEdge");
        edgeOptions.setCapability("deviceName", "iPhone SE");
        edgeOptions.setCapability("platformName", "iOS");
        edgeOptions.setCapability("platformVersion", "14.0");

        Dimension dimension = new Dimension(640, 1136);
        driver.manage().window().setSize(dimension);

*/

        driver.get("https://account.worldstrides.com/Login");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/div/div/div/span/img"));
        if (element.isDisplayed()) {
            System.out.println(" World Strides Logo is present on the page. ");
        } else {
            System.out.println(" World Strides Logo is not present on the page. ");
        }

        WebElement signup = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/a"));
        signup.click();
        WebElement ProgramRegistration = driver.findElement(By.id("registration-program"));
        ProgramRegistration.sendKeys("110765");
        WebElement Continuereg = driver.findElement(By.xpath("//*[@id=\"program-registration-form\"]/div[3]/div/button"));
        Continuereg.click();
        Thread.sleep(4000);

        //1st page
        //Selecting as student
        WebElement DropDown = driver.findElement(By.id("tavellingAs1"));
        System.out.println("Listed DropDown Items are");
        Select dropOptions = new Select(DropDown);
        List<WebElement> dropdownoptions = dropOptions.getOptions();
        for(WebElement options : dropdownoptions){

            System.out.println(options.getText());
        }
        WebElement Select1 = driver.findElement(By.xpath("//*[@id=\"tavellingAs1\"]/option[2]"));
        Select1.click();
        if(Select1.isDisplayed()) {
            System.out.println("Student Functionality is working");
        }
        else{
            System.out.println("Student Functionality is not working");
        }

        //Selecting grade for student

        WebElement grade11 = driver.findElement(By.xpath("//*[@id=\"currentGrade1\"]/option[3]"));
        grade11.click();
        if(grade11.isDisplayed()) {
            System.out.println("grade is working");
        }
        else{
            System.out.println("Grade is not working");
        }

        //Selecting Travller1 interest for only student

        WebElement Studentinterest = driver.findElement(By.xpath("//*[@id=\"studentInterest1\"]/option[4]"));
        Studentinterest.click();

        //Selecting Travller1 country

        WebElement Country = driver.findElement(By.xpath("//*[@id=\"countryTraveler1\"]/option[2]"));
        Country.click();

        //Entering Travller1 First name
        WebElement Studentname = driver.findElement(By.id("firstnameTraveller1"));
        Studentname.sendKeys("Amar");

        //Entering traveller1 last name

        WebElement StudentLastname = driver.findElement(By.id("lastNameTraveller1"));
        StudentLastname.sendKeys("March11th2025");
        //Enter Travaller1 Email

        WebElement StudentEmail = driver.findElement(By.id("emailTraveler1"));
        StudentEmail.sendKeys("SeleniumMarch11th2025test@gmail.com");

        //Confirm the Email of Traveller1
        WebElement StudentEmailRetype = driver.findElement(By.id("retypeEmailTraveler1"));
        StudentEmailRetype.sendKeys("SeleniumMarch11th2025test@gmail.com");

        //Confirm the Traveller1 Gender
        WebElement Traveller1Gender = driver.findElement(By.xpath("//*[@id=\"genderTraveler1\"]/option[2]"));
        Traveller1Gender.click();
        if(Traveller1Gender.isSelected()) {
            System.out.println("Selected");
        }
        else {
            System.out.println("Functionality is missing ");
        }
        WebElement DOB = driver.findElement(By.id("bdayTraveler1"));
        DOB.sendKeys("09022009");

        WebElement AddTraveller2 = driver.findElement(By.xpath("//*[@id=\"traveler-1\"]/div/div[2]/div[3]/div[2]/div/span/button"));
        AddTraveller2.click();
        WebElement Select2 = driver.findElement(By.xpath("//*[@id=\"tavellingAs2\"]/option[3]"));
        Select2.click();
        WebElement Traveller2Country = driver.findElement(By.xpath("//*[@id=\"countryTraveler2\"]/option[2]"));
        Traveller2Country.click();
        WebElement Travller2Firstname = driver.findElement(By.id("firstnameTraveller2"));
        Travller2Firstname.sendKeys("Amar");
        WebElement Traveller2lastname = driver.findElement(By.id("lastNameTraveller2"));
        Traveller2lastname.sendKeys("Adult4March11th2025");
        WebElement Traveller2Email = driver .findElement(By.id("emailTraveler2"));
        Traveller2Email.sendKeys("SeleniumAmarMarch11th2025test@gmail.com");
        WebElement Traveller2emailretype = driver.findElement(By.id("retypeEmailTraveler2"));
        Traveller2emailretype.sendKeys("SeleniumAmarMarch11th2025test@gmail.com");
        WebElement Traveller2Gender = driver.findElement(By.xpath("//*[@id=\"genderTraveler2\"]/option[2]"));
        Traveller2Gender.click();
        WebElement Traveller2dob = driver.findElement(By.id("bdayTraveler2"));
        Traveller2dob.sendKeys("09021999");

       /*

        //Selecting Guardian Relation
	    WebElement GuardianRealtion = driver.findElement(By.xpath("//*[@id=\"relationshipGuardian\"]/option[3]"));
        GuardianRealtion.click();

      //Selecting Guardian Country
        WebElement GuardianCountry = driver.findElement(By.xpath("//*[@id=\"countryGuardian\"]/option[2]"));
        GuardianCountry.click();

        //Entering First name for Guardian
        WebElement firstnameGaurdian = driver.findElement(By.id("firstnameGaurdian"));
        firstnameGaurdian.sendKeys("Dummy");

        ////Entering Last name for Guardian
        WebElement lastnameGaurdian = driver.findElement(By.id("lastnameGaurdian"));
        lastnameGaurdian.sendKeys("Father");

        //Entering address for Guardian
        WebElement addressGaurdian = driver.findElement(By.id("addressGaurdian"));
        addressGaurdian.sendKeys("1-142,new york street");

        //Entering City for guardian

        WebElement cityGaurdian = driver.findElement(By.id("cityGaurdian"));
        cityGaurdian.sendKeys("New york");

        //Entering state for guardian
        WebElement stateGuardian = driver.findElement(By.id("cityGaurdian"));
        stateGuardian.sendKeys("New york");

        //Entering zip code for guardian according to city and state
        WebElement zipGaurdian = driver.findElement(By.id("zipGaurdian"));
        zipGaurdian.sendKeys("10001");

        //Entering Guardian Email
        WebElement emailGaurdian = driver.findElement(By.id("emailGaurdian"));
        emailGaurdian.sendKeys("guardian@gmail.com");

        //Entering guardian Confirmation mail

        WebElement retypeEmailGaurdian = driver.findElement(By.id("retypeEmailGaurdian"));
        retypeEmailGaurdian.sendKeys("guardian@gmail.com");

        //Selecting country code for Guardian Mobile
        WebElement country code = driver.findElement(By.xpath("//*[@id=\"1countryCodeGuardian\"]/option[2]"));
        Countrycode.click();

        //Entering the guardian Mobile number
        WebElement phoneGaurdian = driver.findElement(By.id("1phoneGaurdian"));
        phoneGaurdian.sendKeys("6786786789");

        //Selecting the Mobile type for Guardian
        WebElement MobileType = driver.findElement(By.xpath("//*[@id=\"1phoneTypeGuardian\"]/option[1]"));
        MobileType.click();

         //Account details i.e, user_name
        WebElement usernameGaurdian = driver.findElement(By.id("usernameGaurdian"));
        usernameGaurdian.sendKeys("Dummy21sttest7Sep@gmail.com");

        //Account details i.e, password
        WebElement passwordGaurdian = driver.findElement(By.id("passwordGaurdian"));
        passwordGaurdian.sendKeys("Amartej@0601");
       //Account details i.e, retype password

        WebElement retypePasswordGaurdian = driver.findElement(By.id("retypePasswordGaurdian"));
        retypePasswordGaurdian.sendKeys("Amartej@0601");

       //Checking the check box for serving the account as emergency contact
        WebElement serverEmergencyGaurdian = driver.findElement(By.id("serverEmergencyGaurdian"));
        serverEmergencyGaurdian.click();
        Thread.sleep(3000);

        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContinue.click();
        Thread.sleep(2000); */



        //For Registering Multiple Travellers
        //Responsible Party Details

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

        WebElement City = driver.findElement(By.id("cityResponsible"));
        City.sendKeys("New York");

        WebElement City2 = driver.findElement(By.id("stateResponsible"));
        Select CityName = new Select(City2);
        CityName.selectByIndex(35);
        String SelectedOption = CityName.getFirstSelectedOption().getText();
        System.out.println("Selected City = "+SelectedOption);

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

        WebElement usernameResponsible = driver.findElement(By.id("usernameResponsible"));
        usernameResponsible.sendKeys("ProdMarch11th2025@gmail.com");

        WebElement passwordResponsible = driver.findElement(By.id("passwordResponsible"));
        passwordResponsible.sendKeys("Amar@0601");

        WebElement retypePasswordResponsible = driver.findElement(By.id("retypePasswordResponsible"));
        retypePasswordResponsible.sendKeys("Amar@0601");
        Thread.sleep(5000);

        WebElement serveEmergencyResponsible = driver.findElement(By.id("serveEmergencyResponsible"));
        serveEmergencyResponsible.click();


        WebElement SaveandContinue = driver.findElement(By.xpath("//*[@id=\"travellerForm\"]/div[2]/div/div/div/button"));
        SaveandContinue.click();
        Thread.sleep(6000);

        //2nd Page
        //Agreement section
        // Single page for Agreement
        WebElement AgreementAgree = null;
        try {
            AgreementAgree = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[6]/div/div/div[1]/div/div/label")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Single Agreement page not found");
        }

        // If the button is found, click on it
        if (AgreementAgree != null) {
            AgreementAgree.click();
            System.out.println("Single Agreement page Founded and Clicked");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }

        //Double page agreement
        WebElement AgreementAgree1 = null;
        try {
            AgreementAgree1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[3]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Agreement1 slider Button not found. Ignoring...");
        }

        // If the button is found, click on it
        if (AgreementAgree1 != null) {
            AgreementAgree1.click();
            System.out.println("Agreement 1 Button clicked!");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }                                  //*[@id="content"]/div/div/section/div[1]/div[3]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span


        WebElement AgreementAgree2 = null;
        try {
            AgreementAgree2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[4]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Agreement2 Button not found. Ignoring...");
        }

        // If the button is found, click on it
        if (AgreementAgree2 != null) {
            AgreementAgree2.click();
            System.out.println("Agreement 2 Button clicked!");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }
        WebElement AgreementAgree3Single = null;
        try {
            AgreementAgree3Single = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[5]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Agreement2 Button not found. Ignoring...");
        }

        // If the button is found, click on it
        if (AgreementAgree3Single != null) {
            AgreementAgree3Single.click();
            System.out.println("Agreement 2 Button clicked!");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }

         // Check if a particular button is present on the page
        // Check if the button exists

        WebElement SaveandContinue1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]"));
        SaveandContinue1.click();
        Thread.sleep(5000);

        WebElement AgreementAgree3 = null;
        try {
            AgreementAgree3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Agreement 3 Button not found. Ignoring...");
        }

        // If the button is found, click on it
        if (AgreementAgree3 != null) {
            AgreementAgree3.click();
            System.out.println("Agreement 3 Button clicked!");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }

        /*
        //*[@id="content"]/div/div/section/div[1]/div[5]/div/div[3]/div[2]/div/div/div/div/div[2]/div/label/span


        //WebElement AgreeCondit = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[1]/div[6]/div/div/div[1]/div/div/label"));
        //AgreeCondit.click();
*/

        //Saving and Continue the
        WebElement AgreementSave = null;
        try {
            AgreementSave = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/section/div[2]/div/div/div[1]/button[2]")); // Replace "your_button_id" with the actual ID of the button
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If the button is not found, ignore and continue with the flow
            System.out.println("Agreement 3 save  Button not found. Ignoring...");
        }

        // If the button is found, click on it
        if (AgreementSave != null) {
            AgreementSave.click();
            System.out.println("Agreement 3 save Button clicked!");
            Thread.sleep(5000);
            // Continue with the flow after clicking the button
        }

/*
        //3rd Page
        //Payment in Full
        WebElement lblPayInFull = driver.findElement(By.id("lblPayInFull"));
        lblPayInFull.click();
        Thread.sleep(4000);

        WebElement CotinuePayment = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        CotinuePayment.click();
        Thread.sleep(4000);


        //By Checking Account
        WebElement FirstnameBank = driver.findElement(By.id("card-name"));
        FirstnameBank.sendKeys("Wells Fargo");

        WebElement cardrouting = driver.findElement(By.id("card-routing"));
        cardrouting.sendKeys("051400549");

        WebElement cardaccount = driver.findElement(By.id("card-account"));
        cardaccount.sendKeys("123456");

        WebElement cardretypeacount = driver.findElement(By.id("card-retype-acount"));
        cardretypeacount.sendKeys("123456");

        WebElement AccountFirstname = driver.findElement(By.id("card-holders-first-name"));
        AccountFirstname.sendKeys("Selenium");

        WebElement Accountlastname = driver.findElement(By.id("card-holders-last-name"));
        Accountlastname.sendKeys("Data");

        WebElement SaveandContinue5 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue5.click();
        Thread.sleep(10000);
*/
//Monthly Payment
        WebElement PayMonthly = driver.findElement(By.id("lblPayInMonthly"));
        PayMonthly.click();
        Thread.sleep(4000);

        WebElement PayMonthlyEzpay = driver.findElement(By.id("lblezPay"));
        PayMonthlyEzpay.click();
        Thread.sleep(4000);

        WebElement Credit = driver.findElement(By.id("lblCardPayment_ACH"));
        Credit.click();
        Thread.sleep(4000);

        WebElement SaveCredit = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveCredit.click();
        Thread.sleep(4000);

        WebElement cardnumber = driver.findElement(By.id("card-number"));
        cardnumber.sendKeys("4111111111111111");

        WebElement cardfirstname = driver.findElement(By.id("card-first-name"));
        cardfirstname.sendKeys("Selenium");

        WebElement cardLastname = driver.findElement(By.id("card-last-name"));
        cardLastname.sendKeys("Data");

        WebElement cardexpiration = driver.findElement(By.id("card-expiration"));
        cardexpiration.sendKeys("0129");

        WebElement Cvv = driver.findElement(By.id("card-cvv"));
        Cvv.sendKeys("009");
        WebElement checkedcheckmark = driver.findElement(By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label/span"));
        checkedcheckmark.click();

        WebElement SaveandContinue6 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]"));
        SaveandContinue6.click();
        Thread.sleep(10000);


        //4th Page
        //checking the billing address same as Registration
        // Capture full-page screenshot
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Set timeout as needed
                .takeScreenshot(driver);

        // Define the path where you want to save the screenshot
        String screenshotPath = "D:\\CP\\March11th2025test(1).png";

        // Save the screenshot to the specified path
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));
            System.out.println("Full page screenshot saved to: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Submitting Registration
        WebElement SubmitRegistration = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[3]/div/div/section/div[2]/button[4]"));
        SubmitRegistration.click();
        Thread.sleep(40000);

        WebElement Congratulations = null;
        try {
            Congratulations = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")); // Replace with your XPath
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Element not found
        }
        Thread.sleep(30000);

        // Print "success" or "failed" based on the presence of the element
        if (Congratulations != null) {
            System.out.println("Registration Success");
        } else {
            System.out.println("Registration Failed");
            Screenshot screenshot2 = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Set timeout as needed
                    .takeScreenshot(driver);

            // Define the path where you want to save the screenshot
            String screenshotPath2 = "D:\\CP\\March11th2025test(2).png";

            // Save the screenshot to the specified path
            try {
                ImageIO.write(screenshot2.getImage(), "PNG", new File(screenshotPath2));
                System.out.println("Full page screenshot saved to: " + screenshotPath2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

