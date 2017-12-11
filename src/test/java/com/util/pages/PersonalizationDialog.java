package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public WebElement firstNameTxtField(){
		return findWebElementFromPropertyName("PersonalizationDialog_FirstName_TextField_ID");
	}

	public WebElement lastNameTxtField(){
		return findWebElementFromPropertyName("PersonalizationDialog_LastName_TextField_ID");
	}
	
	public WebElement emailTxtField(){
		return findWebElementFromPropertyName("PersonalizationDialog_Email_TextField_ID");
	}
	
	public WebElement personalizeBtn(){
		return findWebElementFromPropertyName("PersonalizationDialog_Personalize_Btn_ID");
	}
	/**
	 * Enters a fake first name, last name, and email address before clicking Personalize
	 */
	public void personalize()
	{
		enterText(firstNameTxtField(), "Core");
		enterText(lastNameTxtField(), "Regression");
		enterText(emailTxtField(),"CoreRegression@tr.com");
		clickWebElementByActionsClass(personalizeBtn());
		threadWait(5);
	}

	/**
	 * Clicks the Sign Up button in the personalization dialog
	 * 
	 * @throws InterruptedException
	 */
/*	public void signUp() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForElementToBeClickable("signUpPersonalize", "css", 30);
		click("signUpPersonalize", "css");
	}*/

	/**
	 * Verifies that the personalization dialog is displayed
	 * @throws InterruptedException 
	 */
	public void verifyDialog()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("PersonalizationDialog_FirstName_TextField_ID"));
		waitForElementToBeClickable(firstNameTxtField(), 30);
		
	}
}