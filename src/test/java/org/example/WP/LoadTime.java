package org.example.WP;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.Dimension;

public class LoadTime {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.edge.driver", "D:\\SeleniumProject\\msedgedriver.exe");

        // Create EdgeDriver instance
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);

        // Start the timer
        long startTime = System.currentTimeMillis();

        //WP engine worldstridedev.wpenginepowered.com
        //prod worldstrides.com
        // Navigate to the desired page
        driver.navigate().to("https://worldstridedev.wpenginepowered.com/contact/");

        // Stop the timer
        long endTime = System.currentTimeMillis();

        // Calculate total page load time
        long totalTime = endTime - startTime;

        // Print the total page load time
        System.out.println("Total Page Load Time: " + totalTime + " milliseconds");

        driver.quit();


    }

    }