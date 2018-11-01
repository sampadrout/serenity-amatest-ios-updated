package com.amaserenity.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AutomaticCallbackScreen extends PageObject {

	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Automatic Callback']/..")
	private WebElementFacade automaticCallbackParent;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Callback Number']")
	private WebElementFacade callbackNumber;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile 1']")
	private WebElementFacade mobileFirst;

	@FindBy(accessibilityId = "saveButton")
	private WebElementFacade save;

	public void updateAutomaticCallback(String initialValue) {

		List<WebElement> elements = automaticCallbackParent.findElements(By.className("XCUIElementTypeSwitch"));
		for (WebElement e : elements) {
			if (e.getAttribute("name").contains("AutomaticCall") || e.getAttribute("name").contains("AutoCallAllDay")) {
				e.click();
				break;
			}
		}
		if (initialValue.equals("OFF")) {
			element(callbackNumber).click();
			element(mobileFirst).click();
		}

		element(save).click();

	}
}
