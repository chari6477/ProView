package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Library;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LibrarySteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Library library = new Library(driver);

	@When("^I clear the title or author filter box$")
	public void i_clear_the_title_or_author_filter_box()
	{
		library.clearSearch();
	}

	@When("^I click the library tab$")
	public void i_click_the_All_tab() throws InterruptedException
	{
		library.clickLibraryButton();
	}

	@When("^I click the Catalog tab$")
	public void i_click_the_Catalog_tab()
	{
		library.clickCatalogButton();
	}

	@When("^I click the eReference tab$")
	public void i_click_the_eReference_tab() throws InterruptedException
	{
		library.clickeReferenceButton();
	}

	@When("^I click the \"(.*?)\" button$")
	public void i_click_the_Next_Page_button(String navType)
	{
		library.navigateTo(navType);
	}

/*	@When("^I click the Previous Page button$")
	public void i_click_the_Previous_Page_button()
	{
		library.navigateToPreviousPage();
	}*/

	@When("^I enter the text \"(.*?)\" in the title or author filter box$")
	public void i_enter_the_text_in_the_title_or_author_filter_box(String text) throws InterruptedException
	{
		library.filterTitlesByText(text);
	}

	@When("^I open the title \"(.*?)\"$")
	public void i_open_the_title(String titleName)
	{
		library.openTitle(titleName);
	}
	
	@When("^I open the title \"(.*?)\" in current page$")
	public void i_open_the_title_in_(String titleName)
	{
		library.openTitleByScrolling(titleName);
	}

	@When("^I switch to \"(.*?)\" view$")
	public void i_switch_to_view(String libraryView)
	{
		library.switchToLibraryView();
	}

	@Then("^I verify that I am in the library$")
	public void i_verify_that_I_am_in_the_library() throws InterruptedException
	{
		library.verifyInLibrary();
	}

	@Then("^I verify that the due date is displayed$")
	public void i_verify_that_the_due_date_is_displayed()
	{
		library.verifyDueDate();
	}

	@Then("^I verify that the library is sorted by \"(.*?)\"$")
	public void i_verify_that_the_library_is_sorted_by(String sortType)
	{
		library.verifySort(sortType);
	}

	@Then("^I verify that the \"(.*?)\" button is displayed$")
	public void i_verify_that_the_Nav_button_is_displayed(String buttonName)
	{
		library.verifyNavigationButtonIsDisplayed(buttonName);
	}

	@Then("^I verify that the title \"(.*?)\" is displayed$")
	public void i_verify_that_the_title_is_displayed(String title)
	{
		library.verifyTitleExists(title);
		try{
			library.clearText(library.filterByNameOrAuthorTextFld());
		}catch(Exception e){
			System.out.println("Clear Not Found");
		}
	}
	
	@Then("^I verify that the title \"(.*?)\" is displayed in current page$")
	public void i_verify_that_the_title_is_displayed_in_current_page(String title)
	{
		library.titleByScrolling(title, false);
		
	}

	@Then("^I verify that the titles are displayed in \"(.*?)\" view$")
	public void i_verify_that_the_titles_are_displayed_in(String libraryView)
	{
		library.verifyLibraryView(libraryView);
	}
}