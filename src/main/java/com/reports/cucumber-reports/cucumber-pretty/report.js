$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginPage.feature");
formatter.feature({
  "line": 2,
  "name": "IntelliReflex Login",
  "description": "",
  "id": "intellireflex-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "verify the IntelliReflex login functionality with valid user",
  "description": "",
  "id": "intellireflex-login;verify-the-intellireflex-login-functionality-with-valid-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "user is on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "email and password text box are visible",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters username and passowrd",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user verifies the username displayed on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user logs out",
  "keyword": "Then "
});
formatter.match({
  "location": "AllStepDefs.user_is_on_Login_Page()"
});
formatter.result({
  "duration": 16290254700,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.email_and_password_text_box_are_visible()"
});
formatter.result({
  "duration": 43696900,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_enters_username_and_passowrd()"
});
formatter.result({
  "duration": 11204673100,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_verifies_the_username_displayed_on_home_page()"
});
formatter.result({
  "duration": 24000,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_logs_out()"
});
formatter.result({
  "duration": 12078074900,
  "status": "passed"
});
formatter.uri("ProfilePage.feature");
formatter.feature({
  "line": 2,
  "name": "IntelliReflex Login User Profile",
  "description": "",
  "id": "intellireflex-login-user-profile",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ViewProfile"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "verify the user profile details",
  "description": "",
  "id": "intellireflex-login-user-profile;verify-the-user-profile-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is on Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "email and password text box are visible",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user enters username and passowrd",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user verifies the username displayed on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on profile button",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user is navigated to profile page",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user verifies the profile details.",
  "keyword": "Then "
});
formatter.match({
  "location": "AllStepDefs.user_is_on_Login_Page()"
});
formatter.result({
  "duration": 16438665900,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.email_and_password_text_box_are_visible()"
});
formatter.result({
  "duration": 1264200,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_enters_username_and_passowrd()"
});
formatter.result({
  "duration": 11460515900,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_verifies_the_username_displayed_on_home_page()"
});
formatter.result({
  "duration": 26900,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_clicks_on_profile_button()"
});
formatter.result({
  "duration": 9349801200,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_is_navigated_to_profile_page()"
});
formatter.result({
  "duration": 5199145000,
  "status": "passed"
});
formatter.match({
  "location": "AllStepDefs.user_verifies_the_profile_details()"
});
formatter.result({
  "duration": 144800,
  "status": "passed"
});
});