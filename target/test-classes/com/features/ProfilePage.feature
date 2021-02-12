@ViewProfile
Feature: IntelliReflex Login User Profile

Scenario: verify the user profile details
Given user is on Login Page
When email and password text box are visible
Then user enters username and passowrd
Then user verifies the username displayed on home page
Then user clicks on profile button
And user is navigated to profile page
Then user verifies the profile details.