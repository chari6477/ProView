package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>RecentActivity</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class RecentActivity extends BaseObject
{
	/**
	 * This method constructs the Object of <b>RecentActivity</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public RecentActivity(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param title Should be any one of the title from the list of the titles.
	 * @return WebElement for the property named <b>Book_+title+_RecentActivity_XPATH</b>.
	 */
	public WebElement title(String title){
		return findWebElementFromPropertyName("Book_"+title+"_RecentActivity_XPATH");
	}
	
	/**
	 * Opens the title from the list titles.
	 * @param title Should be any one of the title from the list of the titles.
	 */
	public void openTitle(String title){
		clickWebElement(title(title));
	}
}