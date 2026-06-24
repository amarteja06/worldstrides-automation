package POM.Tests;

import POM.base.BaseTest;
import POM.Pages.*;
import POM.utils.TestDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class StudentRegistrationTest extends BaseTest {

    @Test(dataProvider = "studentData", dataProviderClass = TestDataProvider.class)
    public void studentRegistrationFlow(
            String fn,
            String ln,
            String email,
            String dob,
            String username,
            String password
    ) {

        SignupPage signup = new SignupPage(driver);
        TravellerPage traveller = new TravellerPage(driver);
        AgreementPage agreement = new AgreementPage(driver);
        PaymentPage payment = new PaymentPage(driver);
        RegistrationPage register = new RegistrationPage(driver);

        try {

            signup.clickSignup();
            signup.enterProgramCode("228614");
            signup.continueRegistration();

            traveller.selectStudent();
            traveller.selectGrade();
            traveller.selectInterest();
            traveller.selectCountry();

            traveller.enterStudentDetails(fn, ln, email, dob);

            traveller.enterGuardianDetails();

            traveller.createAccount(username, password);
            System.out.println();

            agreement.Agreement();
            
            payment.payInFullWithBank();

            register.submitRegistration();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
                    )
            );

            if(driver.findElement(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")).isDisplayed()){

                System.out.println("Registration Successful");
                System.out.println("FULL FLOW SUCCESS");

                File screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                File destination =
                        new File("screenshots/congratulations.png");

                destination.getParentFile().mkdirs();

                FileUtils.copyFile(screenshot, destination);

                System.out.println("Screenshot captured successfully");
            }
            else{

                Assert.fail("Registration Failed");
            }

        }
        catch (Exception e){

            e.printStackTrace();

            try {

                File screenshot = ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(
                        screenshot,
                        new File("screenshots/failure.png")
                );

            } catch (Exception ex){
                ex.printStackTrace();
            }

            Assert.fail("Testing Failure Email");

        }
    }
}
