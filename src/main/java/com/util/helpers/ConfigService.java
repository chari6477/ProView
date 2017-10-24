package com.util.helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigService
{
	private static class ConfigServiceSingletonHolder
	{
		public static final ConfigService INSTANCE = new ConfigService();
	}

	public static String appPlatform = null;
	private static String appUnderTest = null;
	private static String baseImagePath = null;
	private static String chromeAppPath = null;
	private static String contentLayout = null;
	private static String defaultFont = null;
	private static String firefoxAppPath = null;
	private static String iexploreAppPath = null;
	private static String macAppPath = null;
	private static String password = null;
	private static String platform = null;
	private static String safariAppPath = null;
	private static String testEnvironment = null;
	private static String username = null;
	private static String windowsAppPath = null;
	private static final String propertiesFile = "resources/automation.properties";

	public static ConfigService getInstance()
	{
		return ConfigServiceSingletonHolder.INSTANCE;
	}

	private ConfigService()
	{
		Properties properties = new Properties();

		try
		{
			properties.load(new FileInputStream(propertiesFile));
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Could not load automation.properties file!");
			e.printStackTrace();
		}

		testEnvironment = properties.getProperty("testEnvironment");
		username = properties.getProperty("username");
		password = properties.getProperty("password");

		platform = properties.getProperty("platform");

		chromeAppPath = properties.getProperty("chromeAppPath");
		firefoxAppPath = properties.getProperty("firefoxAppPath");
		iexploreAppPath = properties.getProperty("iexploreAppPath");
		macAppPath = properties.getProperty("macAppPath");
		safariAppPath = properties.getProperty("safariAppPath");
		windowsAppPath = properties.getProperty("windowsAppPath");

		baseImagePath = properties.getProperty("baseImagePath");

		contentLayout = properties.getProperty("contentLayout");

		defaultFont = properties.getProperty("defaultFont");

		appPlatform = properties.getProperty("platform");
		appUnderTest = platform;
	}

	public String getAppUnderTest()
	{
		return appUnderTest;
	}

	public String getBaseImagePath()
	{
		return baseImagePath;
	}

	public String getChromeAppPath()
	{
		return chromeAppPath;
	}

	public String getContentLayout()
	{
		return contentLayout;
	}

	public String getDefaultFont()
	{
		return defaultFont;
	}

	public String getFirefoxAppPath()
	{
		return firefoxAppPath;
	}

	public String getIexploreAppPath()
	{
		return iexploreAppPath;
	}

	public String getMacAppPath()
	{
		return macAppPath;
	}

	public String getPassword()
	{
		return password;
	}

	public String getPlatform()
	{
		return platform;
	}

	public String getSafariAppPath()
	{
		return safariAppPath;
	}

	public String getTestEnvironment()
	{
		return testEnvironment;
	}

	public String getUsername()
	{
		return username;
	}

	public String getWindowsAppPath()
	{
		return windowsAppPath;
	}

	public void setAppUnderTest(String app)
	{
		appUnderTest = app;
	}
}