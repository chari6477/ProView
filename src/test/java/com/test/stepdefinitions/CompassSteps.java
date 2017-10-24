package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Title;

import cucumber.api.java.en.Then;

public class CompassSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Title title = new Title(driver);

	@Then("^I verify that the compass with the title \"(.*?)\" is available on page$")
	public void i_verify_that_the_compass_contains_the_text(String compassMarkerText)
	{
		title.verifyCompassText(compassMarkerText);
	}
}