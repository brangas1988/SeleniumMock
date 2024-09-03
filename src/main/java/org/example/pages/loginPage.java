package org.example.pages;

import org.apache.hc.core5.util.Timeout;
import org.checkerframework.checker.units.qual.A;
import org.example.driver.webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class loginPage  {

    WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUsername(String username){
        Actions actions=new Actions(driver);
        // actions.send
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@id=\"userid-content\"]")).sendKeys(username);
        System.out.println(System.getProperty("env"));

    }

    public void setpwd(String pwd){

        driver.findElement(By.xpath("//*[@id=\"password-content\"]")).sendKeys(pwd);

    }
    //*[@id="log-in-button"]
    public void clicklogin(){


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"log-in-button\"]")));

        // driver.navigate().to
        driver.getCurrentUrl();
      //  driver.switchTo().frame("");
        //Set<String> tab_handles = driver.getWindowHandles();
        //int i=tab_handles.size();
        driver.navigate().refresh();
     //fg   driver.

        Actions actions=new Actions(driver);
       // actions.send
        actions.sendKeys(Keys.PAGE_DOWN);

    }
    public void clickeWithWait(){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"log-in-button\"]")));



    }


}
