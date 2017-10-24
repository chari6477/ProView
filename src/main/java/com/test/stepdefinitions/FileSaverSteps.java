package com.test.stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.FileSaver;

import cucumber.api.java.en.When;

public class FileSaverSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	FileSaver fileSaver = new FileSaver(driver);
	
	@When("^I save the file$")
	public void i_save_the_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.saveFile();
	}

	@When("^I save the PDF$")
	public void i_save_the_PDF() throws IOException, InterruptedException, AWTException
	{
		fileSaver.saveFile();
	}
}
