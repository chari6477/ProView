package com.util.helpers;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSetter
{
	PropertyReader properties = new PropertyReader();
	
	public DriverSetter()
	{
		
	}
	
	public WebDriver setDriver()
	{
		
		if(System.getProperty("Browser")==null){
			System.setProperty("Browser", properties.readProperty("platform"));
		}
		System.out.println("ForkNumber\t"+System.getProperty("Browser"));	
		switch(System.getProperty("Browser"))
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				HashMap<String, Object> plugin = new HashMap<String, Object>();
				plugin.put("enabled", false);
				plugin.put("name", "Chrome PDF Viewer");

				HashMap<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("plugins.plugins_list", Arrays.asList(plugin));	

				ChromeOptions options =new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				return new ChromeDriver(options);

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				return new FirefoxDriver(capabilities);
				
			case "IE":

				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
				return new InternetExplorerDriver(caps);
				
			case "mac":
				return new ChromeDriver();
				
			case "safari":
				return new SafariDriver();
				
			case "windows": //this isn't ready so the driver hasn't been downloaded or added to the project yet. If work on the webclient ever works then this will be need to reworked.
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\UC202647\\AppData\\Local\\Thomson Reuters\\ProView\\chromedriver2_server.exe");
				return new ChromeDriver();
				
			default:
				return new FirefoxDriver();
		}
	}
}