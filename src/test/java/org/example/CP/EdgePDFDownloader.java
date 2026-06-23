package org.example.CP;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.*;

public class EdgePDFDownloader {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.edge.driver", "D:\\Selenium Drivers\\msedgedriver.exe");

        // 🔽 Auto-download setup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "C:\\PDF_Downloads");
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);

        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new EdgeDriver(options);

        // 🔐 LOGIN
        driver.get("https://oscir.worldstrides.org/");
        Thread.sleep(3000);

        driver.findElement(By.id("form_login_login")).sendKeys("appdev@worldstrides.com");
        driver.findElement(By.id("form_login_password")).sendKeys("test1234");
        driver.findElement(By.xpath("//*[@id=\"login\"]/fieldset/div[3]/button")).click();

        Thread.sleep(5000);

        //  TARGET PAGE
        driver.get("https://oscir.worldstrides.org/cheat_sheets.xml");
        Thread.sleep(5000);

        // 🔍 GET ALL PDF/DOC LINKS
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Set<String> validLinks = new LinkedHashSet<>();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null) {
                String lower = url.toLowerCase();

                if (lower.endsWith(".pdf") || lower.endsWith(".doc") || lower.endsWith(".docx")) {
                    validLinks.add(url);
                }
            }
        }

        System.out.println("Valid files found: " + validLinks.size());

        int success = 0;
        int failed = 0;

        // DOWNLOAD USING BROWSER (CORRECT WAY)
        for (String fileUrl : validLinks) {
            try {
                System.out.println("Downloading: " + fileUrl);

                // 👉 Open file (Edge will download automatically)
                driver.navigate().to(fileUrl);

                Thread.sleep(2000); // wait for download trigger

                success++;

            } catch (Exception e) {
                System.out.println("Failed: " + fileUrl);
                failed++;
            }
        }

        System.out.println(" Download triggered: " + success);
        System.out.println("Failed: " + failed);

        // ⏳ Wait for all downloads to complete
        Thread.sleep(30000);

        driver.quit();
    }
}