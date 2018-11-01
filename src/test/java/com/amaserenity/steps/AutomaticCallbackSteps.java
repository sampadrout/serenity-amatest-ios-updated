package com.amaserenity.steps;

import com.amaserenity.steps.serenity.UserSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AutomaticCallbackSteps {
	
	@Steps
	UserSteps user;

	@When("^user taps on the Joining Options$")
	public void user_taps_on_the_joiningg_option() {
		user.user_taps_on_joining_option();
		Serenity.setSessionVariable("Callback").to("");
	}

	@When("^user taps on the Automatic Callback$")
	public void user_taps_on_automatic_callback() {
		user.user_taps_on_automatic_callback();
	}

	@When("^enables or disables the automatic call$")
	public void user_updates_automatic_callback() {
		user.user_updates_automatic_callback();
	}

	@Then("^user successfully saves the automatic callback$")
	public void user_successfully_updates_automatic_callback() {
		user.user_verifies_automatic_callback();
	}


}
