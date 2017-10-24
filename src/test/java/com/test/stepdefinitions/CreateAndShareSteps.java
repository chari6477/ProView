package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.CreateAndShare;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAndShareSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	CreateAndShare createAndShare = new CreateAndShare(driver);

	@When("^I click the create and share Next button$")
	public void i_click_the_create_and_share_Next_button() throws InterruptedException
	{
		createAndShare.createPDF();
	}

	@When("^I click the Next button$")
	public void i_click_the_Next_button() throws InterruptedException
	{
		createAndShare.createPDF();
	}

	@When("^I open the Create & Share menu$")
	public void i_open_the_Create_Share_PDF_menu() throws InterruptedException
	{
		createAndShare.openCreateAndShareMenu();
	}

	@When("^I select the \"(.*?)\" from the sub menu$")
	public void i_select_the_from_the_sub_menu(String option) throws InterruptedException
	{
		createAndShare.selectShareType(option);
	}

	@When("^I select the \"(.*?)\" pdf option$")
	public void i_select_the_pdf_option(String option) throws InterruptedException
	{
		createAndShare.selectContent(option);
	}

	@Then("^I verify that the \"(.*?)\" option is selected$")
	public void i_verify_that_the_option_is_selected(String option)
	{
		createAndShare.verifyContentSelection(option);
		
	}
}