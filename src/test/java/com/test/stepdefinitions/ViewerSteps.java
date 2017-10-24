package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Viewer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewerSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Viewer viewer = new Viewer(driver);

	@Then("^I close the \"(.*?)\" viewer$")
	public void i_close_the_table_viewer(String typeOfViewer)
	{
		viewer.closeViewer(typeOfViewer);
	}


	@When("^I open the Create & Share PDF menu from the \"(.*?)\" viewer$")
	public void i_open_the_Create_Share_PDF_menu_from_the_image_viewer(String typeOfViewer) throws InterruptedException
	{
		viewer.openCreateAndShareMenuOfViewers(typeOfViewer);
	}



	@When("^I open the table viewer$")
	public void i_open_the_table_viewer()
	{
		viewer.openTableViewer();
	}

	@When("^I open the image viewer$")
	public void i_open_the_viewer()
	{
		viewer.openImageViewer();
	}

	@Then("^I verify that the viewer contains \"(.*?)\"$")
	public void i_verify_that_the_viewer_contains(String text)
	{
		viewer.verifyTableContents(text);
	}

	@Then("^I verify that the viewer contains the image$")
	public void i_verify_that_the_viewer_contains_the_image() throws InterruptedException
	{
		viewer.verifyImage();
		Thread.sleep(10000);
	}
	

}