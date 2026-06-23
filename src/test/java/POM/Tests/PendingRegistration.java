package POM.Tests;

import POM.base.BaseTest;
import POM.Pages.*;
import POM.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PendingRegistration extends BaseTest {

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

            agreement.Agreement();
            System.out.println("Pending Registration Created");

            driver.navigate().to("https://account.worldstrides.com");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

