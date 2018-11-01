package com.amaserenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContactsScreen extends PageObject {

    @FindBy(accessibilityId="Contacts")
    private WebElementFacade contacts;

    @FindBy(accessibilityId="okayAllowNotifications_button")
    private WebElementFacade btnContactsOK;

    @FindBy(accessibilityId="OK")
    private WebElementFacade allowContactsAlert;

    public void isContactsScreenShown(){
        element(contacts).waitUntilVisible();
    }

    public void tapContacts() {
        element(btnContactsOK).click();
    }

    public void acceptContactsAlert(){
        element(allowContactsAlert).waitUntilVisible().click();
    }

}
