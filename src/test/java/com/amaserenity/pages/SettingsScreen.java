package com.amaserenity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SettingsScreen extends PageObject {

	@FindBy(accessibilityId = "Settings")
	private WebElementFacade settings;

	@FindBy(accessibilityId = "Sign Out")
	private WebElementFacade signOut;

	@FindBy(accessibilityId = "OK")
	private WebElementFacade confirmSignOut;

	@FindBy(accessibilityId = "Settings_TitleLabel_showAccountInformation")
	private WebElementFacade myAccount;

	@FindBy(accessibilityId = "Settings_TitleLabel_showAccountInformation")
	private WebElementFacade joiningOptions;

	public void isSettingsScreenShown() {
		element(settings).waitUntilVisible();
	}

	public void tapMyAccount() {
		//element(myAccount).click();
		openSettingsSubOption("My Account");
	}

	public void tapJoiningOption() {
		openSettingsSubOption("Joining Option");
	}

	public void tapSignout() {
		element(signOut).waitUntilClickable().click();
	}

	public void tapConfirmSignout() {
		element(confirmSignOut).waitUntilClickable().click();
	}

	public void openSettingsSubOption(String option) {
		element(settings).waitUntilVisible();
		List<WebElement> subMenuItems = getDriver().findElements(By.className("XCUIElementTypeCell"));
		for (WebElement element : subMenuItems) {
			if (element.getAttribute("label") != null && element.getAttribute("label").equals(option)) {
				element.click();
				break;
			}
		}

	}
}
