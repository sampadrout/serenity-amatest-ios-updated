package com.amaserenity.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.amaserenity.model.UserAccount;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginScreen extends PageObject {

    @FindBy(accessibilityId="logo_cell")
    private WebElementFacade loginLogo;

    @FindBy(accessibilityId="emailAddress_textfield")
    private WebElementFacade emailAddress;

    @FindBy(accessibilityId="password_textfield")
    private WebElement password;

    @FindBy(accessibilityId="numberInputTextField")
    private WebElementFacade phoneNumber;

    @FindBy(accessibilityId="signInButton")
    private WebElementFacade signIn;

    @FindBy(accessibilityId="Failed to sign in")
    private WebElementFacade loginFailed;
    
    @FindBy(xpath="//XCUIElementTypeImage[@name='Coach1']")
    private WebElementFacade appTourPage1;

    public void openLoginScreen(){
        element(loginLogo).waitUntilVisible();
    }

    public void enterUserName(List<UserAccount> userAccounts) throws Throwable {

        for (UserAccount userAccount : userAccounts) {
            element(emailAddress).sendKeys(userAccount.getUsername());
        }
    }

    public void enterPassword(List<UserAccount> userAccounts) throws Throwable {

        for (UserAccount userAccount : userAccounts) {
            element(password).sendKeys(userAccount.getPassword());
        }
    }

    public void enterPhoneNo(List<UserAccount> userAccounts) throws Throwable {

        for (UserAccount userAccount : userAccounts) {
            element(phoneNumber).sendKeys(userAccount.getPhonenumber());
        }
    }

    public void tapLogin(){
        element(signIn).waitUntilClickable().click();
    }

    public boolean isLoginFailedMsgShown(){
        return element(loginFailed).waitUntilVisible().getText().contentEquals("Failed to sign in");
    }
    
    public boolean swipeAppTour(String direction) {
    	try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                swipeObject.put("direction", "down");
            } else if (direction.equals("u")) {
                swipeObject.put("direction", "up");
            } else if (direction.equals("l")) {
                swipeObject.put("direction", "left");
            } else if (direction.equals("r")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element",element(appTourPage1));
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}