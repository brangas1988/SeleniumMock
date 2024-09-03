package org.stepdef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import io.cucumber.plugin.event.TestStep;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.common.configReader;
import org.example.driver.webdriver;
import org.example.pages.loginPage;
import org.example.pojoVo.product;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class loginstepdef extends webdriver{

    webdriver webdriver=new webdriver();
    WebDriver driver=webdriver.manageddriver();
    Map<Integer,String> enemies1 = new HashMap<>();
    int i=0;
    Scenario scenario1;
    configReader config=new configReader();
    @Given("when discover page opened")
    public void whenDiscoverPageOpened(Scenario scenario) {


        driver.get("https://www.discover.com");
        Actions actions=new Actions(driver);
        // actions.send

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.scrollByAmount(200,300);

    }

    @And("credentials {string} and {string} provided")
    public void credentialsAndProvided(String arg0, String arg1) {
        loginPage login=new loginPage(driver);

        login.setUsername(arg0);
        login.setpwd(arg1);
        login.clicklogin();
    }


    @Then("click login and confirm error message")
    public void clickLoginAndConfirmErrorMessage() {
        enemies1.put(i,"PageFinal");
        System.out.print("Login Failed");
    }

    @Given("org is bulldhit")
    public void orgIsBulldhit() {
    }

    @Then("mayiraandi")
    public void mayiraandi() {
    }

    @And("Ydkfhd dfkjh")
    public void ydkfhdDfkjh() {
    }

    @Given("sample feature file is ready")
    public void sampleFeatureFileIsReady() {
        enemies1.put(i,"Main");
        System.out.println("Sample Feature is ready");
        driver.get("https://www.discover.com");
    }

    @When("I run the feature file")
    public void iRunTheFeatureFile() {


    }

    @Then("run should be successful")
    public void runShouldBeSuccessful() {
        enemies1.put(i,"FinalPage");
    }

    @When("I run the feature file {string} {string}")
    public void iRunTheFeatureFile(String arg0, String arg1) throws InterruptedException {
        loginPage login=new loginPage(driver);

        login.setUsername(arg0);
        login.setpwd(arg1);
        enemies1.put(i,"Login");
//        final byte[] screenshot = ScreenshotHelper.captureScreenshot(driver);
//        scenario1.attach(screenshot, "image/png","loginscreen");
        login.clicklogin();
        Thread.sleep(5000);

    }

    @AfterStep
    public void embedScreenshot(Scenario scenario) {
        if (!scenario.isFailed()) {
            System.out.println(enemies1.get(i));
            final byte[] screenshot = ScreenshotHelper.captureScreenshot(driver);
            scenario.attach(screenshot, "image/png", enemies1.get(i));
            i++;
        }
    }
    @After
    public void closedriver(Scenario scenario) {

        driver.quit();

    }

}
