package com.amaserenity.steps.serenity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.amaserenity.model.UserAccount;
import com.amaserenity.pages.AutomaticCallbackScreen;
import com.amaserenity.pages.BusinessCardScreen;
import com.amaserenity.pages.CalendarScreen;
import com.amaserenity.pages.ContactsScreen;
import com.amaserenity.pages.JoiningOptions;
import com.amaserenity.pages.LoginScreen;
import com.amaserenity.pages.MainScreen;
import com.amaserenity.pages.MyAccountScreen;
import com.amaserenity.pages.NotificationsScreen;
import com.amaserenity.pages.SettingsScreen;
import com.amaserenity.pages.TutorialScreen;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	LoginScreen loginScreen;
    CalendarScreen calendarScreen;
    NotificationsScreen notificationsScreen;
    ContactsScreen contactsScreen;
    TutorialScreen tutorialScreen;
    MainScreen mainScreen;
    SettingsScreen settingsScreen;
    MyAccountScreen myAccountScreen;
    BusinessCardScreen businessCardScreen;
    JoiningOptions joiningOption;
    AutomaticCallbackScreen automaticCallbackScreen;
    private HashMap<String,String> map = new HashMap<String,String>();
    

    @Step
    public void opens_login_screen() {
        loginScreen.openLoginScreen();
    }

    @Step
    public void enters_user_name(List<UserAccount> userAccounts) throws Throwable {
        loginScreen.enterUserName(userAccounts);
    }

    @Step
    public void enters_password(List<UserAccount> userAccounts) throws Throwable {
        loginScreen.enterPassword(userAccounts);
    }

    @Step
    public void enters_phone_number(List<UserAccount> userAccounts) throws Throwable {
        loginScreen.enterPhoneNo(userAccounts);
    }

    @Step
    public void taps_to_login() {
        loginScreen.tapLogin();
    }

    @Step
    public void sees_login_error_meesage() {
        loginScreen.isLoginFailedMsgShown();
    }

    @Step
    public void navigates_to_calendar_screen() {
        calendarScreen.isCalendarScreenShown();
    }

    @Step
    public void taps_to_select_local_calendar() {
        calendarScreen.selectLocalCalendar();
    }

    @Step
    public void taps_to_accept_calendar_permission_alert() {
        calendarScreen.acceptCalendarAlert();
    }

    @Step
    public void taps_to_Done() {
        calendarScreen.tapDone();
    }

    @Step
    public void navigates_to_notifications_screen() {
        notificationsScreen.isNotificationsScreenShown();
    }

    @Step
    public void taps_on_Notifications() {
        notificationsScreen.tapNotificationsOK();
    }

    @Step
    public void taps_to_accept_notifications_permission_alert() {
        notificationsScreen.acceptNotificationsAlert();
    }
    
    public void swipeAppTour() {
    	
    }

    @Step
    public void navigates_to_contacts_screen() {
        contactsScreen.isContactsScreenShown();
    }

    @Step
    public void taps_on_Contacts() {
        contactsScreen.tapContacts();
    }

    @Step
    public void taps_to_accept_contacts_permission_alert() {
        contactsScreen.acceptContactsAlert();
    }

    @Step
    public void swipes_and_close_tutorial_screen() throws InterruptedException, IOException {
        tutorialScreen.closeTutorialScreen();
    }

    @Step
    public void navigates_to_main_screen() {
        mainScreen.isMainScreenShown();
    }

    @Step
    public void opens_settings_drawer() {
        mainScreen.openSettingsDrawer();
    }

    @Step
    public void taps_on_settings_option() {
        mainScreen.tapSettingsOption();
    }

    @Step
    public void navigates_to_settings_screen() {
        settingsScreen.isSettingsScreenShown();
    }

    @Step
    public void taps_on_signout() {
        settingsScreen.tapSignout();
    }

    @Step
    public void taps_to_confirms_signout() {
        settingsScreen.tapConfirmSignout();
    }

    @Step
    public void navigates_to_login_screen() {
        loginScreen.openLoginScreen();
    }
    
    @Step
    public void user_taps_on_the_My_Account() {
    	settingsScreen.tapMyAccount();
    }
    
    @Step
    public void user_taps_on_business_card() {
    	myAccountScreen.selectBusinessCard();
    }

    @Step
	public void update_salutation() {
    	String newSalutation = businessCardScreen.update_salutation();
    	Serenity.setSessionVariable("Salutation").to(newSalutation);
		
	}
    
    @Step
	public void verify_salutation() {
    	myAccountScreen.verifyMyAccountScreen();
    	myAccountScreen.selectBusinessCard();
    	System.out.println(businessCardScreen.verify_salutation(Serenity.sessionVariableCalled("Salutation")));
	}
    
    @Step
   	public void user_taps_on_joining_option() {
    	settingsScreen.tapJoiningOption();
    	System.out.println("BIKASH  ----> "+ joiningOption.get_automatic_callback_value());
//    	Serenity.setSessionVariable("Callback").to(joiningOption.get_automatic_callback_value());
    	map.put("Callback", joiningOption.get_automatic_callback_value().toString());
   	}
    
    @Step
   	public void user_taps_on_automatic_callback() {
    	joiningOption.tap_automatic_callback();
   	}
    
    @Step
   	public void user_updates_automatic_callback() {
    	System.out.println("WHAT " + map.get("Callback"));
    	automaticCallbackScreen.updateAutomaticCallback(map.get("Callback"));
   	}
    
    @Step
   	public void user_verifies_automatic_callback() {
    	String finalValue = joiningOption.get_automatic_callback_value();
    	System.out.println("RISHAV --<"+ finalValue);
    	if(finalValue.trim().equals(map.get("Callback").toString()))
    		System.out.println("awesome");
    			
   	}
}
