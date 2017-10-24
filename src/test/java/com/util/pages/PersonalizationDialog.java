package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.util.helpers.BaseObject;

public class PersonalizationDialog extends BaseObject
{
	/**
	 * Constructor for PersonalizationDialog
	 * 
	 * @param driver
	 */
	public PersonalizationDialog(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * Enters a fake first name, last name, and email address before clicking Personalize
	 */
	public void personalize()
	{
		type("personalizeFN", "id", "Core");
		type("personalizeLN", "id", "Regression");
		type("personalizeEM", "id", "CoreRegression@tr.com");
		click("personalizeButton", "id");
	}

	/**
	 * Clicks the Sign Up button in the personalization dialog
	 * 
	 * @throws InterruptedException
	 */
	public void signUp() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForElementToBeClickable("signUpPersonalize", "css", 30);
		click("signUpPersonalize", "css");
	}

	/**
	 * Verifies that the personalization dialog is displayed
	 * @throws InterruptedException 
	 */
	public void verifyDialog()
	{
		waitForElementToBeClickable("personalizeFN", "id", 30);
		Assert.assertTrue(verifyElementIsDisplayed("personalizeFN", "id"));
	}
}