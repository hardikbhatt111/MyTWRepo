package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.util.DriverEventListener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBaseClass {
	
public static AndroidDriver<AndroidElement> driver;

//public static AppiumDriver<AndroidElement> driver;
	
	public static String currentdir;
	public String configFileLoc;
	public static Properties propconfig;
	public static EventFiringWebDriver event;
	public static DriverEventListener driverListener;
	public static ArrayList<String> externalID = new ArrayList<String>();
	public static ArrayList<String> importNames = new ArrayList<String>();
	public static String copyFileLocation = null;
	String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12 = "";
	
	public MobileBaseClass()
	{
		
		try {
			
		System.out.println("BaseClass constructor called...."); 
		currentdir = System.getProperty("user.dir");
	  
		System.out.println("Current Directory...."+currentdir); 
		propconfig = new Properties();
				
		FileInputStream fp = new FileInputStream(currentdir+"/src/test/resources/com/config/config.properties"); propconfig.load(fp); }
		  	catch (IOException e) { e.printStackTrace(); System.out.println(e); 
		  	}
		 
	}
	
	public void launchEmulator() throws InterruptedException, MalformedURLException
	{		

	 System.out.println("launch emulator called.........");
	
	 File appDir = new File("lib");

     File app = new File(appDir, "v7.1_release.apk");
     DesiredCapabilities capabilities = new DesiredCapabilities();
     
     //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //Emulator
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RFCT60YV00V"); //My Real Device Name
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     capabilities.setCapability("adbExecTimeout", "70000");
     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
     capabilities.setCapability("platformVersion", "13.0");
     capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
   //capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.addwallet.activity.AddWalletActivity");
     capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.start.activity.RootHostActivity");
     
     driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    
     driver.findElement(By.id("com.wallet.crypto.trustapp:id/new_account_action")).click();
     
	 System.out.println("Button Clicked.........");
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	}	
	
	public void legalPage() throws InterruptedException, MalformedURLException
	{
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/acceptCheckBox")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/next")).click();
		 System.out.println("Legal Page Clicked.........");
	}
	
	public void setPasswordPage() throws InterruptedException, MalformedURLException
	{
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_01")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_02")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_03")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_04")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_05")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_06")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 System.out.println("Create Passcode Clicked.........");
	}
	
	public void confirmSetPasswordPage() throws InterruptedException, MalformedURLException
	{
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_01")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_02")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_03")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_04")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_05")).click();
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_06")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 System.out.println("Confirm Create Passcode Clicked.........");
		 
		 driver.findElement(By.id("com.wallet.crypto.trustapp:id/confirm_manual")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 System.out.println("Backup Manually Clicked.........");
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void setConsentPage() throws InterruptedException, MalformedURLException
	{
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/security_01")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/security_02")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/security_03")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_contiue")).click();
		System.out.println("Consent Button Clicked.........");
	}
	
	public void recoveryPhrasePage() throws InterruptedException, MalformedURLException
	{
		str1 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_01")).getText();
		str2 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_02")).getText();
		str3 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_03")).getText();
		str4 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_04")).getText();
		str5 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_05")).getText();
		str6 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_06")).getText();
		str7 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_07")).getText();
		str8 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_08")).getText();
		str9 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_09")).getText();
		str10 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_10")).getText();
		str11 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_11")).getText();
		str12 = driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_12")).getText();
		
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_contiue2")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Recovery Phrase Clicked.........");
	}
	
	public void confirmRecoveryPhrasePage() throws InterruptedException, MalformedURLException
	{
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_01")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_02")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_03")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_04")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_05")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_06")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_07")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_08")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_09")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_10")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_11")).click();
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/text_12")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertEquals("Well done!", driver.findElement(By.id("com.wallet.crypto.trustapp:id/success_text")).getText());
		
		driver.findElement(By.id("com.wallet.crypto.trustapp:id/btn_done")).click();
	}
}
