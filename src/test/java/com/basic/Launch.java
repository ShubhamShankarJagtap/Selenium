package com.basic;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.basic.Listners.class)

public class Launch {

    WebDriver driver;

    @BeforeClass
    public void launchBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
    }

    @Test
    public void screenShoot() throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File destFile = new File("F:\\VS workplace\\demo\\src\\test\\java\\com\\basic\\Data\\NewImage.png");
        File sourcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourcFile, destFile);

    }

    @Test
    public void brokenLinks() {

        driver.navigate().to("https://www.redbus.in");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {

            String href = link.getAttribute("href");

            if (href != null && !href.isEmpty()) {
                try {

                    URL url = new URL(href);

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();

                    int responseCode = urlConnection.getResponseCode();

                    if (responseCode >= 400) {

                        System.out.println("Broken link is : " + href + "responseCode is : " + responseCode);
                    } else {

                        System.out.println("Valid link is : " + href);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(" Error connecting to : " + href);
                }
            }
        }
    }
}
