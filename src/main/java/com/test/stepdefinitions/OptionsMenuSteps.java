package com.test.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.OptionsMenu;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OptionsMenuSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	OptionsMenu optionsMenu = new OptionsMenu(driver);

	@When("^I click on \"(.*?)\" option of Options Menu$")
	public void i_click_on_the_option(String option) throws InterruptedException
	{
		optionsMenu.selectOption(option);
	}

	/*@When("^I click the Layout option$")
	public void i_click_the_Layout_option() throws InterruptedException
	{
		optionsMenu.openLayoutMenu();
	}*/

	@When("^I open the options menu$")
	public void i_open_the_options_menu() 
	{
		optionsMenu.open();
	}
	
	@When("^I close the options menu$")
	public void i_close_the_options_menu() throws InterruptedException
	{
		optionsMenu.open();
	}

	@When("^I select the color scheme \"(.*?)\"$")
	public void i_select_the_color_scheme(String colorScheme)
	{
		optionsMenu.selectColorScheme(colorScheme);
	}

	@When("^I select the \"(.*?)\" language$")
	public void i_select_the_language(String language)
	{
		optionsMenu.selectLanguage(language);
	}

	@When("^I select the \"(.*?)\" layout option$")
	public void i_select_the_option(String layoutOption) throws IOException, InterruptedException
	{
		optionsMenu.selectLayout(layoutOption);
	}

	@And("^I sign out$")
	public void i_sign_out() throws InterruptedException
	{
		optionsMenu.signOut();
	}

	@Then("^I verify that the user is unable to make any display changes$")
	public void i_verify_that_the_user_is_unable_to_make_any_display_changes()
	{
		optionsMenu.verifyCantMakeChangesToColorScheme();
	}
	

}