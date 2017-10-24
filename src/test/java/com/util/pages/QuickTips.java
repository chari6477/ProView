package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>QuickTips</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class QuickTips extends BaseObject
{
	/**
	 * This method constructs the Object of <b>QuickTips</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public QuickTips(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>QuickTips_RefreshBtn_XPATH</b>.
	 */
	public WebElement refershBtn(){
		return findWebElementFromPropertyName("QuickTips_RefreshBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param text Should be any one of the text from the list of quick tips.
	 * @return WebElement for the property named <b>QuickTips_QuickTipContainer_XPATH</b>.
	 */
	public WebElement quickTipContainerWithText(String text){
		return findWebElementFromPropertyName("QuickTips_QuickTipContainer_XPATH", text);
	}
	
	/**
	 * Performs refresh on quick tips
	 * @throws InterruptedException
	 */
	public void performRefresh() throws InterruptedException
	{
		clickWebElement(refershBtn());
	}

	/**
	 * Compares the text with quick tip text
	 * @param text Should be any one of the text from the list of quick tips.
	 */
	public void verifyText(String text)
	{
		quickTipContainerWithText(text);
	}
}