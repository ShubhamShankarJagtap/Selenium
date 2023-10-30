package com.basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.basic.Listners.class)

public class Launch {

    WebDriver driver;

    @Test
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
}
