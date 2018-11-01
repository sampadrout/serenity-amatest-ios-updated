package com.amaserenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountScreen extends PageObject{
	
	@FindBy(accessibilityId="Business Card")
	private WebElementFacade businessCard;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='My Account']")
	private WebElementFacade myAccountScreen;
	
	public void selectBusinessCard() {
		element(businessCard).waitUntilClickable();
		element(businessCard).click();
	}
	
	public void verifyMyAccountScreen() {
		element(myAccountScreen).waitUntilVisible();
	}
	
	public void get_salutation() {
		element(businessCard).waitUntilClickable();
		element(businessCard).click();
	}

}
