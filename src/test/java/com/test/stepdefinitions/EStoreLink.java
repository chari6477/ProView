package com.test.stepdefinitions;

import com.util.helpers.DriverFactory;
import com.util.pages.EstoreLink_Page;
import com.util.pages.SignIn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EStoreLink extends DriverFactory{
	
	EstoreLink_Page esl = new EstoreLink_Page(driver);
	SignIn signIn = new SignIn(driver);
	
	@Given("^Paste this URL into a browser tab and hit Enter \"([^\"]*)\"$")
	public void paste_this_URL_into_a_browser_tab_and_hit_Enter(String url) throws Throwable {
	   esl.launchBrowserWithGivenURL(url);
	}

	@When("^Select \"([^\"]*)\"$")
	public void select(String arg1) throws Throwable {
	  esl.launchProviewAs(arg1);
	}

	@When("^Click on the \"([^\"]*)\" button$")
	public void click_on_the_button(String arg1) throws Throwable {
	  esl.clcikOnLaunchProviewBtn(arg1);
	}
	
	@When("^Click on the \"([^\"]*)\" buttons$")
	public void click_on_the_buttons(String arg1) throws Throwable {
	  esl.clcikOnLaunchProviewBtns(arg1);
	}

	@When("^You can either select \"([^\"]*)\" \\(as OnePass\\) or \"([^\"]*)\" \\(as IP\\)$")
	public void you_can_either_select_as_OnePass_or_as_IP(String arg1, String arg2) throws Throwable {
	   esl.clcikOnLoginwithmyOnePassaccount(arg1);
	}

	@When("^If you chose \"([^\"]*)\", enter credentials and click on the Sign In button$")
	public void if_you_chose_enter_credentials_and_click_on_the_Sign_In_button(String arg1) throws Throwable {
		signIn.signInAction();
	}

	@Then("^At the library page, verify a dialog is displayed and it includes: The text \"([^\"]*)\"$")
	public void at_the_library_page_verify_a_dialog_is_displayed_and_it_includes_The_text(String arg1) throws Throwable {
	 esl.verifyTextIsPresent(arg1);
	}

	@Then("^A Visit Store button$")
	public void a_Visit_Store_button() throws Throwable {
	 esl.verifyButtonIsPresent("Visit Store");
	}

	@Then("^A Cancel link$")
	public void a_Cancel_link() throws Throwable {
	  esl.verifyLinkIsPresent("Cancel");
	}

	@When("^Click on the Visit Store button$")
	public void click_on_the_Visit_Store_button() throws Throwable {
	   esl.clickOnEstoreBtn();
	}

	@Then("^Verify the user is taken to the Google\\.com page in a new browser window$")
	public void verify_the_user_is_taken_to_the_Google_com_page_in_a_new_browser_window() throws Throwable {
	  esl.verifyUrl();
	}

	@Then("^Verify the ProView browser window no longer shows the dialog$")
	public void verify_the_ProView_browser_window_no_longer_shows_the_dialog() throws Throwable {
	  esl.verifyDialogIsNotDisplayed();
	}



}
