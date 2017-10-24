package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Details Panel</b> menu of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class DetailsPanel extends BaseObject
{
	Library library=null;
	
	/**
	 * This method constructs the Object of <b>CreateAndShare</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public DetailsPanel(WebDriver driver)
	{
		this.driver = driver;
		library=new Library(driver);
		
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param category It can be any word/sentence to mark respective title to be in that category.
	 * @return WebElement for the property named <b>DetailsPanel_AlreadyAvailbleCategories_XPATH</b>.
	 */
	public WebElement alreadyAvailableCategories(String category){
		return findWebElementFromPropertyName("DetailsPanel_AlreadyAvailbleCategories_XPATH", category);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>DetailsPanel_ImportAnnotationsBtn_XPATH</b>.
	 */
	public WebElement importAnnotationsBtn(){
		return findWebElementFromPropertyName("DetailsPanel_ImportAnnotationsBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>DetailsPanel_AddACategoryBtn_XPATH</b>.
	 */
	public WebElement addACategoryBtn(){
		return findWebElementFromPropertyName("DetailsPanel_AddACategoryBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>DetailsPanel_AddCategoryTextFld_ID</b>.
	 */
	public WebElement addACategoryTextFld(){
		return findWebElementFromPropertyName("DetailsPanel_AddACategoryTextFld_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>DetailsPanel_DeleteCategoryButton_XPATH</b>.
	 */
	public WebElement deleteCategoryBtn(){
		return findWebElementFromPropertyName("DetailsPanel_DeleteCategoryBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>DetailsPanel_DeleteCategoryConfirmationBtn_XPATH</b>.
	 */
	public WebElement deleteCategoryConfirmationBtn(){
		return findWebElementFromPropertyName("DetailsPanel_DeleteCategoryConfirmationBtn_XPATH");
	}
	
	/**
	 * Finds the <b>Info</b> of any book when we pass title of the book.
	 * @param title Should be any one of the title that is available in the pool of books.
	 * @return WebElement for the property given.
	 */
	public WebElement titleInfoDetailsBtn(String title){
		return findWebElementFromPropertyName("Book_"+title+"_Details_XPATH");
	}
	
	/**
	 * Adds Category Details Into the Book Details.	
	 * @param text Should be any valid Category Name.
	 * @throws InterruptedException
	 */
	public void addCategory(String text) throws InterruptedException
	{
	
		clickWebElement(addACategoryBtn());
		enterText(addACategoryTextFld(), text);
		
		try {
			clickWebElement(alreadyAvailableCategories(text));
		} catch (Exception e) {
			System.out.println("This category name is not available in the list of categories.");
			clickWebElement(addACategoryBtn());
		}
		
	}

	/**
	 * Deletes a category by clicking on delete category button.
	 * @throws InterruptedException
	 */
	public void deleteCategory() throws InterruptedException
	{
		clickWebElement(deleteCategoryBtn());
		clickWebElement(deleteCategoryConfirmationBtn());
	}	


	/**
	 * Opens details panel of a title/book upon clicking info symbol.
	 * @param title Should be any book name which is available in pool of books.
	 * @throws InterruptedException
	 */
	public void openDetailsPanel(String title, boolean isImportNeeded) throws InterruptedException
	{
		library.titleForDetails(title, isImportNeeded);
		clickWebElement(titleInfoDetailsBtn(title));
	}

	/**
	 * Verifies presence of particular category across books.
	 * @param category Should be any one of the publisher categories.
	 * @throws InterruptedException
	 */
	public void verifyPublisherCategory(String category) throws InterruptedException
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("DetailsPanel_PublisherCategories_XPATH", category));
	}

	/**
	 * Verifies presence of particular category in details of book.
	 * @param category Should be any one of the user categories created by user/reader.
	 * @throws InterruptedException
	 */
	public void verifyUserCategory(String category) throws InterruptedException
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("DetailsPanel_UserCategories_XPATH", category));
	}
	
	/**
	 * Verifies deletion of particular category in details of book.
	 * @param category Should be any one of the user categories created by user/reader.
	 * @throws InterruptedException
	 */
	public void verifyUserCategoryDeleted(String category) throws InterruptedException
	{
		
		Assert.assertFalse(verifyWebElementIsDisplayed("DetailsPanel_UserCategories_XPATH", category));
	}
	
	/**
	 * Opens Import Annotations menu by clicking Import Annotations button in Details Panel.
	 */
	public void openImportAnnotationsMenu(){
		clickWebElement(importAnnotationsBtn());
	}
}