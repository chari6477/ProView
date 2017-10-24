package com.test.stepdefinitions;

import com.util.helpers.DriverFactory;
import com.util.pages.ImportAnnotationsDialog;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ImportAnnotationsDialogSteps extends DriverFactory
{
	ImportAnnotationsDialog dialog = new ImportAnnotationsDialog(driver);
	
	@When("^I click the Close button$")
	public void i_click_the_Close_button() throws InterruptedException
	{
		dialog.close();
	}
	
	@When("^I click the Import Annotations link$")
	public void i_click_the_Import_Annotations_link() throws InterruptedException
	{
		dialog.openImportAnnotationsDialog();
	}

	@When("^I click the Import button$")
	public void i_click_the_Import_button() throws InterruptedException
	{
		dialog.clickImportButton();
	}
	
	@When("^I select \"(.*?)\" from the Import Annotations menu$")
	public void i_select_from_the_Import_Annotations_menu(String source) throws InterruptedException
	{
		dialog.selectAnnotationsSource(source);
	}

	@Then("^I verify that the annotations were imported$")
	public void i_verify_that_the_annotations_were_imported() throws InterruptedException
	{
		dialog.verfiyImportCompleted();
	}
}