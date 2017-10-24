package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Viewer</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Viewer extends BaseObject
{
	/**
	 * This method constructs the Object of <b>Viewer</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Viewer(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param typeOfViewer Should be any of the following - <b>TableViewer, ImageViewer</b>.
	 * @return WebElement for the property named <b>Viewer_CreateAndShareBtn_ID</b>.
	 */
	public WebElement createAndShareBtnOfViewers(String typeOfViewer){
		
		return findWebElementFromPropertyName("Viewer_CreateAndShareBtn_ID", typeOfViewer.toLowerCase());
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Viewer_OpenImageViewerBtn_ID</b>.
	 */
	public WebElement openImageViewerBtn(){
		return findWebElementFromPropertyName("Viewer_OpenImageViewerBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Viewer_OpenTableViewerBtn_ID</b>.
	 */
	public WebElement openTableViewerBtn(){
		return findWebElementFromPropertyName("Viewer_OpenTableViewerBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param typeOfViewer Should be any of the following - <b>TableViewer, ImageViewer</b>.
	 * @return WebElement for the property named <b>Viewer_CloseBtns_ID</b>.
	 */
	public WebElement closeViewersBtn(String typeOfViewer){
		return findWebElementFromPropertyName("Viewer_CloseBtns_ID", typeOfViewer.toLowerCase());
	}
	
	/**
	 * Selects type of viewer from the Create and Share menu.
	 * @param typeOfViewer Should be any of the following - <b>TableViewer, ImageViewer</b>.
	 * @throws InterruptedException
	 */
	public void openCreateAndShareMenuOfViewers(String typeOfViewer) throws InterruptedException
	{
		clickWebElement(createAndShareBtnOfViewers(typeOfViewer));
		threadWait(3);
	}

	/**
	 * Closes the viewer popover by passing the type of viewer.
	 * @param typeOfViewer Should be any of the following - <b>TableViewer, ImageViewer</b>.
	 * @throws InterruptedException
	 */
	public void closeViewer(String typeOfViewer)
	{
		clickWebElement(closeViewersBtn(typeOfViewer));
	}

	/**
	 * Opens image viewer pop over.
	 */
	public void openImageViewer()
	{
		clickWebElement(openImageViewerBtn());
	}

	/**
	 * Opens table viewer.
	 */
	public void openTableViewer()
	{
		clickWebElement(openTableViewerBtn());
		
	}

	/**
	 * Verifies image in image viewer pop over.
	 */
	public void verifyImage()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Viewer_ImageInImageViewer_XPATH"));
	}

	/**
	 * Verifies table contents from table viewer.
	 * @param text Should be a valid text to verify in table viewer.
	 */
	public void verifyTableContents(String text)
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Viewer_ContentInTableViewer_XPATH", text));
	}
	
}