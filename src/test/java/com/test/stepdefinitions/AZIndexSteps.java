package com.test.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.util.helpers.DriverFactory;
import com.util.pages.AZIndex;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.When;
import gherkin.deps.net.iharder.Base64;

public class AZIndexSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	AZIndex index = new AZIndex(driver);
	
	
	@When("^I click the \"(.*?)\" index link$")
	public void i_click_the_index_link(String menu) throws InterruptedException
	{
		index.clickIndexLinkEntry(menu);
		index.openIndex();
	}

	@When("^I click the letter \"(.*?)\"$")
	public void i_click_the_letter(String letter) throws InterruptedException
	{
		index.selectLetter(letter);
	}

	@When("^I open the A-Z index$")
	public void i_open_the_A_Z_index()
	{
		index.openIndex();
	}
	
/*	@After
	public void after(Scenario scenario) throws IOException{
		System.out.println("Basha");
	    if (scenario.isFailed()) {
	    	System.out.println("Basha2");
	        // Take a screenshot...
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        Reporter.addScreenCaptureFromPath( "data:image/png;base64,"+Base64.encodeBytes(screenshot));
	        scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	      }
	}*/
}