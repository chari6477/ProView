package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.PatronAgreement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PatronAgreementSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	PatronAgreement patronAgreement = new PatronAgreement(driver);

	@When("^I agree to the patron agreement$")
	public void i_agree_to_the_patron_agreement()
	{
		patronAgreement.agree();
	}

	@Then("^I verify that the patron agreement is displayed$")
	public void i_verify_that_the_patron_agreement_is_displayed()
	{
		patronAgreement.verifyAgreement();
	}
}