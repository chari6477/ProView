package com.util.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.util.helpers.BaseObject;

public class FileSaver extends BaseObject
{
	public FileSaver(WebDriver driver)
	{
		this.driver = driver;
	}

	//TODO figure out what is going on here
	public void saveFile()
	{
		if(readProperty("platform").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}
		if(readProperty("platform").equals("IE")){
			try {
				Runtime.getRuntime().exec("src/main/resources/Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}
		}
	}
}