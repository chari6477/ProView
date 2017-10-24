package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Account Menu</b> of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class AccountMenu extends BaseObject
{
	/**
	 * This method constructs the Object of <b>AccountMenu</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public AccountMenu(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AccountMenu_Btn_ID</b>.
	 */
	public WebElement accountMenuBtn(){
		return findWebElementFromPropertyName("AccountMenu_Btn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param optionName : Should be one among the following - <b>Language</b>, <b>Export List of Titles</b>, <b>Contact Us</b>, <b>Privacy Policy</b>, <b>Clear ProView Cookies</b>, <b>Refresh Library</b> and <b>Sign Out</b>.
	 * @return WebElement for the property named <b>AccountMenu_Options_XPATH</b>.
	 */
	public WebElement accountMenuOptionsByName(String optionName){
		return findWebElementFromPropertyName("AccountMenu_Options_XPATH", optionName);
	}

	
	public void clickPersonalize() throws InterruptedException
	{
		waitForElementToBeClickable("personalizeAccountButton", "id", 5);
		click("personalizeAccountButton", "id");
	}
	
	/**
	 * It clicks on <b>Account Menu</b> and opens it.
	 * @throws InterruptedException
	 */
	public void openAccountMenu() throws InterruptedException
	{
		clickWebElement(accountMenuBtn());
	
	}

	/**
	 * It clicks on <b>Sign Out</b> option of <b> Account Menu</b> to get Signed Off.
	 * @throws InterruptedException
	 */
	public void signOut() throws InterruptedException
	{
		clickWebElement(accountMenuOptionsByName("Sign Out"));

	}
}