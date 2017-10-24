package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>TableOfContents</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class TableOfContents extends BaseObject
{

	/**
	 * This method constructs the Object of <b>TableOfContents</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public TableOfContents(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TableOfContents_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("TableOfContents_MenuBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TableOfContents_FilterTextFld_XPATH</b>.
	 */
	public WebElement filterTextFld(){
		return findWebElementFromPropertyName("TableOfContents_FilterTextFld_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param textInIt Should be any one of the text of result from filtered table of contents section.
	 * @return WebElement for the property named <b>TableOfContents_FilteredResultSection_XPATH</b>.
	 */
	public WebElement filteredResultSection(String textInIt){
		return findWebElementFromPropertyName("TableOfContents_FilteredResultSection_XPATH", textInIt);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param sectionText Should be any one of the text of table of content from the list of the table of contents in that section
	 * @return WebElement for the property named <b>TableOfContents_FilteredResultSection_XPATH</b>.
	 */
	public WebElement tocSection(String sectionText){
		return findWebElementFromPropertyName("TableOfContents_Sections_XPATH", sectionText);
	}
	
	/**
	 * Filters the Table of Contents with the given text.
	 * @param text Should be a valid text to filter from the list of TOC items
	 */
	public void filterTOC(String text)
	{
		enterText(filterTextFld(), text);
	}
	
	/**
	 * Navigates to any one of the Filtered TOC section by clicking on the particular Entry
	 * @param link Should be any one of text of the TOCs Filtered Entry.
	 * @throws InterruptedException
	 */
	public void navigateToFilteredEntry(String link) throws InterruptedException
	{
		clickWebElement(filteredResultSection(link));
	}
	
	/**
	 * Navigates to any one of the TOC section by clicking on the particular Entry
	 * @param section Should be any one of the text of section of TOCs
	 */
	public void navigateToSection(String section){
		clickWebElement(tocSection(section));
	}

	/**
	 * Opens Table of Contents Menu
	 */
	public void open()
	{
		clickWebElement(menuBtn());
	}
}