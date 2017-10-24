package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.QuickTips;
import com.util.pages.Title;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuickTipsSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	QuickTips quickTip = new QuickTips(driver);
	Title title = new Title(driver);

	@When("^I click the quick tip refresh button$")
	public void i_click_the_quick_tip_refresh_button() throws InterruptedException
	{
		quickTip.performRefresh();
	}

	@Then("^I verify that the content in the quick tip contains \"(.*?)\"$")
	public void i_verify_that_the_content_in_the_quick_tip_contains(String text)
	{
		quickTip.verifyText(text);
	}
}