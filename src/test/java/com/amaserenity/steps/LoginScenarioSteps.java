package com.amaserenity.steps;

import java.io.IOException;
import java.util.List;

import com.amaserenity.model.*;
import com.amaserenity.steps.serenity.UserSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginScenarioSteps {

    @Steps
    UserSteps user;

    @Given("user is on login screen")
    public void given_user_is_on_login_screen() throws Throwable {
        user.opens_login_screen();
    }

    @When("enters username, password and phone number")
    public void when_enters_username_password_and_phone_number(List<UserAccount> userAccounts) throws Throwable {
        user.enters_user_name(userAccounts);
        user.enters_password(userAccounts);
        user.enters_phone_number(userAccounts);
    }

    @And("taps on login")
    public void and_user_taps_on_login()  {
        user.taps_to_login();
    }

    @And("user is on Calendar Screen")
    public void and_user_is_on_Calendar_Screen() {
        user.navigates_to_calendar_screen();
    }

    @And("taps to selects google calendar")
    public void and_user_taps_to_selects_google_calendar() {
        user.taps_to_select_local_calendar();
    }

    @And("accepts the calendar permission")
    public void and_user_accepts_the_calendar_permission() {
        user.taps_to_accept_calendar_permission_alert();
    }

    @And("taps on to save the selected calendar")
    public void and_user_taps_on_to_save_the_selected_calendar() {
        user.taps_to_Done();
    }

    @And("user is on notifications screen")
    public void and_user_is_on_otifications_screen() {
        user.navigates_to_notifications_screen();
    }

    @And("allows the app to access the device notifications")
    public void and_user_allows_the_app_to_access_the_device_notifications() {
        user.taps_on_Notifications();
    }

    @And("accepts the notifications permission")
    public void and_user_accepts_the_notifications_permission() {
        user.taps_to_accept_notifications_permission_alert();
    }

    @And("user is on contacts screen")
    public void and_user_is_on_contacts_screen() {
        user.navigates_to_contacts_screen();
    }

    @And("allows the app to access the device contacts")
    public void and_user_allows_the_app_to_access_the_device_contacts() {
        user.taps_on_Contacts();
    }

    @And("accepts the contacts permission")
    public void and_user_accepts_the_contacts_permission() {
        user.taps_to_accept_contacts_permission_alert();
    }

    @And("user swipes through the tutorials screen to close it")
    public void and_user_swipes_through_the_tutorials_screen_to_close_it() throws InterruptedException, IOException {
        user.swipes_and_close_tutorial_screen();
    }

    @And("user should see the main screen")
    public void and_user_should_see_the_main_screen() {
        // Write code here that turns the phrase above into concrete actions
        user.navigates_to_main_screen();
    }

    @And("user opens settings drawer")
    public void and_user_opens_settings_drawer() {
        user.opens_settings_drawer();
    }

    @And("user taps on settings")
    public void and_user_taps_on_settings() {
        user.taps_on_settings_option();
    }

    @And("user should see the settings screen")
    public void and_user_should_see_the_screen() {
        user.navigates_to_settings_screen();
    }

    @And("user taps on sign out")
    public void and_user_taps_on_sign_out() {
        user.taps_on_signout();
    }

    @And("confirms sign out")
    public void and_user_confirms_sign_out() {
        user.taps_to_confirms_signout();
    }

    @Then("user successfully sign out")
    public void then_user_successfully_sign_out() {
        user.navigates_to_login_screen();
    }

    @When("user enters invalid username and password")
    public void and_user_enters_invalid_password(List<UserAccount> userAccounts) throws Throwable {
        user.enters_user_name(userAccounts);
        user.enters_password(userAccounts);
        user.enters_phone_number(userAccounts);
        user.taps_to_login();
    }

    @Then("user should be informed that the password was incorrect")
    public void then_user_should_be_informed_that_the_password_was_incorrect() {
        user.sees_login_error_meesage();
    }
    
  
}