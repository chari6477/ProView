package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.DetailsPanel;
import com.util.pages.Library;
import com.util.pages.Title;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DetailsPanelSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	DetailsPanel details = new DetailsPanel(driver);
	Library library = new Library(driver);
	Title title = new Title(driver);

	@When("^I add the category \"(.*?)\"$")
	public void i_add_the_category(String Text) throws InterruptedException
	{
		details.addCategory(Text);
	}

	@When("^I delete the category$")
	public void i_delete_the_category() throws InterruptedException
	{
		details.deleteCategory();
	}

	@When("^I open the details panel of \"(.*?)\"$")
	public void i_open_the_details_panel_of(String title) throws InterruptedException
	{
		details.openDetailsPanel(title, true);
	}
	
	@When("^I open the details panel of \"(.*?)\" to import annotations$")
	public void i_open_the_details_panel_of_title_to_import_annotations(String title) throws InterruptedException
	{
		details.openDetailsPanel(title, true);
	}
	

	@Then("^I verify that the category \"(.*?)\" is displayed$")
	public void i_verify_that_the_category_is_displayed(String text) throws InterruptedException
	{
		details.verifyPublisherCategory(text);
	}

	@Then("^I verify that the category \"(.*?)\" is not displayed$")
	public void i_verify_that_the_category_is_not_displayed(String text) throws InterruptedException
	{
		details.verifyUserCategoryDeleted(text);
	}

	@Then("^I verify that the user category \"(.*?)\" is displayed$")
	public void i_verify_that_the_user_category_is_displayed(String text) throws InterruptedException
	{
		details.verifyUserCategory(text);
	}
}