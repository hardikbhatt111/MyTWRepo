package com.stepDefs;

import com.baseClass.MobileBaseClass;
import com.pages.LoginPage;
import com.pages.ProfilePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllStepDefs extends MobileBaseClass {
	
	LoginPage loginObj;
	ProfilePage profileObj;
	
	@Given("^user is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
	    
		MobileBaseClass.launchEmulator();
	}

	@When("^email and password text box are visible$")
	public void email_and_password_text_box_are_visible() throws Throwable {
		
		loginObj = new LoginPage(driver);
		System.out.println("email and passowrd text box are visible");
	}

	@Then("^user enters username and passowrd$")
	public void user_enters_username_and_passowrd() throws Throwable {
	    
		String user = propconfig.getProperty("username");
		String pass = propconfig.getProperty("password");
	    
		loginObj.login(user, pass);
	}

	@Then("^user verifies the username displayed on home page$")
	public void user_verifies_the_username_displayed_on_home_page() throws Throwable {
	    
	    
	}

	@Then("^user logs out$")
	public void user_logs_out() throws Throwable {
	    
		loginObj.logOut();
	}
	
	// ***************** //
	
	@Then("^user clicks on profile button$")
	public void user_clicks_on_profile_button() throws Throwable {
		profileObj = new ProfilePage(driver);
		profileObj.profileBtnClick();
		
		
	}

	@Then("^user is navigated to profile page$")
	public void user_is_navigated_to_profile_page() throws Throwable {
		
		profileObj.navigateToProfile();
	}

	@Then("^user clicks on view profile link$")
	public void user_clicks_on_view_profile_link() throws Throwable {
	    //profileObj.viewProfileBtn();
	}

	@Then("^user verifies the profile details\\.$")
	public void user_verifies_the_profile_details() throws Throwable {
	    
		profileObj.verifyProfileDetails();
	}

}
