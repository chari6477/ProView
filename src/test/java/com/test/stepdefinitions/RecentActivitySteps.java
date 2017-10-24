package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.RecentActivity;

import cucumber.api.java.en.When;

public class RecentActivitySteps extends DriverFactory
{
	WebDriver driver = getDriver();
	RecentActivity recentActivity = new RecentActivity(driver);
	
	
	@When("^I open the title \"(.*?)\" via Recent Activity$")
	public void i_open_the_title_via_Recent_Activity(String title)
	{
		recentActivity.openTitle(title);
	}
}