package com.altimetrik.core;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.altimetrik.util.FacebookUtil;

/**
 * This class is to Initialize WebDriver
 * @Author Gayatri Charchi
 * @Date: 15/12/2019
 */
public class FacebookBase {
	public static Properties prop;
	public static WebDriver driver;
	public static final String resourceDirPath = System.getProperty("user.dir")+System.getProperty("file.separator")
	                                             +"src"+System.getProperty("file.separator")+"resources";


	/* This is Default constructor */
	public FacebookBase() {
		try {
			prop = new Properties(); 
			FileInputStream fis = new FileInputStream(resourceDirPath+
								      System.getProperty("file.separator")+"Config.Properties");
			prop.load(fis);
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/* This method will lanuch the browser drivers */
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		String operatingSystemName = System.getProperty("os.name");
	
		//Launch Chrome Driver
		if(browserName.equalsIgnoreCase("Chrome")) {
			if(operatingSystemName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver",resourceDirPath+
						System.getProperty("file.separator")+"chromeDriver.exe");
			}
			else {
				System.setProperty("webdriver.chrome.driver",resourceDirPath+
						System.getProperty("file.separator")+"chromedriver");
			}
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		
		//Launch Firefox Driver
		else if(browserName.equalsIgnoreCase("firefox")){
			if(operatingSystemName.equalsIgnoreCase("windows")) {
			System.setProperty("webdriver.gecko.driver",resourceDirPath+
					System.getProperty("file.separator")+"firefoxDriver.exe");
			}
			else {
				System.setProperty("webdriver.gecko.driver",resourceDirPath+
						System.getProperty("file.separator")+"firefoxDriver");	
			}
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(FacebookUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FacebookUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
