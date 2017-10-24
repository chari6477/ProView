package com.util.helpers;

import org.openqa.selenium.WebDriver;

public class DriverFactory
{
	protected static WebDriver driver;
	DriverSetter setter = new DriverSetter();

	public DriverFactory()
	{
		initialize();
	}

	private void createNewDriverInstance()
	{
		driver = setter.setDriver();
	}

	public void destroyDriver()
	{
		
		driver.close();
		try{
			driver.quit();
		}catch(Exception e){
			
		}
		driver = null;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public void initialize()
	{
		if(driver == null)
		{
			createNewDriverInstance();
		}
	}
}