package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriver {
    public WebDriver returndriver() {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\brang\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

      return driver;
    }

    public WebDriver manageddriver() {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       // WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().driverVersion("127.0.6533.88").setup();
        // Initialize ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}