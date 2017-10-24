package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.util.helpers.BaseObject;

public class PatronAgreement extends BaseObject
{
	/**
	 * Constructor for PatronAgreement
	 * 
	 * @param driver
	 */
	public PatronAgreement(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * Clicks the "I Agree" button in the patron agreement
	 * 
	 * @return
	 */
	public void agree()
	{
		click("PatronAgree", "id");
	}

	/**
	 * Verifies that the patron agreement is displayed
	 */
	public void verifyAgreement()
	{
		Assert.assertTrue(verifyElementIsDisplayed("PatronAgree", "id"));
	}
}