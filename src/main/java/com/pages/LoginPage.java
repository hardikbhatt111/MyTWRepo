package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.MobileBaseClass;
import com.util.CommonTestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginPage extends MobileBaseClass{

	//android.widget.EditText[@text='Enter email address*']
			@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter email address*']")
			public WebElement emailTxt;
			
			
			//android.widget.EditText[@text='Enter Password*']
			@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='Enter Password*']")
			public WebElement passwordTxt;
			
			
			
			//android.widget.TextView[@text='Login']
			
			//android.view.ViewGroup[@index='2']
			
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Login']")
			public WebElement loginBtn;
			
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=' Logout ']")
			public WebElement logoutLink;
		
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Yes']")
			public WebElement yesBtn;
		
			@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='Profile']")
			public WebElement profileBtn;
			
			
			public LoginPage(AndroidDriver<AndroidElement> driver)
			{
				 PageFactory.initElements(driver, this);
			}
			
			public void login(String email, String passoword) throws Exception
			{
				Thread.sleep(7000);
				
				CommonTestUtil.waitForMobileElement(emailTxt, 10000, "email textBox is not present");
				emailTxt.sendKeys(email);
				
				CommonTestUtil.waitForMobileElement(passwordTxt, 10000, "passwordTxt is not present");
				passwordTxt.sendKeys(passoword);
				
				CommonTestUtil.waitForMobileElement(loginBtn, 10000, "loginBtn is not present");
				loginBtn.click();
				
				
			}
			
			public void logOut() throws Exception
			{
				Thread.sleep(3000);
				CommonTestUtil.waitForMobileElement(profileBtn, 10000, "email textBox is not present");
				
				profileBtn.click();
				
				Thread.sleep(2000);
				CommonTestUtil.waitForMobileElement(logoutLink, 10000, "email textBox is not present");
				logoutLink.click();
				
				//Thread.sleep(2000);
				CommonTestUtil.waitForMobileElement(yesBtn, 10000, "email textBox is not present");
				yesBtn.click();
					
				
			}
			
			
}
