package com.amaserenity;

import static com.amaserenity.utils.AppiumServer.startAppiumServer;
import static com.amaserenity.utils.AppiumServer.stopAppiumServer;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/automaticCallback.feature"
//		glue = "com.amaserenity.steps.LoginScenarioSteps"
		)

public class RunnerTest {
	
//	This is to manage webdriver instance by serenity

	@Managed(driver = "appium", uniqueSession = false)
	WebDriver driver;

    @BeforeClass
    public static void setUp() throws IOException, Exception {
        startAppiumServer();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        stopAppiumServer();
    }   
}
