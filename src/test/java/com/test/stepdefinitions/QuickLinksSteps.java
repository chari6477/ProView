package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.QuickLinks;
import com.util.pages.Title;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuickLinksSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	QuickLinks quickLinks = new QuickLinks(driver);
	Title title = new Title(driver);

	@When("^I click the \"(.*?)\" link$")
	public void i_click_the_link(String link) throws InterruptedException
	{
		quickLinks.navigateToLink(link);
	}

	@Then("^I close the quick links menu$")
	public void i_close_the_quick_links_menu()
	{
		quickLinks.open();
	}

	@When("^I open the quick links menu$")
	public void i_open_the_quick_links_menu()
	{
		quickLinks.open();
	}

	@When("^I select the \"(.*?)\" set$")
	public void i_select_the_set(String listSet)
	{
		quickLinks.selectSet(listSet);
	}
	
	@When("^I click the \"(.*?)\" quick link$")
	public void i_click_the_quick_link(String quickLink) throws InterruptedException
	{
		quickLinks.navigateToLink(quickLink);
	}

	@Then("^I verify that the content reads \"(.*?)\"$")
	public void i_verify_that_the_content_reads(String pageText) throws InterruptedException
	{
		title.verifyTextOnPage(pageText);
	}
}