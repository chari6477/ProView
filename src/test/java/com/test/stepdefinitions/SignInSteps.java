package com.test.stepdefinitions;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.util.helpers.AppLauncher;
import com.util.helpers.DriverFactory;
import com.util.pages.SignIn;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSteps extends DriverFactory
{
	
	WebDriver driver = getDriver();   
	AppLauncher launcher = new AppLauncher(driver);
	SignIn signIn = new SignIn(driver);

	@Then("^I close the app$")
	public void i_close_the_app()
	{
		launcher.closeProView();
	}

	@When("^I launch ProView$")
	public void i_launch_ProView() throws InterruptedException, IOException
	{
		launcher.launchProView();
	}

	@When("^I launch ProView via deep linking$")
	public void i_launch_ProView_via_deep_linking() throws InterruptedException
	{
		launcher.launchDeepLinking();
	}

	@When("^I launch ProView via freemium non-trial$")
	public void i_launch_ProView_via_freemium_non_trial() throws InterruptedException
	{
		launcher.launchFreemiumNon();
	}

	@When("^I launch ProView via freemium trial$")
	public void i_launch_ProView_via_freemium_trial() throws InterruptedException
	{
		launcher.launchFreemium();
	}

	@When("^I launch ProView via IP$")
	public void i_launch_ProView_via_IP()
	{
		launcher.launchIPAuthentication();
	}

	@When("^I launch ProView via IP with email$")
	public void i_launch_ProView_via_IP_with_email()
	{
		launcher.launchIPAuthenticationWithEmail();
	}

	@When("^I launch ProView via IPP$")
	public void i_launch_ProView_via_IPP()
	{
		launcher.launchIPPAuthentication();
	}

	@When("^I sign in$")
	public void i_sign_in() throws InterruptedException
	{
		signIn.signInAction();
	}

	@When("^I sign in to view the deep link$")
	public void i_sign_in_to_view_the_deep_link() throws InterruptedException
	{
		signIn.signInAction();
	}

	@When("^I sign in using a checkout code$")
	public void i_sign_in_using_a_checkout_code() throws ClientProtocolException, IOException, JSONException, InterruptedException
	{
		signIn.signInToProViewUsingCheckoutCode();
	}

	@Then("^I verify that I am on the sign in page$")
	public void i_verify_that_I_am_on_the_sign_in_page()
	{
		signIn.verifyLogo();
	}
}