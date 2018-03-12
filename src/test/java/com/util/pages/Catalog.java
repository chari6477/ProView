package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Catalog</b> of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Catalog extends BaseObject
{
	/**
	 * This method constructs the Object of <b>Catalog</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Catalog(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Catalog_SearchResultsResetBtn_XPATH</b>.
	 */
	public WebElement searchResultsResetBtn(){
		return findWebElementFromPropertyName("Catalog_SearchResultsResetBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param typeOfSearch Should be one of the following <b>Search Catalog</b> and <b>Search by Thesaurus</b>.
	 * @return WebElement for the property named <b>Catalog_SearchBoxes_XPATH</b>.
	 */
	public WebElement searchBoxes(String typeOfSearch){
		return findWebElementFromPropertyName("Catalog_SearchBoxes_XPATH",typeOfSearch);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Catalog_SearchBtn_ID</b>.
	 */
	public WebElement searchBtn(){
		return findWebElementFromPropertyName("Catalog_SearchBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Catalog_DropdownMenu_ID</b>.
	 */
	public WebElement dropdownMenu(){
		return findWebElementFromPropertyName("Catalog_DropdownMenu_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param option Should be any one of the <b>Catalog Names</b> available to user.
	 * @return WebElement for the property named <b>Catalog_DropdownMenuOptions_XPATH</b>.
	 */
	public WebElement dropdownMenuOptions(String option){
		return findWebElementFromPropertyName("Catalog_DropdownMenuOptions_XPATH",option);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param label Should be any one of the Catalog Instructions Labels.
	 * @return WebElement for the property named <b>Catalog_SelectInstructionsLabels_XPATH</b>.
	 */
	public WebElement catalogSelectInstructionsLabels(String label){
		return findWebElementFromPropertyName("Catalog_SelectInstructionsLabels_XPATH",label);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Catalog_FilterByNameOrAuthorTextFld_XPATH</b>.
	 */
	public WebElement filterByNameOrAuthorTextFld(){
		return findWebElementFromPropertyName("Catalog_FilterByNameOrAuthorTextFld_XPATH");
	}
	
	/**
	 * Clears the recent search result.
	 */
	public void clearSearch()
	{
		clickWebElement(searchResultsResetBtn());
	}

	/**
	 * Performs search operation with given parameter.
	 * @param searchTerm Should be any one of the title name or partial title name present in catalog.
	 */
	public void executeSearch(String searchTerm)
	{
		enterText(searchBoxes("Search Catalog"), searchTerm);
		clickWebElement(searchBtn());
	}

	/**
	 * Opens <b>Title</b> that we got as a search result.
	 * @param title Should be any one of the <b>Title</b> present in the search result entries.
	 */
	public void openSearchResult(String title){
		clickWebElement(title(title));
	}
	
	/**
	 * Points to the desired <b>Title</b> if it is directly present in current page. If not it will <b>Search</b> for it based on title and points to it.
	 * @param title Any <b>Book Title</b> among the list of available titles.
	 * @return WebElement of <b>Title</b> passed as a parameter.
	 */
	public WebElement title(String title){
		WebElement book=null;
		try {
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH");
		} catch (Exception e) {
			filterCatalogSearchResults(title);
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH");
		}
		return book;
	}
	
	/**
	 * Selects the <b>Catalog</b> in drop down from list of Catalogs.
	 * @param catalogName Any one of the <b>Catalog</b> from the list of available Catalogs.
	 * @throws InterruptedException
	 */
	public void selectCatalog(String catalogName) throws InterruptedException
	{
		/*clickWebElement(dropdownMenu());
		clickWebElement(dropdownMenuOptions(catalogName));   comment by Chari */
		
		Select select = new Select(driver.findElement(By.id("catalogSelector")));
		select.selectByVisibleText(catalogName);
		Thread.sleep(3000);
				
	}
	
	/**
	 * Filters the <b>Catalog Search Results</b> based on the <b>Title Name</b> passed.
	 * @param title Any one of the <b>Book Title</b> available from the list of titles available from search results.
	 */
	public void filterCatalogSearchResults(String title){
		enterText(filterByNameOrAuthorTextFld(), readProperty("Book_"+title+"_Title"));
	}

	/**
	 * Verifies that user is currently in <b>Catalog</b> section.
	 */
	public void verifyInCatalog()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Catalog_SelectInstructionsLabels_XPATH","Catalog allows you to"));
	}

	/**
	 * Verifies that user is currently in <b>Catalog</b> section after clearing the search results.
	 */
	public void verifySearchCleared()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Catalog_SelectInstructionsLabels_XPATH","Catalog allows you to"));
	}
}