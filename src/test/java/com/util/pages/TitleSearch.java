package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>TitleSearch</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class TitleSearch extends BaseObject
{
	/**
	 * This method constructs the Object of <b>TitleSearch</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public TitleSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_ClearSearchResultsBtn_ID</b>.
	 */
	public WebElement clearSearchResultsBtn(){
		return findWebElementFromPropertyName("TitleSearch_ClearSearchResultsBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param hitNumber Should a valid hit number.
	 * @return WebElement for the property named <b>TitleSearch_HitMarks_ID</b>.
	 */
	public WebElement hitMarkers(String hitNumber){
		return findWebElementFromPropertyName("TitleSearch_HitMarks_ID", hitNumber);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_AddSearchBtn_XPATH</b>.
	 */
	public WebElement addSearchBtn(){
		return findWebElementFromPropertyName("TitleSearch_AddSearchBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_SaveQueryBtn_XPATH</b>.
	 */
	public WebElement saveQueryBtn(){
		return findWebElementFromPropertyName("TitleSearch_SaveQueryBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param index Should be valid text field container index.
	 * @return WebElement for the property named <b>TitleSearch_TxtFldContainer_XPATH</b>.
	 */
	public WebElement searchTextFieldContainer(String index){
		return findWebElementFromPropertyName("TitleSearch_TxtFldContainer_XPATH",index);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param index Should be valid text field index.
	 * @return WebElement for the property named <b>TitleSearch_TxtFld_XPATH</b>.
	 */
	public WebElement searchTextFld(String index){
		return findWebElementFromPropertyName("TitleSearch_TxtFld_XPATH", index);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param termName Should be a valid term name of thesaurus.
	 * @return WebElement for the property named <b>TitleSearch_ThesaurusSearchTerms_XPATH</b>.
	 */
	public WebElement thesaurusTerms(String termName){
		return findWebElementFromPropertyName("TitleSearch_ThesaurusSearchTerms_XPATH", termName);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param linkText Should be a valid link text from list of results to expand.
	 * @return WebElement for the property named <b>TitleSearch_SearchResultMainLinks_XPATH</b>.
	 */
	public WebElement searchResultMainLinksToExpand(String linkText){
		return findWebElementFromPropertyName("TitleSearch_SearchResultMainLinks_XPATH", linkText);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param text Should be a valid text from list of result snippets.
	 * @return WebElement for the property named <b>TitleSearch_Snippets_XPATH</b>.
	 */
	public WebElement searchResultSnippetsOfMainLinks(String text){
		return findWebElementFromPropertyName("TitleSearch_Snippets_XPATH", text);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_NextSearchHitBtn_ID</b>.
	 */
	public WebElement nextSearchHitBtn(){
		return findWebElementFromPropertyName("TitleSearch_NextSearchHitBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_PreviousSearchHitBtn_ID</b>.
	 */
	public WebElement previousSearchHitBtn(){
		return findWebElementFromPropertyName("TitleSearch_PreviousSearchHitBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>TitleSearch_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("TitleSearch_MenuBtn_ID");
	}
	
	/**
	 * Performs keyword search based on the given text.
	 * @param text Should be a valid text to perform the search on.
	 * @throws InterruptedException
	 */
	public void performKeyWordSearch(String text) throws InterruptedException
	{
		clickWebElement(addSearchBtn());
		enterText(searchTextFld("2"), text+Keys.ENTER);
	}
	

	/**
	 * Goes to next hit.
	 */
	public void goToNextHit()
	{
		clickWebElement(nextSearchHitBtn());
	}

	/**
	 * Opens the title search menu button.
	 */
	public void openTitleSearch()
	{
		clickWebElement(menuBtn());
	}

	/**
	 * Goes to previous hit.
	 */
	public void goToPreviousHit()
	{
		clickWebElement(previousSearchHitBtn());
	}

	/**
	 * Clears the search result.
	 */
	public void clearSearchResults()
	{
		clickWebElement(clearSearchResultsBtn());
	}

	/**
	 * Performs thesaurus search with the given text.
	 * @param text Should be any one of the valid text to perform thesaurus search.
	 * @throws InterruptedException
	 */
	public void performThesaurusSearch(String text) throws InterruptedException
	{
		clickWebElement(searchTextFieldContainer("1"));
		threadWait(2);
		enterText(searchTextFld("1"), text);
		threadWait(2);
		clickWebElement(thesaurusTerms(text));
	}

	/**
	 * Navigates to the search hit text in the title by clicking on it.
	 * @param linkText Should be any one of link text from the list of search hits.
	 */
	public void goIntoTitleSearchFirstHit(String linkText)
	{
		threadWait(3);
		clickWebElement(searchResultMainLinksToExpand(linkText));
		clickWebElement(searchResultSnippetsOfMainLinks(linkText));
	}

	/**
	 * Validates search hit markes with the given hit number and hit value.
	 * @param hitNumber Should be valid hit number.
	 * @param hitValue Should be valid hit value.
	 */
	public void validateSearchHitMarkers(String hitNumber, String hitValue)
	{
		Assert.assertTrue(verifyTextInWebElement(hitMarkers(hitNumber), hitValue));
	}

	/**
	 * Verifies the presence of search hit markes with the given hit number and hit value.
	 * @param hitNumber Should be valid hit number.
	 * @param hitValue Should be valid hit value.
	 */
	public void verifyPresenceOfHitMarkers(String hitNumber, String hitValue)
	{
		Assert.assertFalse(verifyWebElementIsDisplayed("TitleSearch_HitMarks_ID", hitNumber));
	}
}