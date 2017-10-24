package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.AnnotationsMenu;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AnnotationsMenuSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	AnnotationsMenu annotationsMenu = new AnnotationsMenu(driver);
	
	@When("^I click the highlight in the annotations menu$")
	public void i_click_on_the_the_highlight_in_the_annotations_menu_for_highlight() throws InterruptedException
	{
		annotationsMenu.navigateToAnnotation();
	}

	@When("^I click the bookmark in the annotations menu$")
	public void i_click_the_bookmark_in_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.navigateToAnnotation();
	}

	@When("^I click the note in the annotations menu$")
	public void i_click_the_note_in_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.filterByCategory("Notes");
		annotationsMenu.navigateToAnnotation();
	}

	@When("^I delete the bookmark from the annotations menu$")
	public void i_delete_the_bookmark_from_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.deleteAnnotation();
	}
	
	@When("^I delete the highlight from the annotations menu$")
	public void i_delete_the_highlight_from_the_annotations_menu_for_highlight() throws InterruptedException
	{
		annotationsMenu.navigateToAnnotation();
		annotationsMenu.deleteAnnotation();
	}

	@When("^I delete the note from the annotations menu$")
	public void i_delete_the_note_from_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.deleteAnnotation();
	}

	@When("^I open the annotations color filter$")
	public void i_open_the_annotations_color_filter() throws InterruptedException
	{
		annotationsMenu.openColorFilter();
	}

	@When("^I select the \"(.*?)\" filter option$")
	public void i_select_the_filter_option(String color) throws InterruptedException
	{
		annotationsMenu.filterByColor(color);
	}

	@Then("^I verify that the bookmark is displayed in the annotations menu$")
	public void i_verify_that_the_bookmark_is_displayed_in_the_annotations_menu()
	{
		annotationsMenu.verifyAnnotationIsDisplayed();
	}

	@Then("^I verify that the bookmark is not displayed in the annotations menu$")
	public void i_verify_that_the_bookmark_is_not_displayed_in_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.verifyAnnotationIsDeleted();
		annotationsMenu.openAnnotationsMenu();
	}

	@Then("^I verify that the highlight is displayed in the annotations menu$")
	public void i_verify_that_the_highlight_is_displayed_in_the_annotations_menu_for_highlight()
	{
		annotationsMenu.verifyAnnotationIsDisplayed();
	}

	@Then("^I verify that the highlight is not displayed in the annotations menu$")
	public void i_verify_that_the_highlight_is_not_displayed_in_the_annotations_menu_for_highlight() throws InterruptedException
	{
		annotationsMenu.verifyAnnotationIsDeleted();
		annotationsMenu.openAnnotationsMenu();
	}
	
	@Then("^I verify that the note is displayed in the annotations menu$")
	public void i_verify_that_the_note_is_displayed_in_the_annotations_menu()
	{
		annotationsMenu.verifyAnnotationIsDisplayed();
	}

	@Then("^I verify that the note is not displayed in the annotations menu$")
	public void i_verify_that_the_note_is_not_displayed_in_the_annotations_menu() throws InterruptedException
	{
		annotationsMenu.verifyAnnotationIsDeleted();
		annotationsMenu.openAnnotationsMenu();
	}
	
	@When("^I open the annotations menu$")
	public void i_open_the_annotations_menu() throws InterruptedException
	{
		Thread.sleep(2000);
		annotationsMenu.openAnnotationsMenu();
	}
	
	@When("^I open the displaced annotations menu$")
	public void i_open_the_displaced_annotations_menu() throws InterruptedException
	{
		annotationsMenu.openDisplacedAnnotations();
	}
}