package com.test.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.AnnotationsMenu;
import com.util.pages.Library;
import com.util.pages.Title;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TitleSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Title title = new Title(driver);
	Library library = new Library(driver);
	AnnotationsMenu annotationsMenu=new AnnotationsMenu(driver);

	@When("^I add a bookmark in the color \"(.*?)\" with the description \"(.*?)\"$")
	public void i_add_a_bookmark_in_the_color_with_the_description(String color, String description) throws InterruptedException
	{
		title.addBookmark(color, description);
	}

	@When("^I add a highlight in the color \"(.*?)\" by selecting the text \"(.*?)\"$")
	public void i_add_a_highlight_in_the_color_from_to(String color, String textToBeSelected) throws InterruptedException
	{
		
		title.highlightText(textToBeSelected);
		title.addHighlight();
		title.highlightColor(color);
	}

	@When("^I add a note from the highlight \"(.*?)\" with the text \"(.*?)\"$")
	public void i_add_a_note_from_the_highlight_with_the_text(String highlight, String noteText) throws InterruptedException
	{
		title.addNoteFromHighlight(highlight, noteText);
	}

	@When("^I add a note in the color \"(.*?)\" by selecting the text \"(.*?)\" with the description \"(.*?)\"$")
	public void i_add_a_note_in_the_color_from_to_with_the_text(String color, String textToBeSelected, String noteText) throws InterruptedException
	{
		title.highlightText(textToBeSelected);
		title.addeNote();
		title.addNoteText(noteText);
		title.selectNoteColor(color);
		title.saveNote();
	}

	@When("^I click on the footnote \"(.*?)\"$")
	public void i_click_on_the_footnote(String footnote)
	{
		title.clickFootnote(footnote);
	}

	@When("^I click the Continue button for Inter-book linking$")
	public void i_click_the_Continue_button_for_Inter_book_linking()
	{
		title.linkingContinue();
	}

	@When("^I click the displaced annotation$")
	public void i_click_the_displaced_annotation()
	{
		title.clickFirstDisplaced();
	}

	@When("^I click the link \"(.*?)\"$")
	public void i_click_the_link(String link)
	{
		title.clickLink(link);
	}

	@When("^I click the \"(.*?)\" option$")
	public void i_click_the_option(String selectedOption)
	{
		title.clickOption(selectedOption);
	}


	@When("^I close the running header$")
	public void i_close_the_running_header()
	{
		title.openOrCloseRunningHeader();
	}

	@When("^I create a displaced note by selecting the text \"(.*?)\"$")
	public void i_create_a_displaced_note_from_to(String text) throws InterruptedException
	{
		title.highlightText(text);
		title.addDisplacedAnnotation();
		annotationsMenu.openAnnotationsMenu();
	}

	@When("^I jump to page \"(.*?)\"$")
	public void i_jump_to_page(String pageNumber) throws InterruptedException
	{
		title.jumpToPage(pageNumber);
	}

	@When("^I navigate to the next page$")
	public void i_navigate_to_the_next_page() throws InterruptedException
	{
		title.nextPage();
	}

	@When("^I navigate to the previous page$")
	public void i_navigate_to_the_previous_page() throws InterruptedException
	{
		title.previousPage();
	}

	@When("^I open the running header$")
	public void i_open_the_running_header()
	{
		title.openOrCloseRunningHeader();
	}

	@When("^I return to the library$")
	public void i_return_to_the_library() throws InterruptedException
	{
		title.returnToLibrary();
	}

	@When("^I scroll to the bottom of the page$")
	public void i_scroll_to_the_bottom_of_the_page() throws InterruptedException
	{
		//this isn't needed
		//title.scrollToBottomOfPage();
	}

	@When("^I select the text \"(.*?)\"$")
	public void i_select_the_text(String text) throws InterruptedException
	{
		title.highlightText(text);
	}

	@When("^I slide the scrubber to the left edge$")
	public void i_slide_the_scrubber_to_the_left_edge()
	{
		title.scrubberLeft();
	}

	@When("^I slide the scrubber to the right edge$")
	public void i_slide_the_scrubber_to_the_right_edge()
	{
		title.scrubberRight();
	}

	@Then("^I verify that the content contains \"(.*?)\"$")
	public void i_verify_that_the_content_contains(String myText) throws InterruptedException
	{
		Assert.assertTrue(title.verifyTextOnPage(myText));
	}

	@Then("^I verify that the content does not contain \"(.*?)\"$")
	public void i_verify_that_the_content_does_not_contain(String text)
	{
		title.checkForAbsence(text);
	}


	@Then("^I verify that the footnote popover contains \"(.*?)\"$")
	public void i_verify_that_the_footnote_popover_contains(String text)
	{
		title.verifyFootnotePopoverContent(text);
	}

	@Then("^I verify that the sample title toast is displayed$")
	public void i_verify_that_the_sample_title_toast_is_displayed()
	{
		title.verifyTrialToast();
	}
	
	@Then("^I verify that the content is in the color scheme \"(.*?)\"$")
	public void i_verify_that_the_content_is_in_the_color_scheme(String colorScheme) throws InterruptedException
	{
		title.verifyColorScheme(colorScheme);
	}
}