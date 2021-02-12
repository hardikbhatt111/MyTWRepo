package com.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.baseClass.MobileBaseClass;

import io.appium.java_client.android.AndroidDriver;

public class CommonTestUtil extends MobileBaseClass{
	
	static Workbook book;
	static Sheet sheet;
	
	public static void waitForMobileElement(final WebElement locator,
			int waitTime, String message) throws Exception {

		final FluentWait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver);
		//wait.pollingEvery(2, TimeUnit.SECONDS);
		//wait.withTimeout(waitTime, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		Function<AndroidDriver, WebElement> function = new Function<AndroidDriver, WebElement>() {
			public WebElement apply(AndroidDriver dr) {
				// System.out.println("Wait.......");
				wait.until(ExpectedConditions.visibilityOf(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return locator;
			}
		};
		//Thread.sleep(1000);
		wait.until(function);
	}
	
	public static void assertMessage(String Expected, String Actual) {
		try {
			Assert.assertEquals(Expected, Actual);
			System.out.println("Title Matched  " + Expected + "," + Actual);
		} catch (Exception e) {
		}

	}

	// method to read csv file( excel file )
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fp = null;
		try{
			fp = new FileInputStream("C:/Users/AjithB/workspace/Ecom/src/main/java/com/ecom/testData/EcomTestData.xlsx");
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try{
			book = WorkbookFactory.create(fp);
					
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i =0; i<sheet.getLastRowNum();i++){
			for(int k = 0; k<sheet.getRow(0).getLastCellNum();k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
			
		return data;
	}
	
	public static void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		System.out.println("Scrolled down...!!!");
	}
	
	
	public static void listViewScroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,850)", "");

		System.out.println("Scrolled down...!!!");
	}

	public static String getConfigProperties(String key) {
		Properties configfile = new Properties();

		try {
			configfile.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return configfile.getProperty(key);
	}

	public static void switchWindow() {

		String mainWindow = driver.getWindowHandle();

		driver.switchTo().window(mainWindow);

	}

	public static void waitForElementPresent(By locator, int waitTime, String message) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int i = 0; i < 60; i++) {
			try {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				break;
			} catch (Exception e) {
				System.out.println(message);
				Assert.fail(message);
			}
		}
	}

	public static void framewait(String frameName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frameName));
	}

	public static void isElementToBeClickable2(WebElement locator, int waitTime,
			String message) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int i = 0; i < 60; i++) {
			if (i <= 60) {

				// wait.until(ExpectedConditions.visibilityOfElementLocated((By)
				// locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				Thread.sleep(500);
				break;
			} else {
				System.out.println(message);
				Assert.fail(message);
			}
		}

	}

/*	public static void isElementToBeClickable(final WebElement locator,
			int waitTime, String message) throws Exception {

		final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		// wait.pollingEvery(2, TimeUnit.SECONDS);
		// wait.withTimeout(waitTime, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver dr) {
				// System.out.println("Wait.......");
				wait.until(ExpectedConditions.visibilityOf(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return locator;
			}
		};
		Thread.sleep(1000);
		wait.until(function);
	}*/

	public static void spinner() {

		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='ProcessingBox']/img")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By
				.xpath(".//*[@id='ProcessingBox']/img"))));
		/*
		 * if (locator != null) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 * System.out.println("Locator found"); }
		 */
		System.out.println("Spinner captured...");

	}

	// returns only date
	public static String Dateonly() {

		//Date d = new Date();
		Date date = Calendar.getInstance().getTime();  
	
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		//LocalDateTime now = LocalDateTime.now();  
		String Currentdate = dateFormat.format(date);
		System.out.println("Date to be entered :-"+Currentdate);
		return Currentdate;
		
		
		
		
	}
	
	
	
	public static String beforeDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date todate1 = cal.getTime();    
        String fromdate = dateFormat.format(todate1);
        
        return fromdate;
	}
	
	
	// returns only date
		public static Date getDate() {

			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			Date d = new Date();
			dateFormat.format(d);
			return d;
			 
		}
	
	

	public static String nonZeroDate(String fetchdate) {

		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		Date d = new Date();
		String Currentdate = dateFormat.format(d);
		return Currentdate;
	}

	/*public static boolean isClickable(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}*/

	/*public static void isAlertPresent(int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (Exception e) {
			System.out.println("No alert present");
		}
	}*/

	public static int Randomno() {
		Random rn = new Random();
		int num = rn.nextInt(10000);
		return num + 1;

	}
	
	
	public static void takeScreenShot() throws IOException
	{
		File fp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FactoryUtils.copyFile(fp, new File(currentDir+"\\Screenshots\\"+System.currentTimeMillis()+".png"));
		
		FileHandler.copy(fp, new File(currentDir+"\\Screenshots\\"+System.currentTimeMillis()+".png"));
		
	}
	
	
	public static void click(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, String value, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public static void wait(WebDriver driver, WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		//element.sendKeys(value);
		
	}
	
	public static void waitForElement(final WebElement locator,
			int waitTime, String message) throws Exception {

		final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		//wait.pollingEvery(2, TimeUnit.SECONDS);
		//wait.withTimeout(waitTime, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver dr) {
				// System.out.println("Wait.......");
				wait.until(ExpectedConditions.visibilityOf(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				return locator;
			}
		};
		//Thread.sleep(1000);
		wait.until(function);
	}
	
	
	// code to upload file using robot class
	
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
		

}
