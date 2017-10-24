package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Library;
import com.util.pages.LibrarySearchAndFilter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LibrarySearchAndFilterSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Library libary = new Library(driver);
	LibrarySearchAndFilter filter = new LibrarySearchAndFilter(driver);

	@When("^I clear the \"(.*?)\" label$")
	public void i_clear_the_label(String labelName)
	{
		//the css part shouldnt be hard coded but it is
		filter.deleteSearchOrFilterLabel(labelName);
	}

	@When("^I clear the library search$")
	public void i_clear_the_library_search() throws InterruptedException
	{
		filter.clearFilter();
	}

	@When("^I execute a text search for \"(.*?)\"$")
	public void i_execute_a_text_search_for(String searchText) throws InterruptedException
	{
		filter.executeSearch(searchText);
	}

	@When("^I open the library search and filter panel$")
	public void i_open_the_library_search_and_filter_panel() throws InterruptedException
	{
		libary.closeBanner();
		filter.openSearchAndFilter();
	}

	@When("^I open the title \"(.*?)\" after filtering$")
	public void i_open_the_title_after_filtering(String titleName) throws InterruptedException
	{
		libary.openTitle(titleName);
	}

	@When("^I select \"(.*?)\" from the \"(.*?)\" dropdown$")
	public void i_select_from_the_dropdown(String selection, String dropDown) throws InterruptedException
	{
		filter.filterDropDown(dropDown, selection);
	}

	@Then("^I verify that the library search was cleared$")
	public void i_verify_that_the_library_search_was_cleared()
	{
		filter.verifyFilterDelete();
	}

	@Then("^I verify that the tag labeled \"(.*?)\" is displayed$")
	public void i_verify_that_the_tag_labeled_is_displayed(String tagText) throws InterruptedException
	{
		filter.verifyFilter(tagText);
	}

	@Then("^I verify that the title search \"(.*?)\" was executed$")
	public void i_verify_that_the_title_search_was_executed(String searchCondition)
	{
		filter.verifySearch(searchCondition);
	}
}