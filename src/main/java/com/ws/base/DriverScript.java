package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class DriverScript {

	/*
	 * public driver reference which can be accessed across the project
	 */

	public static WebDriver driver;
     Properties prop;

	/*
	 * This constructor is responsible for loading properties file
	 */

	public DriverScript() {
		try 
		{
			File file = new File("./src/test/resources/configfile/config.properties");
			FileInputStream fis = new FileInputStream(file);
		    prop = new Properties();
			prop.load(fis);
		} 
		catch (Exception e)
		{
			System.out.println("unable to load properties file");
			e.printStackTrace();
		}
		
		/*
		 * this method is used to launch the browser and also apply all wait settings and
		 * also navigate to browser
		 */

	}
	
	 public void initApplication() 
	{
		 String browser = prop.getProperty("browser");
		 
		 
		 if(browser.trim().equalsIgnoreCase("chrome"))
		 {
			 System.out.println("Browser in use : "+browser);
			 driver = new ChromeDriver();
		 }
		 
		 else if(browser.trim().equalsIgnoreCase("firefox")) 
		 {
			 System.out.println("Browser in use : "+browser);
			 driver = new FirefoxDriver();
		 }
		 else if(browser.trim().equalsIgnoreCase("edge")) 
		 {
			 System.out.println("Browser in use : "+browser);
			 driver = new EdgeDriver();
		 }
		 else 
		 {
			 System.out.println("Unsupported browser type");
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		 driver.manage().timeouts().implicitlyWait(Duration.ofNanos(10));
		 getUrl();
	 }
	 /*
	  * this method is used to get the application url from the properties file
	  */
	 
	 public void getUrl() {
		 String url = prop.getProperty("url");
		 driver.get(url);
	 }
	 
	 /*
	  * this method is to quit the browser
	  */

	  public static void quitDriver() {
		  driver.quit();
	  }
}
