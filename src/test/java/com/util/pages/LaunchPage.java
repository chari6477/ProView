package com.util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Launch Page</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class LaunchPage extends BaseObject
{
	/**
	 * This method constructs the Object of <b>LaunchPage</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public LaunchPage(WebDriver driver)
	{
	
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>LaunchPage_LaunchProViewBtn_XPATH</b>.
	 */
	public WebElement launchProViewBtn(){
		return findWebElementFromPropertyName("LaunchPage_LaunchProViewBtn_XPATH");
		
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param appType Should be either "Web Browser" or "Desktop"
	 * @return WebElement for the property named <b>LaunchPage_AppTypeSelectionLinks_XPATH</b>.
	 */
	public WebElement appTypeSelectionLinks(String appType){
		return findWebElementFromPropertyName("LaunchPage_AppTypeSelectionLinks_XPATH",appType);
	}

	/**
	 * Launches the selected ProView app
	 * @throws InterruptedException
	 */
	public void launchApp() throws InterruptedException
	{
		
		clickWebElement(launchProViewBtn());
	}

	/**
	 * Selects the ProView app type
	 * @param app "Desktop" or "Web Browser"
	 * @throws InterruptedException
	 */
	public void selectApp(String appType) throws InterruptedException
	{
		clickWebElement(appTypeSelectionLinks(appType));
	}
}