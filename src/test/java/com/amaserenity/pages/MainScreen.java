package com.amaserenity.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MainScreen extends PageObject {

	@FindBy(accessibilityId="AgileMeeting Assistant")
	private WebElementFacade app;
	
    @FindBy(accessibilityId="Daily View")
    private WebElementFacade mainScreen;

    @FindBy(accessibilityId="ToggleSettingsButton")
    private WebElementFacade openDrawer;

    @FindBy(accessibilityId="Settings")
    private WebElementFacade settingsOption;
    
    @FindBy(className="XCUIElementTypeStaticText")
    private WebElementFacade staticText;
    
    @FindBy(xpath="//XCUIElementTypeNavigationBar[@name='Daily View']")
    private WebElementFacade mainScreenCheck;

    public void isMainScreenShown() {
    	List<WebElement> elements = getDriver().findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeNavigationBar[@name='Daily View']"));
//        element(mainScreenCheck).waitUntilPresent();
    	elements.get(0).click();
    }

    public void openSettingsDrawer() {
        element(openDrawer).click();
    }

    public void tapSettingsOption() {
        element(settingsOption).waitUntilClickable().click();
    }
    
    public  void openSidePanelOption(String option) {
    	element(openDrawer).waitUntilPresent();
		
		// click on Daily View menu -> Settings
    	element(openDrawer).click();
		List<IOSElement> menuItems = element(staticText);
		for (IOSElement ele : menuItems) {
			if (ele.getAttribute("label") != null && ele.getAttribute("label").contains(option)) {
				ele.click();
				break;
			}
		}
	}

	public static void openSettingsSubOption(IOSDriver<IOSElement> driver, String option)  {
		if (driver.findElementsByXPath("//XCUIElementTypeNavigationBar[@name='Settings']").size() == 1) {
			List<IOSElement> subMenuItems = driver.findElementsByClassName("XCUIElementTypeCell");
			for (IOSElement element : subMenuItems) {
				if (element.getAttribute("label") != null && element.getAttribute("label").equals(option)) {
					element.click();
					break;
				}
			}
		}
	}

	public static void openSettingsSubOptions_Option(IOSDriver<IOSElement> driver, String option, String subOptions) {
		if (driver.findElementsByXPath("//XCUIElementTypeNavigationBar[@name='" + option + "']").size() == 1) {
			List<IOSElement> myAccountMenuItems = driver.findElementsByClassName("XCUIElementTypeStaticText");
			for (IOSElement element : myAccountMenuItems) {
				if (element.getAttribute("label") != null && element.getAttribute("label").contains(subOptions)) {
					element.click();
					break;
				}
			}
		}
	}

}
