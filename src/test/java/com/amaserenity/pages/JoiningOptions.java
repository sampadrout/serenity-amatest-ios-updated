package com.amaserenity.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class JoiningOptions extends PageObject {

	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Joining Options']")
	private WebElementFacade joiningOptions;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Automatic Callback']/..")
	private WebElementFacade automaticCallbackParent;

	
	public void tap_automatic_callback() {
		openSubOptions("Automatic Callback");
	}
	
	public String get_automatic_callback_value() {
		WebElement statusElement = automaticCallbackParent.findElements(By.className("XCUIElementTypeStaticText")).get(1);
		String initialValue = statusElement.getAttribute("label").trim();
		return initialValue;
		
	}
	public void openSubOptions(String subOptions) {
		element(joiningOptions).waitUntilPresent();
		List<WebElement> myAccountMenuItems = getDriver().findElements(By.className("XCUIElementTypeStaticText"));
		for (WebElement element : myAccountMenuItems) {
			if (element.getAttribute("label") != null && element.getAttribute("label").contains(subOptions)) {
				element.click();
				break;
			}
		}

	}

}
