package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;

/**
 * This class contains all <b>Page Objects</b> related to <b>A-Z Index Menu</b> of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class AZIndex extends BaseObject
{
	/**
	 * This method constructs the Object of <b>AZIndex</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public AZIndex(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param letter Should anyone of alphabet from list of alphabets in Upper Case.
	 * @return WebElement for the property named <b>AZIndex_LetterEntries_XPATH</b>.
	 */
	public WebElement indexEntriesByLetter(String letter){
		return findWebElementFromPropertyName("AZIndex_LetterEntries_XPATH", letter);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AZIndex_MenuBtn_ID</b>.
	 */
	public WebElement indexBtn(){
		return findWebElementFromPropertyName("AZIndex_MenuBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param linkText Should be any link text entry that is associated with any index entry.
	 * @return WebElement for the property named <b>AZIndex_LinkEntries_XPATH</b>.
	 */
	public WebElement linkEntries(String linkText){
		return findWebElementFromPropertyName("AZIndex_LinkEntries_XPATH", linkText);
	}

	/**
	 * Clicks on <b>Link Text Entry</b> of any <b>Index</b> that is passed as a parameter.
	 * @param linkText Should be any link text entry that is associated with any index entry.
	 * @throws InterruptedException
	 */
	public void clickIndexLinkEntry(String linkText) throws InterruptedException
	{
		clickWebElement(linkEntries(linkText));
	}

	/**
	 * Opens <b>A-Z Index Menu</b> by clicking on it.
	 */
	public void openIndex()
	{
		clickWebElement(indexBtn());
	}

	/**
	 * Selects an <b>Index</b> by passing letter/alphabet as a parameter.
	 * @param letter Available <b>Index Alphabet</b> Letter in desired book.
	 * @throws InterruptedException
	 */
	public void selectLetter(String letter) throws InterruptedException
	{
		clickWebElement(indexEntriesByLetter(letter));
	}
}