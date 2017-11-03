package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>QuickLinks</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class QuickLinks extends BaseObject
{
	/**
	 * This method constructs the Object of <b>QuickLinks</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public QuickLinks(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>QuickLinks_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("QuickLinks_MenuBtn_ID");
	} 
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>QuickLinks_DropdownSelector_ID</b>.
	 */
	public WebElement dropdown(){
		return findWebElementFromPropertyName("QuickLinks_DropdownSelector_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param option Should be any one of the Quick Link List Option from the dropdown.
	 * @return WebElement for the property named <b>QuickLinks_DropdownOptions_XPATH</b>.
	 */	
	public WebElement dropdownOptions(String option){
		return findWebElementFromPropertyName("QuickLinks_DropdownOptions_XPATH", option);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param quickLinkTitle Should be any one of the Quick Link Title from the list of Titles.
	 * @return WebElement for the property named <b>QuickLinks_LinkTitles_XPATH</b>.
	 */	
	public WebElement quickLinks(String quickLinkTitle){
		WebElement elm=null;
		try {
			elm=findWebElementFromPropertyName("QuickLinks_LinkTitles_XPATH",quickLinkTitle);
		} catch (Exception e) {
			elm=textOnPage(quickLinkTitle);
		}
		System.out.println(elm.getText());
		return elm;
	}
	
	/**
	 * Opens Quick Links Menu
	 */
	public void open()
	{
		clickWebElement(menuBtn());
	}
	
	/**
	 * Selects Quick Link List from dropdown.
	 * @param list Should be any one of the Quick Link Lists available
	 */
	public void selectSet(String list)
	{
		clickWebElement(dropdown());
		clickWebElement(dropdownOptions(list));
	}

	/**
	 * Clicks on Quick Link and Navigates to the corresponding page.
	 * @param linkTitle Shoule be any one of the quick link from the list of the links.
	 * @throws InterruptedException
	 */
	public void navigateToLink(String linkTitle) throws InterruptedException
	{
		clickWebElement(quickLinks(linkTitle));
	}
}