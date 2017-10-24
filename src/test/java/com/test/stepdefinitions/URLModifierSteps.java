package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.URLModifier;

import cucumber.api.java.en.When;

public class URLModifierSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	URLModifier urlModifier = new URLModifier(driver);

	@When("^I change the language to \"(.*?)\" via the URL$")
	public void i_change_the_language_to_via_the_URL(String language) throws InterruptedException
	{
		urlModifier.changeLanguage(language);
	}
}