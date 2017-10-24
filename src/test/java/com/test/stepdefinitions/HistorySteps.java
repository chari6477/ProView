package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.History;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HistorySteps extends DriverFactory
{
	WebDriver driver = getDriver();
	History history = new History(driver);

	@When("^I click the Back button$")
	public void i_click_the_Back_button()
	{
		history.clickBackButton();
	}

	@When("^I click the first history item$")
	public void i_click_the_first_history_item()
	{
		history.clickFirstItem();
	}

	@When("^I click the Forward button$")
	public void i_click_the_Forward_button() throws InterruptedException
	{
		history.clickForwardButton();
	}

	@When("^I open the history menu$")
	public void i_open_the_history_menu() throws InterruptedException
	{
		history.openHistoryMenu();
	}

	@Then("^I verify that the history item for page \"(.*?)\" is displayed$")
	public void i_verify_that_the_history_item_for_page_is_displayed(String text)
	{
		history.verifyHistoryItem(text);
	}
}