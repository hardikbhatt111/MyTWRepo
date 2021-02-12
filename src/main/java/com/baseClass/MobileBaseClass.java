package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.util.DriverEventListener;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBaseClass {
	
public static AndroidDriver<AndroidElement> driver;
	
	public static String currentdir;
	public String configFileLoc;
	public static Properties propconfig;
	public static EventFiringWebDriver event;
	public static DriverEventListener driverListener;
	public static ArrayList<String> externalID = new ArrayList<String>();
	public static ArrayList<String> importNames = new ArrayList<String>();
	public static String copyFileLocation = null;
	
	
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
	
	public static void launchEmulator() throws InterruptedException, MalformedURLException
	{		

	 System.out.println("launch emulator called.........");
	 // TODO Auto-generated method stub
	 File appDir = new File("lib");
    
     
     // IntelliReflex
     File app = new File(appDir, "IntelliReflex.apk");
     DesiredCapabilities capabilities = new DesiredCapabilities();
     
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "IS_emulator");
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     
     //AppiumDriver
     

     // driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
     
     
     driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
     //driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
     //driver.manage().timeouts().
	}
		
	public static void quitApplication()
	{
		//driver.quit();
	}


}
