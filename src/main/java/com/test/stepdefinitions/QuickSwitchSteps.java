package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Library;
import com.util.pages.QuickSwitch;

import cucumber.api.java.en.When;

public class QuickSwitchSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	QuickSwitch quickSwitch = new QuickSwitch(driver);
	Library library=new Library(driver);

	@When("^I open the quick switch$")
	public void i_open_the_quick_switch()
	{
		quickSwitch.open();
	}

	@When("^I open the title \"(.*?)\" via Quick Switch$")
	public void i_open_the_title_via_Quick_Switch(String titleName)
	{
		library.openTitle(titleName);
	}
}