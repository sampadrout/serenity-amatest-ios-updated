/*package com.amaserenity;

import com.amaserenity.model.UserAccount;
import com.amaserenity.steps.serenity.UserSteps;
import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static com.amaserenity.utils.AppiumServer.startAppiumServer;
import static com.amaserenity.utils.AppiumServer.stopAppiumServer;

@RunWith(SerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/"
//		glue = "com.amaserenity.steps.LoginScenarioSteps"
)

public class LoginTestCases {

    List<UserAccount> userAccounts;

    @Managed(driver = "appium")
    WebDriver driver;

    @Steps
    UserSteps user;

    @BeforeClass
    public static void setUp() throws IOException, Exception {
        startAppiumServer();
    }

    @Test
    public void login_by_the_user() throws Throwable {

        // GIVEN
        user.opens_login_screen();

        // WHEN
        user.enters_user_name(userAccounts);
        user.enters_password(userAccounts);
        user.enters_phone_number(userAccounts);

        // AND
        user.taps_to_login();
        user.navigates_to_calendar_screen();
        user.taps_to_select_local_calendar();
        user.taps_to_accept_calendar_permission_alert();
        user.taps_to_Done();
        user.navigates_to_contacts_screen();
        user.taps_on_Contacts();
        user.taps_to_accept_contacts_permission_alert();
        user.swipes_and_close_tutorial_screen();
        user.navigates_to_main_screen();
        user.opens_settings_drawer();
        user.taps_on_settings_option();
        user.navigates_to_settings_screen();
        user.taps_on_signout();
        user.taps_to_confirms_signout();

        // THEN
        user.navigates_to_login_screen();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        stopAppiumServer();
    }

}*/

