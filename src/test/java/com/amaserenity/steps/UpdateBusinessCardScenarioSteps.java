package com.amaserenity.steps;

import com.amaserenity.steps.serenity.UserSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateBusinessCardScenarioSteps {

	@Steps
	UserSteps user;

	@When("^user taps on the My Account$")
	public void user_taps_on_the_My_Account() {
		user.user_taps_on_the_My_Account();
	}

	@When("^user taps on Business Card$")
	public void user_taps_on_Business_Card() {
		user.user_taps_on_business_card();
	}

	@When("^user updates Salutation$")
	public void user_updates_Salutation() {
		user.update_salutation();

	}

	@Then("^user successfully updates Salutation$")
	public void user_successfully_updates_Salutation() {
		user.verify_salutation();
	}

}
