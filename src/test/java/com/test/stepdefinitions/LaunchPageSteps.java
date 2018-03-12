package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.LaunchPage;
import com.util.pages.SignIn;

import cucumber.api.java.en.When;

public class LaunchPageSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	LaunchPage launchPage = new LaunchPage(driver);
	SignIn signIn = new SignIn(driver);

	@When("^I click the Launch ProView button$")
	public void i_click_the_button() throws InterruptedException
	{
		launchPage.launchApp();
		try {
			signIn.clickWebElement(signIn.cookieContinueLink());
		} catch (Exception e) {
			System.out.println("Cookie Continue Link Not Present");
		}
	}

	@When("^I select the \"(.*?)\" option for deep linking$")
	public void i_select_the_option_for_deep_linking(String app) throws InterruptedException
	{
		launchPage.selectApp(app);
	}
}