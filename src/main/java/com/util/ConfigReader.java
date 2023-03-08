package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

private Properties prop;
	
	public static String currentdir;
	public String configFileLoc;
	public static Properties propconfig;

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	
	
	
	
	  public Properties read_prop() {
	  
	  try {
	  
	  System.out.println("DriverFactory constructor called...."); currentdir =
	  System.getProperty("user.dir");
	  
	  System.out.println("Current Directory...."+currentdir); propconfig = new
	  Properties();
	  
	  FileInputStream fp = new
	  FileInputStream(currentdir+"/src/test/resources/config/config.properties");
	  propconfig.load(fp); }
	  
	  catch (IOException e) { e.printStackTrace(); System.out.println(e); }
	  return prop;
	  
	  }
	 
}
