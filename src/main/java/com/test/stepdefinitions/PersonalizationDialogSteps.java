package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.PersonalizationDialog;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PersonalizationDialogSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	PersonalizationDialog personalizationDialog = new PersonalizationDialog(driver);

	@When("^I click the sign up button$")
	public void i_click_the_sign_up_button() throws InterruptedException
	{
		personalizationDialog.signUp();
	}

	@When("^I personalize$")
	public void i_personalize()
	{
		personalizationDialog.personalize();
	}

	@Then("^I verify that the personalization dialog is displayed$")
	public void i_verify_that_the_personalization_dialog_is_displayed()
	{
		personalizationDialog.verifyDialog();
	}
}