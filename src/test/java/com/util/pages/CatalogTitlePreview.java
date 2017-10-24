package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Catalog Title Preview</b> of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class CatalogTitlePreview extends BaseObject
{
	/**
	 * This method constructs the Object of <b>CatalogTitlePreview</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public CatalogTitlePreview(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>CatalogTitlePreview_TableOfContentsHeader_XPATH</b>.
	 */
	public WebElement tableOfContentsHeader(){
		return findWebElementFromPropertyName("CatalogTitlePreview_TableOfContentsHeader_XPATH");
	}

	public void returnToCatalog()
	{
		click("returnToLibrary", "id");
	}
	
	/**
	 * Verifies <b>Title Preview</b> using <b>Table of Contents</b> header.
	 */
	public void verifyTitlePreview()
	{
		tableOfContentsHeader();
	}
}