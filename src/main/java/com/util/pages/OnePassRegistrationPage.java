package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>OnePassRegistrationPage</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class OnePassRegistrationPage extends BaseObject
{
	/**
	 * This method constructs the Object of <b>History</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public OnePassRegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>OnePassRegistrationPage_BackToProViewBtn_XPATH</b>.
	 */
	public WebElement backToProViewBtn(){
		return findWebElementFromPropertyName("OnePassRegistrationPage_BackToProViewBtn_XPATH");
	}
	
	/**
	 * Clicks the "Return to ProView" button
	 */
	public void returnToProView()
	{
		clickWebElement(backToProViewBtn());
	}

	/**
	 * Verifies that a reg key was generated
	 * @throws InterruptedException 
	 */
	public void verifyRegKeyGeneration() throws InterruptedException
	{
		Assert.assertTrue(verifyTextOnPage("Registration key"));
	}
}