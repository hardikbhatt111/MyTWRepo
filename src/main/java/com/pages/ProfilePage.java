package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.MobileBaseClass;
import com.util.CommonTestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProfilePage extends MobileBaseClass{
	
	//android.widget.Button[@text='Enter email address*']
		//android.widget.TextView[@text='Profile']
		
		//android.widget.TextView[@text=' Logout ']
		//android.widget.TextView[@text='Yes']
		
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=' Logout ']")
			public WebElement logoutLink;
		
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Yes']")
			public WebElement yesBtn;
		
				@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Profile']")
				public WebElement profileBtn;
				
				//android.widget.TextView[@text='Ajit B']
				@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Profile']")
				public WebElement userName;
				
				//android.widget.TextView[@text='View Profile']
				@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='View Profile']")
				public WebElement viewProfileBtn;
				
				
				//android.widget.EditText[@text='Enter Password*']
				@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter Password*']")
				public WebElement passwordTxt;
				
				public ProfilePage(AndroidDriver<AndroidElement> driver) 
				{
					 PageFactory.initElements(driver, this);
				}
				
				public void profileBtnClick() throws Exception
				{
					Thread.sleep(4000);
					
					CommonTestUtil.waitForMobileElement(profileBtn, 10000, "profileBtn is not present");
					
					profileBtn.click();
					
				}
				
				public void navigateToProfile() throws Exception
				{
					Thread.sleep(4000);
					CommonTestUtil.waitForMobileElement(viewProfileBtn, 10000, "viewProfileBtn is not present");
					viewProfileBtn.click();		
				}
				
				public void verifyProfileDetails()
				{
					System.out.println("Profile details.....");
					
					
				}
				

}
