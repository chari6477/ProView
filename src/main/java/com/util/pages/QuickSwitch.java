package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;

/**
 * This class contains all <b>Page Objects</b> related to <b>QuickSwitch</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class QuickSwitch extends BaseObject
{

	/**
	 * This method constructs the Object of <b>QuickSwitch</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public QuickSwitch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>QuickSwitch_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("QuickSwitch_MenuBtn_ID");
	}

	/**
	 * Opens quick switch menu
	 */
	public void open()
	{
		clickWebElement(menuBtn());
	}

}