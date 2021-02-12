@Login
Feature: IntelliReflex Login

Scenario: verify the IntelliReflex login functionality with valid user

Given user is on Login Page
When email and password text box are visible
Then user enters username and passowrd
Then user verifies the username displayed on home page
Then user logs out