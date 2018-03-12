package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Library</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Library extends BaseObject
{
	protected LibrarySearchAndFilter searchAndFilter = null;

	/**
	 * This method constructs the Object of <b>Library</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Library(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_BannerDisclosingBtn_ID</b>.
	 */
	public WebElement bannerDisclosingBtn(){
		return findWebElementFromPropertyName("Library_BannerDisclosingBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_SortByDropdown_ID</b>.
	 */
	public WebElement sortByDropdown(){
		return findWebElementFromPropertyName("Library_SortByDropdown_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_NextPageBtn_XPATH</b>.
	 */	
	public WebElement nextPageBtn(){
		return findWebElementFromPropertyName("Library_NextPageBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param title Should be any one of the title from the list of titles.
	 * @return WebElement for the property named <b>"Book_"+title+"_XPATH"</b>.
	 */
	public WebElement title(String title){
		WebElement book=null;
		try{
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH",10);
		}catch(Exception e){
			searchForTitle(title);
			threadWait(2);
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH");
		}
		
		return book;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param title Should be any one of the title from the list of titles.
	 * @param searchOnNextPage Enable it to search on next page also.
	 * @return WebElement for the property named <b>Book_+title+_XPATH</b>.
	 */
	public WebElement titleByScrolling(String title, boolean searchOnNextPage){
		WebElement book=null;
		boolean isTitleDisplayed=false;
		int  count=1;
		int pixels=200;
		while(!isTitleDisplayed && count<35){
			try{
				book=findWebElementFromPropertyName("Book_"+title+"_XPATH", 1);
				isTitleDisplayed=true;
			}catch(Exception e){
				jQueryScroll("Library_TitlesListContainer_ID", String.valueOf(pixels*count));
				isTitleDisplayed=false;
				threadWait(1);
				count++;
			}
			
		}
		if(book==null){
			if(searchOnNextPage){
				clickNextPageBtn();
				threadWait(1);
				book=titleByScrolling(title, false);
			}else{
				throw new RuntimeException(title+" Title Not Found");
			}
		}
		//moveToWebElement(book);
		System.out.println(book.getAttribute("src"));
		return book;
		
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_ViewTypeToggle_XPATH</b>.
	 */
	public WebElement libraryViewTypeToggle(){
		return findWebElementFromPropertyName("Library_ViewTypeToggle_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param title Should be any one of the title from the list of titles.
	 * @param isImportNeeded Enable it to perform import annotations functionality.
	 * @return WebElement for the property named <b>Library_ViewTypeToggle_XPATH</b>.
	 */
	public WebElement titleForDetails(String title, boolean isImportNeeded){
		WebElement book=null;
		if(isImportNeeded){
			book=titleByScrolling(title, true);
		} else{
			searchForTitle(title);
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH");
		}
		return book;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param title Should be any one of title from the list of titles.
	 * @return WebElement for the property named <b>Book_+title+_XPATH</b>.
	 */
	public WebElement titleWithOutSearching(String title){
		return findWebElementFromPropertyName("Book_"+title+"_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_FilterByNameOrAuthorClearBtn_XPATH</b>.
	 */
	public WebElement clearBtn(){
		return findWebElementFromPropertyName("Library_FilterByNameOrAuthorClearBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_FilterByNameOrAuthorTextFld_XPATH</b>.
	 */
	public WebElement filterByNameOrAuthorTextFld(){
		return findWebElementFromPropertyName("Library_FilterByNameOrAuthorTextFld_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_CatalogBtn_ID</b>.
	 */
	public WebElement catalogBtn(){
		return findWebElementFromPropertyName("Library_CatalogBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_eReferenceBtn_ID</b>.
	 */
	public WebElement eReferenceBtn(){
		return findWebElementFromPropertyName("Library_eReferenceBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Library_LibraryBtn_ID</b>.
	 */
	public WebElement libraryBtn(){
		return findWebElementFromPropertyName("Library_LibraryBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param navType Should be either <b>Previous Page</b> or <b>Next Page</b>
	 * @return WebElement for the property named <b>Library_NavigationBtns_XPATH</b>.
	 */
	public WebElement navigationBtns(String navType){
		return findWebElementFromPropertyName("Library_NavigationBtns_XPATH", navType);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param viewType Should be either <b>list</b> or <b>card</b>.
	 * @return WebElement for the property named <b>Library_ViewTypeVerifier_XPATH</b>.
	 */
	public WebElement libraryViewTypeVerifier(String viewType){
		return findWebElementFromPropertyName("Library_ViewTypeVerifier_XPATH", viewType);
	}
	
	/**
	 * Closes the Banner.
	 */
	public void closeBanner(){
		clickWebElement(bannerDisclosingBtn());
	}
	
	/**
	 * Clicks on Next Page Button to Navigate to Next page.
	 */
	public void clickNextPageBtn(){
		clickWebElement(nextPageBtn());
	}
	
	/**
	 * Clears the Search
	 */
	public void clearSearch()
	{
		clickWebElementByActionsClass(clearBtn());
	}

	/**
	 * Clicks on the Catalog Button
	 */
	public void clickCatalogButton()
	{
		clickWebElement(catalogBtn());
	}

	/**
	 * Clicks on eReference Button
	 * @throws InterruptedException
	 */
	public void clickeReferenceButton() throws InterruptedException
	{
		clickWebElement(eReferenceBtn());
	}

	/**
	 * Clicks on Library Button
	 * @throws InterruptedException
	 */
	public void clickLibraryButton() throws InterruptedException
	{
		clickWebElement(libraryBtn());
	}

	/**
	 * Filters the list of titles by text Provided
	 * @param textToEnter Text to Filter the titles according to it.
	 * @throws InterruptedException
	 */
	public void filterTitlesByText(String textToEnter) throws InterruptedException
	{
		enterText(filterByNameOrAuthorTextFld(), textToEnter);
	}

	/**
	 * Used to Navigate among the pages of titles.
	 * @param navType Should be either <b>Next Page</b> and <b>Previous Page</b>.
	 */
	public void navigateTo(String navType){
		clickWebElement(navigationBtns(navType));
	}
	
	/**
	 * Opens title based on the given title name.
	 * @param titleName Should be any one of the title from the list of titles.
	 */
	public void openTitle(String titleName)
	{
		clickWebElement(title(titleName));
	}
	
	/**
	 * Opens title by scrolling across the page.
	 * @param titleName Should be any one the title from the list of titles.
	 */
	public void openTitleByScrolling(String titleName){
		clickWebElement(titleByScrolling(titleName, false));
	}

	/**
	 * Switches the library view
	 */
	public void switchToLibraryView()
	{
		clickWebElement(libraryViewTypeToggle());
	}

	/**
	 * Verifies navigation buttons displayed.
	 * @param navType Should be either <b>Next Page</b> or <b>Previous Page</b>.
	 */
	public void verifyNavigationButtonIsDisplayed(String navType)
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Library_NavigationBtns_XPATH", navType));
	}

	
	public void verifyDueDate()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("LoanedTitle_DueDate_XPATH"));
	}

	/**
	 * Verifies whether user is in Library page.
	 * @throws InterruptedException
	 */
	public void verifyInLibrary() throws InterruptedException
	{
		waitForElementToBeClickable(libraryBtn(), 10);
	}

	/**
	 * Verifies Current Library View based on the type of view.
	 * @param type Type should be either <b>list</b> or <b>card</b>.
	 */
	public void verifyLibraryView(String type)
	{
		libraryViewTypeVerifier(type);
	}
	
	/**
	 * Verifies the sorttype that has been already selected from the dropdown.
	 * @param sortType Should be any one the sort type from the list of sorts types present in sort dropdown.
	 */
	public void verifySort(String sortType)
	{
		Assert.assertTrue(verifyTextInWebElement(getSelectedDropdownOption(sortByDropdown()),sortType));
	}
	
	/**
	 *Verifies whether the title exists. 
	 * @param title Should be any one of the title from the list of titles.
	 */
	public void verifyTitleExists(String title)
	{
		title(title);
	}
	
	/**
	 * Search for the title by entering the text in search field.
	 * @param title Should be any one of the title from the list of titles.
	 */
	public void searchForTitle(String title){
		enterText(filterByNameOrAuthorTextFld(), readProperty("Book_"+title+"_Title"));
	}
}