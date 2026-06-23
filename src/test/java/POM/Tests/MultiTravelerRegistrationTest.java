package POM.Tests;

import POM.Pages.*;
import POM.base.BaseTest;
import POM.utils.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultiTravelerRegistrationTest extends BaseTest {

    @Test(
            dataProvider = "multiTravelerData",
            dataProviderClass = TestDataProvider.class
    )
    public void multiTravelerRegistrationFlow(

            String studentFn,
            String studentLn,
            String studentEmail,
            String studentDob,

            String adultFn,
            String adultLn,
            String adultEmail,
            String adultDob,

            String responsibleFn,
            String responsibleLn,
            String responsibleEmail,

            String username,
            String password
    ) {

        SignupPage signup = new SignupPage(driver);
        TravellerPage traveller = new TravellerPage(driver);
        AgreementPage agreement = new AgreementPage(driver);

        try {

            System.out.println("Step 1: Signup");

            signup.clickSignup();
            signup.enterProgramCode("228614");
            signup.continueRegistration();

            Thread.sleep(3000);

            System.out.println("Step 2: Traveler 1 - Student");

            traveller.enterStudentTraveler1(
                    studentFn,
                    studentLn,
                    studentEmail,
                    studentDob
            );

            System.out.println("Step 3: Add Traveler");

            traveller.clickAddTraveler();

            Thread.sleep(3000);

            System.out.println("Step 4: Traveler 2 - Adult");

            traveller.enterAdultTraveler2(
                    adultFn,
                    adultLn,
                    adultEmail,
                    adultDob
            );

            System.out.println("Step 5: Responsible Adult");

            traveller.enterResponsibleAdult(
                    responsibleFn,
                    responsibleLn,
                    responsibleEmail,
                    username,
                    password
            );

            System.out.println("Step 6: Agreement");

            agreement.Agreement();

            System.out.println("Agreement completed successfully");

        } catch (Exception e) {

            e.printStackTrace();
            Assert.fail("Multi Traveler Registration Failed : "
                    + e.getMessage());
        }

        PaymentPage payment = new PaymentPage(driver);
        RegistrationPage register = new RegistrationPage(driver);

        System.out.println("Step 7: Payment");

        payment.payMonthlyWithCard();

        System.out.println("Step 8: Submit");


        register.submitRegistration();

        System.out.println("Step 9: Verify Registration Success");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
                )
        );

        if(driver.findElement(
                By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")
        ).isDisplayed()){

            System.out.println("Registration Successful");
            System.out.println("FULL FLOW SUCCESS");

        }
        else{

            Assert.fail("Registration Failed");
        }

    }
}