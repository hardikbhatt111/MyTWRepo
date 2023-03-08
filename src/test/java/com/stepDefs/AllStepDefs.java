package com.stepDefs;

import com.baseClass.MobileBaseClass;
import cucumber.api.java.en.Given;


public class AllStepDefs extends MobileBaseClass {
	
	@Given("^user is on TrustWallet Home Page$")
	public void user_is_on_TrustWallet_Home_Page() throws Throwable {
	    
		launchEmulator();
	}
	
	@Given("^user is on TrustWallet Legal Page$")
	public void user_is_on_TrustWallet_Legal_Page() throws Throwable {
	    
		legalPage();
		System.out.println("user is on TrustWallet Legal Page");
	}
	
	@Given("^user is on TrustWallet SetPass Page$")
	public void user_is_on_TrustWallet_SetPass_Page() throws Throwable {
	    
		setPasswordPage();
		System.out.println("user is on TrustWallet SetPass Page");
	}
	
	@Given("^user is on TrustWallet ConfirmSetPass Page$")
	public void user_is_on_TrustWallet_ConfirmSetPass_Page() throws Throwable {
	    
		confirmSetPasswordPage();
		System.out.println("user is on TrustWallet ConfirmSetPass Page");
	}
	
	@Given("^user is on TrustWallet Consent Page$")
	public void user_is_on_TrustWallet_Consent_Page() throws Throwable {
	    
		setConsentPage();
		System.out.println("user is on TrustWallet Consent Page");
	}
	
	@Given("^user is on TrustWallet RecoveryPhrase Page$")
	public void user_is_on_TrustWallet_RecoveryPhrase_Page() throws Throwable {
	    
		recoveryPhrasePage();
		System.out.println("user is on TrustWallet RecoveryPhrase Page");
	}
	
	@Given("^user is on TrustWallet ConfirmRecoveryPhrase Page$")
	public void user_is_on_TrustWallet_ConfirmRecoveryPhrase_Page() throws Throwable {
	    
		confirmRecoveryPhrasePage();
		System.out.println("user is on TrustWallet ConfirmRecoveryPhrase Page");
	}
	
}
