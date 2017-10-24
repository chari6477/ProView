package com.util.pages;

import org.openqa.selenium.WebDriver;

import com.util.helpers.BaseObject;

/**
 * This class contains all <b>Page Objects</b> related to <b>URLModifier</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class URLModifier extends BaseObject
{
	/**
	 * This method constructs the Object of <b>URLModifier</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public URLModifier(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * Changes language of proview by url.
	 * @param language Should be any one of the valid languages.
	 * @throws InterruptedException
	 */
	public void changeLanguage(String language) throws InterruptedException
	{
		Thread.sleep(2000);
		getWebsite("https://proview." + readProperty("Test_Environment") + ".thomsonreuters.com/library.html?language=" + language);
	}
}