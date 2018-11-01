@android @ios @regression
Feature: A registered user can log on to AMA app
  As a registered user
  I want to login to AMA app using my username and password
  So that i can manage my meetings

  Background:
    Given user is on login screen

  Scenario: Existing user Verification
    When enters username, password and phone number
      | username 			  | password    |	phonenumber	|
      | traqatest5@gmail.com  | welcometr1  |	9546532543	|
    And taps on login
    And user is on Calendar Screen
    And taps to selects google calendar
    And accepts the calendar permission
    And taps on to save the selected calendar
    And user is on notifications screen
    And allows the app to access the device notifications
    And accepts the notifications permission
    And user is on contacts screen
    And allows the app to access the device contacts
    And accepts the contacts permission
    And user swipes through the tutorials screen to close it
    And user should see the main screen
    And user opens settings drawer
    And user taps on settings
    And user should see the settings screen
    And user taps on sign out
    And confirms sign out
    Then user successfully sign out

  Scenario: Logging on with an incorrect password
    When user enters invalid username and password
      | username 			  | password    |	phonenumber	|
      | traqatest5@gmail.com  | wrong	    |	9546532543	|
    And user should be informed that the password was incorrect


