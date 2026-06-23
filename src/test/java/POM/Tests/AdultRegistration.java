package POM.Tests;

import POM.base.BaseTest;
import POM.Pages.*;
import POM.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        } catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
