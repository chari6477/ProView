package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.CatalogTitlePreview;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CatalogTitlePreviewSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	CatalogTitlePreview catalogTitlePreview = new CatalogTitlePreview(driver);

	@When("^I return to the catalog search results$")
	public void i_return_to_the_catalog_search_results()
	{
		catalogTitlePreview.returnToCatalog();
	}

	@Then("^I verify that the title preview is displayed$")
	public void i_verify_that_the_title_preview_is_displayed()
	{
		catalogTitlePreview.verifyTitlePreview();
	}
}