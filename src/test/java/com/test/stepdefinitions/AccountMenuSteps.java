package com.test.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.AccountMenu;

import cucumber.api.java.en.When;

public class AccountMenuSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	AccountMenu accountMenu = new AccountMenu(driver);

	@When("^I open the account menu$")
	public void i_open_the_account_menu() throws InterruptedException
	{
		Thread.sleep(2000);
		accountMenu.openAccountMenu();
	}

	@When("^I open the personalization dialog from the account menu$")
	public void i_open_the_personalization_dialog_from_the_account_menu() throws InterruptedException
	{
		accountMenu.clickPersonalize();
	}

	@When("^I sign out from the account menu$")
	public void i_sign_out_from_the_account_menu() throws InterruptedException
	{
		accountMenu.signOut();
	}
}