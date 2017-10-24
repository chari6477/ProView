package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Westlaw</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Westlaw extends BaseObject
{

	/**
	 * This method constructs the Object of <b>Westlaw</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Westlaw(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Westlaw_ContinueBtn_XPATH</b>.
	 */
	public WebElement continueBtn(){
		return findWebElementFromPropertyName("Westlaw_ContinueBtn_XPATH");
	}
	
	/**
	 * Clicks on continue button to move to next page of westlaw.
	 */
	public void clickContinueBtn()
	{
		clickWebElement(continueBtn());
	}
	
	/**
	 * Check for header labels of Westlaw site.
	 * @param label Should be any one of headers present in Westlaw site.
	 * @return WebElement for the property named <b>Westlaw_HeaderLabel_XPATH</b>.
	 */
	public WebElement headerLabel(String label){
		return findWebElementFromPropertyName("Westlaw_HeaderLabel_XPATH",label);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Westlaw_SignOffBtn_XPATH</b>.
	 */
	public WebElement signOffBtn(){
		return findWebElementFromPropertyName("Westlaw_SignOffBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Westlaw_UserProfileBtn_XPATH</b>.
	 */
	public WebElement userProfileBtn(){
		return findWebElementFromPropertyName("Westlaw_UserProfileBtn_XPATH");
	}
	
	/**
	 * Used to Go Back to Proview.
	 * @throws InterruptedException
	 */
	public void goBackToProView() throws InterruptedException
	{
		driver.switchTo().window(currentTab);		
	}

	/**
	 * Used to Sign Off from the Westlaw Site.
	 */
	public void signOut()
	{
		clickWebElement(userProfileBtn());
		clickWebElement(signOffBtn());
	}

	/**
	 * Verifies header label of westlaw site.
	 * @param label Should be any one of the header label from list of header labels.
	 */
	public void verifyHeaderLabel(String label)
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Westlaw_HeaderLabel_XPATH", label));
	}
}