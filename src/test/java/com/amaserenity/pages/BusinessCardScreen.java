package com.amaserenity.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BusinessCardScreen extends PageObject {
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Title']")
	private WebElementFacade salutation;
	
	@FindBy(accessibilityId="BusinessCard_SaveButton")
	private WebElementFacade save;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Title']/../XCUIElementTypeStaticText")
	private List<WebElementFacade> salutationDisplay;
	
	

	public String update_salutation() {
		//String saluationValue = getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='Title']/../XCUIElementTypeStaticText")).get(1).getAttribute("label");
		String saluationValue = salutationDisplay.get(1).getAttribute("label");
		if(!(saluationValue.equals("Title") || saluationValue.equals("Miss"))) {
			if(!saluationValue.endsWith("."))
				saluationValue = saluationValue + ".";
		}
		element(salutation).click();
		List<String> saluation = new ArrayList<String>();

		WebElement thisElement = getDriver().findElement(By.xpath("//XCUIElementTypeNavigationBar[@name='Title']/.."));
		Random ran = new Random();
		int x = ran.nextInt(5) + 1;
		System.out.println("Random Number Generated " + x);
		List<WebElement> salutationListItems = thisElement.findElements(By.className("XCUIElementTypeStaticText"));

		for (WebElement ele : salutationListItems) {
			saluation.add(ele.getAttribute("label"));
		}
		
		System.out.println("List "+saluation);
		
		//If the already salutation value is the random generated value, keep iterating till a unique value
		while(true) {
			int temp = saluation.indexOf(saluationValue);
			System.out.println("Index of Original value "+ temp);
			if(temp == x) 
				x = ran.nextInt(5) + 1;
			else
				break;
		}
		
		
		for (WebElement ele : salutationListItems) {
			if (ele.getAttribute("label").contains(saluation.get(x))) {
				ele.click();
				element(save).click();
				break;
			}
		}

		return saluation.get(x);
	}
	
	public  boolean verify_salutation(String expected) {
	
		if(salutationDisplay.get(1).getAttribute("label").equals(expected))
			return true;
		return false;
	}
		

}
