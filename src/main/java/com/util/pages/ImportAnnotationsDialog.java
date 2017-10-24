package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>ImportAnnotationsDialog</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class ImportAnnotationsDialog extends BaseObject
{
	private DetailsPanel detailsPanel;
	
	/**
	 * This method constructs the Object of <b>ImportAnnotationsDialog</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public ImportAnnotationsDialog(WebDriver driver)
	{
		this.driver = driver;
		detailsPanel=new DetailsPanel(driver);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>ImportAnnotationsDialog_ImportBtn_XPATH</b>.
	 */
	public WebElement importBtn(){
		return findWebElementFromPropertyName("ImportAnnotationsDialog_ImportBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param sourceName Should be any one of the book names.
	 * @return WebElement for the property named <b>ImportAnnotationsDialog_SourceLinks_XPATH</b>.
	 */
	public WebElement sourceLink(String sourceName){
		return findWebElementFromPropertyName("ImportAnnotationsDialog_SourceLinks_XPATH", sourceName);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>ImportAnnotationsDialog_CloseImportBtn_XPATH</b>.
	 */
	public WebElement closeImportBtn(){
		return findWebElementFromPropertyName("ImportAnnotationsDialog_CloseImportBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>ImportAnnotationsDialog_SuccessfulImportMessage_XPATH</b>.
	 */
	public WebElement successfulImportMessage(){
		return findWebElementFromPropertyName("ImportAnnotationsDialog_SuccessfulImportMessage_XPATH");
	}
	
	/**
	 * Clicks on Source Book Name to Import annotations
	 * @param sourceName Should be any one of the book name present in the list.
	 * @throws InterruptedException
	 */
	public void selectAnnotationsSource(String sourceName) throws InterruptedException
	{
		clickWebElement(sourceLink(sourceName));
	}

	/**
	 * Clicks on Import Button to import the annotations.
	 * @throws InterruptedException
	 */
	public void clickImportButton() throws InterruptedException
	{
		clickWebElement(importBtn());
	}
	
	/**
	 * Clicks on close to close the import annotations menu.
	 * @throws InterruptedException
	 */
	public void close() throws InterruptedException
	{
		clickWebElement(closeImportBtn(), 20);
		threadWait(10);
	}

	/**
	 * Opens the Import Annotations Dialogue from the details panel.
	 * @throws InterruptedException
	 */
	public void openImportAnnotationsDialog() throws InterruptedException
	{
		detailsPanel.openImportAnnotationsMenu();
	}

	/**
	 * Verifies completion of import.
	 * @throws InterruptedException
	 */
	public void verfiyImportCompleted() throws InterruptedException
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("ImportAnnotationsDialog_SuccessfulImportMessage_XPATH"));
	}
}