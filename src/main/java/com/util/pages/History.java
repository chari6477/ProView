package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>History</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class History extends BaseObject
{

	/**
	 * This method constructs the Object of <b>History</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public History(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>History_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("History_MenuBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>History_BackBtn_XPATH</b>.
	 */
	public WebElement backBtn(){
		return findWebElementFromPropertyName("History_BackBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>History_ForwardBtn_XPATH</b>.
	 */
	public WebElement forwardBtn(){
		return findWebElementFromPropertyName("History_ForwardBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param index Should be index of History Items starting from 1.
	 * @return WebElement for the property named <b>History_Items_XPATH</b>.
	 */
	public WebElement historyItems(int index){
		return findWebElementFromPropertyName("History_Items_XPATH", String.valueOf(index));
	}

	/**
	 * Clicks on Back Button
	 */
	public void clickBackButton()
	{
		clickWebElement(backBtn());
	}

	/**
	 * Clicks on First Item of History
	 */
	public void clickFirstItem()
	{
		clickWebElement(historyItems(2));
	}
	
	/**
	 *Clicks on Forwards Button 
	 * @throws InterruptedException
	 */
	public void clickForwardButton() throws InterruptedException
	{
		clickWebElement(forwardBtn());
	}

	/**
	 * Opens History Menu
	 * @throws InterruptedException
	 */
	public void openHistoryMenu() throws InterruptedException
	{
		clickWebElement(menuBtn());
	}

	/**
	 * Verifies History Items Based on text provided
	 * @param text Should be page number present in history.
	 */
	public void verifyHistoryItem(String text)
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("History_ItemsPageNumberText_XPATH",text));
	}
}