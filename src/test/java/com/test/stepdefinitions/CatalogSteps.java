package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Catalog;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CatalogSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Catalog catalog = new Catalog(driver);

	@When("^I clear the catalog search$")
	public void i_clear_the_catalog_search()
	{
		catalog.clearSearch();
	}

	@When("^I execute a catalog search for \"(.*?)\"$")
	public void i_execute_a_catalog_search_for(String searchTerm)
	{
		catalog.executeSearch(searchTerm);
	}

	@When("^I open the catalog search result \"(.*?)\"$")
	public void i_open_the_catalog_search_result(String title)
	{
		catalog.openSearchResult(title);
	}

	@When("^I select the catalog \"(.*?)\"$")
	public void i_select_the_catalog(String catalogName) throws InterruptedException
	{
		catalog.selectCatalog(catalogName);
	}

	@Then("^I verify that the catalog search was cleared$")
	public void i_verify_that_the_catalog_search_was_cleared()
	{
		catalog.verifySearchCleared();
	}

	@Then("^I verify that I am in the catalog tab$")
	public void i_verify_that_the_catalog_tab_is_displayed()
	{
		catalog.verifyInCatalog();
	}
}