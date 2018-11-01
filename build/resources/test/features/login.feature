Feature: Login page scenarios

@Issue:IOSTRA-3342

Scenario: FTUX - Existing User login
Given User is on login page
When Enter valid credentials
Then User is shown calendar page
Then Select Local Calendar
Then Accept calendar Alert
Then Select EWS Calendar
Then Tap Done
Then Display EWS page to enter details