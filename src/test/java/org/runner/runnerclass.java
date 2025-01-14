package org.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue={"org.stepdef"},
        tags="@Regression1",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
        //monochrome = true
)
public class runnerclass { }
