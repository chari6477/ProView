package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.OnePassRegistrationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OnePassRegistrationPageSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	OnePassRegistrationPage onePassRegPage = new OnePassRegistrationPage(driver);

	@When("^I click the Return to ProView button$")
	public void i_click_the_Return_to_ProView_button()
	{
		onePassRegPage.returnToProView();
	}

	@Then("^I verify that the reg key was generated$")
	public void i_verify_that_the_reg_key_was_generated() throws InterruptedException
	{
		onePassRegPage.verifyRegKeyGeneration();
	}
}