package com.amaserenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CalendarScreen extends PageObject {

    @FindBy(accessibilityId="Calendars")
    private WebElementFacade calendar;

    @FindBy(accessibilityId="calendar_checkbox")
    private WebElementFacade googlecalendarCheckbox;

    @FindBy(accessibilityId="OK")
    private WebElementFacade allowCalendarAlert;

    @FindBy(accessibilityId="Done")
    private WebElementFacade btnCalendarSave;

    public void isCalendarScreenShown(){
        element(calendar).waitUntilVisible();
    }

    public void selectLocalCalendar(){
        element(googlecalendarCheckbox).click();
    }

    public void acceptCalendarAlert(){
        element(allowCalendarAlert).waitUntilVisible().click();
    }

    public void tapDone(){
        element(btnCalendarSave).waitUntilEnabled().click();
    }
}
