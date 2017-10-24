package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;

/**
 * This class contains all <b>Page Objects</b> related to <b>LibrarySearchAndFilter</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class LibrarySearchAndFilter extends BaseObject
{
	/**
	 * This method constructs the Object of <b>LibrarySearchAndFilter</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public LibrarySearchAndFilter(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param dropdownName Should be any one of the following, <b>Type, Juridiction, Publisher, Subject, Ownership and Category</b>
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_Dropdowns_ID</b>.
	 */
	public WebElement dropdowns(String dropdownName){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_Dropdowns_ID", dropdownName);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_MenuBtn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_MenuBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param searchTerm Should be a valid search term of any title.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_MenuBtn_ID</b>.
	 */
	public WebElement searchValidationInsideTitle(String searchTerm){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_SearchValidationInsideTitle_XPATH", searchTerm);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_ClearFilterBtn_XPATH</b>.
	 */
	public WebElement clearFilterBtn(){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_ClearFilterBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param tagName Should be a valid tag name.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_TagNamesRemoveBtn_XPATH</b>.
	 */
	public WebElement tagNamesRemoveBtn(String tagName){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_TagNamesRemoveBtn_XPATH", tagName);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param tagName Should be a valid tag name.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_TagNames_XPATH</b>.
	 */
	public WebElement tagNameLabel(String tagName){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_TagNames_XPATH", tagName);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>LibrarySearchAndFilter_SearchTextFld_ID</b>.
	 */
	public WebElement searchTextFld(){
		return findWebElementFromPropertyName("LibrarySearchAndFilter_SearchTextFld_ID");
	}
	
	
	/**
	 * It clears the filter.
	 * @throws InterruptedException
	 */
	public void clearFilter() throws InterruptedException
	{
		clickWebElement(clearFilterBtn());
	}

	/**
	 * Removes already searched tag name.
	 * @param tagName Should be any one of the valid tag name that has already used to perform search operations.
	 */
	public void deleteSearchOrFilterLabel(String tagName)
	{
		clickWebElement(tagNamesRemoveBtn(tagName));
	}

	/**
	 * Performs search based on the searchText Provided.
	 * @param searchText Should be valid text to search.
	 * @throws InterruptedException
	 */
	public void executeSearch(String searchText) throws InterruptedException
	{
		enterText(searchTextFld(), searchText+Keys.RETURN);
		
	}

	/**
	 * Selects the option from particular dropdown.
	 * @param dropdownName Should be any one of the valid Dropdowns from the list of dropdowns.
	 * @param option Should be any one of the option present in any particular selected dropdown.
	 * @throws InterruptedException
	 */
	public void filterDropDown(String dropdownName, String option) throws InterruptedException
	{
		if(dropdownName.equalsIgnoreCase("type")){
			dropdownName="titleTypes";
		}else{
			dropdownName=dropdownName.toLowerCase();
		}
		System.out.println(dropdownName);
		selectOptionFromDropdown(dropdowns(dropdownName), option);
	}
	
	/**
	 * Opens search menu to perform search operations.
	 * @throws InterruptedException
	 */
	public void openSearchAndFilter() throws InterruptedException
	{
		clickWebElement(menuBtn());
	}

	/**
	 * Verifies filtered output according to the tag name present.
	 * @param tagName Should be a valid tag name with which search has already performed.
	 * @throws InterruptedException
	 */
	public void verifyFilter(String tagName) throws InterruptedException
	{
		
		Assert.assertTrue(verifyWebElementIsDisplayed("LibrarySearchAndFilter_TagNames_XPATH", tagName));
	}

	/**
	 * Verifies deletion of tag name.
	 */
	public void verifyFilterDelete()
	{
		threadWait(2);
		Assert.assertFalse(verifyWebElementIsDisplayed("LibrarySearchAndFilter_NoFilterOrTag_XPATH"));
	}

	/**
	 * Verifies search results inside the Title.
	 * @param titleSearch Should be valid text to perform search on it.
	 */
	public void verifySearch(String titleSearch)
	{
		searchValidationInsideTitle(titleSearch);
	}
}