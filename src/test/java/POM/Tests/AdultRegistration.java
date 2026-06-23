package POM.Tests;

import POM.base.BaseTest;
import POM.Pages.*;
import POM.utils.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdultRegistration extends BaseTest {

    @Test(dataProvider = "adultData", dataProviderClass = TestDataProvider.class)
    public void adultRegistrationFlow(
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

            traveller.selectAdult();
            traveller.enterAdultDetails(fn, ln, email, dob);

            traveller.enterAdultAccountDetails(username, password);
            traveller.enterEmergencyContact();

            agreement.Agreement();

            payment.selectPayInFullAndContinue();
            payment.completeCardPayment();

            register.submitRegistration();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")));

            if(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]")).isDisplayed())
            {
                System.out.println("Registration Successful");
                System.out.println("FULL FLOW SUCCESS");
            }
            else{
                Assert.fail("Registration Failed");
            }

        } catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
