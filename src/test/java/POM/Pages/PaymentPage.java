package POM.Pages;

import POM.utils.WaitUtils;
import org.openqa.selenium.*;

public class PaymentPage {

    WebDriver driver;
    WaitUtils wait;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void payInFullWithBank(){

        try{

            // STEP 1: Pay in Full
            WebElement payInFull = wait.waitForClickable(By.id("lblPayInFull"));
            payInFull.click();

            // STEP 2: Save & Continue
            WebElement save1 = wait.waitForClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            );

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", save1);
            save1.click();

            //  IMPORTANT WAIT (same as your working code)
            Thread.sleep(4000);

            // STEP 3: Select Electronic Check
            WebElement checkingAcc = wait.waitForClickable(By.id("lblElectronicCheck"));
            checkingAcc.click();

            // STEP 4: Enter Bank Details
            wait.waitForVisibility(By.id("card-name")).sendKeys("Wells Fargo");
            driver.findElement(By.id("card-routing")).sendKeys("051400549");
            driver.findElement(By.id("card-account")).sendKeys("123456");
            driver.findElement(By.id("card-retype-acount")).sendKeys("123456");
            driver.findElement(By.id("card-holders-first-name")).sendKeys("Test");
            driver.findElement(By.id("card-holders-last-name")).sendKeys("Amar");

            // STEP 5: Final Save
            WebElement save2 = wait.waitForClickable(
                    By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")
            );

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", save2);
            save2.click();

            // 🔥 FINAL WAIT BEFORE SUBMIT PAGE
            Thread.sleep(5000);

            System.out.println("Payment completed successfully");

        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Payment failed");
        }
    }
    public void completeCardPayment(){

        WebElement card = wait.waitForClickable(By.id("listCardPayment"));
        card.click();

        try { Thread.sleep(2000); } catch (Exception e) {}

        wait.waitForVisibility(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-first-name")).sendKeys("Test");
        driver.findElement(By.id("card-last-name")).sendKeys("Test");
        driver.findElement(By.id("card-expiration")).sendKeys("01/30");
        driver.findElement(By.id("card-cvv")).sendKeys("909");

        driver.findElement(By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label")).click();

        WebElement save = wait.waitForClickable(
                By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")
        );

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", save);
        save.click();

        try { Thread.sleep(5000); } catch (Exception e) {}
    }
    public void selectPayInFullAndContinue(){

        WebElement payInFull = wait.waitForClickable(By.id("lblPayInFull"));
        payInFull.click();

        WebElement save = wait.waitForClickable(
                By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
        );                             //*[@id="content"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", save);
        save.click();

        try { Thread.sleep(4000); } catch (Exception e) {}
    }
    public void payMonthlyWithCard(){

        try{

            // STEP 1 - Monthly Payment

            WebElement payMonthly =
                    wait.waitForClickable(By.id("lblPayInMonthly"));

            payMonthly.click();

            Thread.sleep(2000);

            // STEP 2 - EZ Pay (default selected)

            WebElement ezPay =
                    wait.waitForVisibility(By.id("ezpayOption"));

            Thread.sleep(2000);

            // STEP 3 - Card Option

            WebElement card =
                    wait.waitForClickable(By.id("listCardPayment_ACH"));

            card.click();

            Thread.sleep(2000);

            // STEP 4 - Initial Amount

            wait.waitForVisibility(By.id("initialpaymentinput-1"))
                    .sendKeys("00");

            wait.waitForVisibility(By.id("initialpaymentinput-2"))
                    .sendKeys("00");

            Thread.sleep(3000);

            // STEP 5 - Save & Continue

            WebElement save1 =
                    wait.waitForClickable(
                            By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[1]/div/div/section/div/div/div[1]/div[2]/div/div/button[2]")
                    );

            ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].scrollIntoView(true);", save1);

            save1.click();

            Thread.sleep(3000);

            // STEP 6 - Card Details

            wait.waitForVisibility(By.id("card-number"))
                    .sendKeys("4111111111111111");

            driver.findElement(By.id("card-first-name"))
                    .sendKeys("Selenium");

            driver.findElement(By.id("card-last-name"))
                    .sendKeys("Data");

            driver.findElement(By.id("card-expiration"))
                    .sendKeys("0130");

            driver.findElement(By.id("card-cvv"))
                    .sendKeys("008");

            // STEP 7 - Checkbox

            driver.findElement(
                    By.xpath("//*[@id=\"card-details-form\"]/div[3]/div[2]/div[1]/div[2]/span/label/span")
            ).click();

            // STEP 8 - Final Save

            WebElement save2 =
                    wait.waitForClickable(
                            By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/div[2]/div[1]/div/section/div/div/div[1]/div[2]/div/div/button[2]")
                    );

            ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].scrollIntoView(true);", save2);

            save2.click();

            Thread.sleep(5000);

            System.out.println("Monthly Card Payment completed");

        }
        catch(Exception e){

            e.printStackTrace();
            throw new RuntimeException("Monthly Card Payment failed");
        }
    }
}