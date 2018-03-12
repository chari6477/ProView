package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Epub;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EpubSteps extends DriverFactory{

	WebDriver driver = getDriver();
	Epub epub = new Epub(driver);

	@Given("^Go to \"([^\"]*)\"$")
	public void go_to(String arg1) throws Throwable {
		epub.openUrl(arg1);
	}

	@When("^Search for: \"([^\"]*)\"$")
	public void search_for(String arg1) throws Throwable {
		epub.searchForBook(arg1);
	}

	@Then("^Click/tap the first result for \"([^\"]*)\"$")
	public void click_tap_the_first_result_for(String arg1) throws Throwable {
		epub.clickOnBook(arg1);
	}

	@Then("^Click/tap the \"([^\"]*)\" link to download the EPUB$")
	public void click_tap_the_link_to_download_the_EPUB(String arg1) throws Throwable {
		epub.clickLinkToDownload(arg1);
	}

	@When("^Import the EPUB into ProView$")
	public void import_the_EPUB_into_ProView() throws Throwable {
		epub.importEpub();
	}

	@Then("^Verify the title was imported successfully$")
	public void verify_the_title_was_imported_successfully() throws Throwable {
		epub.verifyTitle();
	}

	@Then("^Open the EPUB title$")
	public void open_the_EPUB_title() throws Throwable {
		System.out.println("");
		
	}

	@Then("^Navigate to the next page$")
	public void navigate_to_the_next_page() throws Throwable {
		epub.arrowForwardSymbol();
	}

	@Then("^Verify that the app goes to the correct page$")
	public void verify_that_the_app_goes_to_the_correct_page() throws Throwable {
		System.out.println("");
	}

	@When("^Return to the library$")
	public void return_to_the_library() throws Throwable {
		epub.backButtonSymbol();
	}

	@Then("^Delete the EPUB$")
	public void delete_the_EPUB() throws Throwable {
		epub.ok_RemoveTitle();
	}

	@Then("^Verify that the EPUB was deleted$")
	public void verify_that_the_EPUB_was_deleted() throws Throwable {

	}


}
