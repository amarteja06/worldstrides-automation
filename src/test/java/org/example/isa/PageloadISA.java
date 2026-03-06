

package org.example.isa;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Arrays;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PageloadISA {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        // URL to be tested
        List<String> urls = Arrays.asList(
                "https://www.studiesabroad.com",
                "https://www.studiesabroad.com/about-isa/who-we-are#OurValues",
                "https://www.studiesabroad.com/about-isa/divisions/strategic-programs" ,
                "https://www.studiesabroad.com/about-isa/divisions/first-year-abroad" ,
                "https://www.studiesabroad.com/about-isa/who-we-are/our-people",
                "https://www.studiesabroad.com/about-isa/health-and-safety/staff-support"
        );

        String screenshotsFolder = "D:\\isa\\ISA time Test\\5thdec 3.45 - 4.45 PM"; //

        long runTime = 60 * 60 * 1000; // 1 hour in milliseconds
        long interval = 1 * 60 * 1000; // Interval to wait between checks (1 minute in milliseconds)

        // Record the start time
        long startTime = System.currentTimeMillis();

        // DateTimeFormatter for formatting the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // Repeat every minute until 1 hour has passed
        while (System.currentTimeMillis() - startTime < runTime) {
            for (String url : urls) {
                try {
                    long pageLoadStart = System.currentTimeMillis(); // Capture the time before the page load
                    driver.get(url); // Load the page
                    long pageLoadEnd = System.currentTimeMillis(); // Capture the time after the page load

                    long pageLoadTime = pageLoadEnd - pageLoadStart; // Calculate page load time

                    // Get the current time in a formatted string
                    LocalDateTime currentTime = LocalDateTime.now();
                    String formattedTime = currentTime.format(formatter);

                    // Print the page load time and current time for the current URL
                    System.out.println("Current Time: " + formattedTime + " | URL: " + url + " | Page load time: " + pageLoadTime + " ms");

                    // Capture a screenshot of the entire screen using Java Robot
                    captureFullScreen(screenshotsFolder, formattedTime);

                    // Wait for the next interval before taking another screenshot (1 minute)
                    Thread.sleep(interval);

                } catch (InterruptedException e) {
                    System.err.println("Error during wait: " + e.getMessage());
                } catch (WebDriverException e) {
                    System.err.println("Error loading page: " + e.getMessage());
                } catch (Exception e) {  // Catch any other exceptions (generic catch)
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }

        // Close the driver
        driver.quit();
        System.out.println("Test completed.");
    }

    // Method to capture full-screen screenshot
    public static void captureFullScreen(String screenshotsFolder, String formattedTime) {
        try {
            // Create a Robot instance to capture the screen
            Robot robot = new Robot();

            // Get the screen size and capture the entire screen
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenImage = robot.createScreenCapture(screenRect);

            // Use the current time to name the screenshot and save it in the specified folder
            File destinationFile = new File(screenshotsFolder + File.separator + " screenshot_" + formattedTime + ".png");

            // Save the screenshot
            ImageIO.write(screenImage, "PNG", destinationFile);


        } catch (AWTException | IOException e) {
            System.err.println("Error capturing full screen: " + e.getMessage());
        }
    }
}