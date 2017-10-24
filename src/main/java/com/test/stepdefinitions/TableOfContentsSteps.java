package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.TableOfContents;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class TableOfContentsSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	TableOfContents toc = new TableOfContents(driver);

	@When("^I click the section \"(.*?)\"$")
	public void i_click_the_section(String tocSection) throws InterruptedException
	{
		try {
			toc.navigateToSection(tocSection);
		} catch (Exception e) {
			toc.navigateToFilteredEntry(tocSection);
		}
	}

	@And("^I close the TOC$")
	public void i_close_the_TOC()
	{
		toc.open();
	}

	@When("^I filter the table of contents by \"(.*?)\"$")
	public void i_filter_the_table_of_contents_by(String filterText)
	{
		toc.filterTOC(filterText);
	}

	@When("^I open the table of contents$")
	public void i_open_the_table_of_contents()
	{
		toc.open();
	}
}