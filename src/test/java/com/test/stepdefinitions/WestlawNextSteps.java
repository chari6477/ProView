package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.Title;
import com.util.pages.Westlaw;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WestlawNextSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	Westlaw westlaw = new Westlaw(driver);
	Title title = new Title(driver);

	@When("^I click the Continue button$")
	public void i_click_the_Continue_button()
	{
		westlaw.clickContinueBtn();
	}

	@When("^I go back to ProView$")
	public void i_go_back_to_ProView() throws InterruptedException
	{
		westlaw.goBackToProView();
	}

	@When("^I sign out of WestlawNext$")
	public void i_sign_out_of_WestlawNext()
	{
		westlaw.signOut();
	}

	@Then("^I verify that content contains \"(.*?)\"$")
	public void i_verify_that_content_contains(String text)
	{
		westlaw.verifyHeaderLabel(text);
	}

/*	@Then("^I verify that I am signed in to WestlawNext$")
	public void i_verify_that_I_am_signed_in_to_WestlawNext() throws InterruptedException
	{
		westlaw.verifyInWestLaw();
	}*/
	
}