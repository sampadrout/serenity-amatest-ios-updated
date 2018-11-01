package com.amaserenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NotificationsScreen extends PageObject {

    @FindBy(accessibilityId="Notifications")
    private WebElementFacade notifications;

    @FindBy(accessibilityId="okayAllowNotifications_button")
    private WebElementFacade btnNotificationsOK;

    @FindBy(accessibilityId="Allow")
    private WebElementFacade allowNotificationsAlert;

    public void isNotificationsScreenShown(){
        element(notifications).waitUntilVisible();
    }

    public void tapNotificationsOK() {
        element(btnNotificationsOK).click();
    }

    public void acceptNotificationsAlert(){
        element(allowNotificationsAlert).waitUntilVisible().click();
    }
}
