package org.example;

import org.example.driver.webdriver;
import org.example.pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        webdriver webdriver=new webdriver();
        WebDriver driver=webdriver.manageddriver();
       driver.get("https://www.discover.com");
       loginPage login=new loginPage(driver);

        login.setUsername("arumariNaraya");

        login.setpwd("Givinds");
       // Thread.sleep(5000);
        login.clicklogin();
       driver.quit();

    }
}