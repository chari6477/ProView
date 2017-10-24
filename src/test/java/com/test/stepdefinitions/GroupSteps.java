package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Group;

import cucumber.api.java.en.When;

public class GroupSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Group group = new Group(driver);
	
	@When("^I open the group panel for \"(.*?)\"$")
	public void i_open_the_group_panel_for(String groupMenu) throws InterruptedException
	{
		group.openGroupPanel(groupMenu);
	}
	
	@When("^I open the title \"(.*?)\" from the group menu$")
	public void i_open_the_title_from_the_group_menu(String titleName) throws InterruptedException
	{
		group.openTitleFromGroupPanel(titleName);
	}
}