package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.TitleSearch;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TitleSearchSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	TitleSearch titleSearch = new TitleSearch(driver);

	@When("^I click the first hit link with text \"(.*?)\"$")
	public void i_click_the_first_hit_link(String linkText)
	{
		titleSearch.goIntoTitleSearchFirstHit(linkText);
	}

	@When("^I click the Next Hit button$")
	public void i_click_the_Next_Hit_button()
	{
		titleSearch.goToNextHit();
	}

	@When("^I click the Previous Hit button$")
	public void i_click_the_Previous_Hit_button()
	{
		titleSearch.goToPreviousHit();
	}

	@When("^I click the Reset button$")
	public void i_click_the_Reset_button()
	{
		titleSearch.clearSearchResults();
		titleSearch.openTitleSearch();
	}

	@When("^I execute a keyWord search for \"(.*?)\"$")
	public void i_execute_a_keyWord_search_for(String text) throws InterruptedException
	{
		titleSearch.performKeyWordSearch(text);
	}

	@When("^I execute a thesaurus search for \"(.*?)\"$")
	public void i_execute_a_thesaurus_search_for(String text) throws InterruptedException
	{
		titleSearch.performThesaurusSearch(text);
	}

	@When("^I open the search menu$")
	public void i_open_the_search_menu()
	{
		titleSearch.openTitleSearch();
	}

	@Then("^I verify that the hit number \"(.*?)\" of text \"(.*?)\" is highlighted$")
	public void i_verify_that_the_hit_is_highlighted(String hitNumber, String hitValue)
	{
		titleSearch.validateSearchHitMarkers(hitNumber, hitValue);
	}

	@Then("^I verify that the hit number \"(.*?)\" of text \"(.*?)\" is not highlighted$")
	public void i_verify_that_the_hit_is_not_highlighted(String hitNumber, String hitValue)
	{
		titleSearch.verifyPresenceOfHitMarkers(hitNumber, hitValue);
	}
}