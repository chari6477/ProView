package com.util.pages;

import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Create and Share</b> menu of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class CreateAndShare extends BaseObject
{
	/**
	 * This method constructs the Object of <b>CreateAndShare</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public CreateAndShare(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>CreateAndShare_MenuBtn_ID</b>.
	 */
	public WebElement createAndShareMenuBtn(){
		return findWebElementFromPropertyName("CreateAndShare_MenuBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param option Should be either <b>PDF</b> or <b>Link</b>
	 * @return WebElement for the property named <b>CreateAndShare_OptionBtns_XPATH</b>.
	 */
	public WebElement shareOptionBtns(String option){
		return findWebElementFromPropertyName("CreateAndShare_OptionBtns_XPATH", option);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>CreateAndShare_CreatePDFBtn_XPATH</b>.
	 */
	public WebElement createPDFBtn(){
		return findWebElementFromPropertyName("CreateAndShare_CreatePDFBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param content Should be either <b>CurrentView</b> or <b>CurrentTOCSection</b>
	 * @return WebElement for the property named <b>CreateAndShare_ContentSelectionRadioBtns_XPATH</b>.
	 */
	public WebElement contentSelectionRadioBtns(String content){
		return findWebElementFromPropertyName("CreateAndShare_ContentSelectionRadioBtns_XPATH",content);
	}
	
	/**
	 * Creates a <b>PDF</b> based on selected content.
	 * @throws InterruptedException
	 */
	public void createPDF() throws InterruptedException
	{
		clickWebElement(createPDFBtn());
	}

	/**
	 * Opens <b>Create and Share</b> menu by clicking on it.
	 * @throws InterruptedException
	 */
	public void openCreateAndShareMenu() throws InterruptedException
	{
		clickWebElement(createAndShareMenuBtn());
	}
	
	/**
	 * Used to select content type radio button
	 * @param content should be either <b>CurrentView</b> or <b>CurrentTOCSection</b>
	 * @throws InterruptedException
	 */
	public void selectContent(String content) throws InterruptedException
	{
		if(!verifyContentSelection(content)){
			clickWebElement(contentSelectionRadioBtns(content));
		}
		
	}

	
	/**
	 * Used to select type of share.
	 * @param option Should be either <b>PDF</b> or <b>Link</b> in any alphabetical case.
	 * @throws InterruptedException
	 */
	public void selectShareType(String option) throws InterruptedException
	{
		clickWebElement(shareOptionBtns(WordUtils.capitalizeFully(option)));
	}
	
	
	/**
	 * Used to verify whether particular content type is selected.
	 * @param content Should be either <b>CurrentView</b> or <b>CurrentTOCSection</b>.
	 */
	public boolean verifyContentSelection(String content)
	{
		boolean result=verifyWebElementIsDisplayed("CreateAndShare_SelectedContentSelectionRadioBtns_XPATH",content);
		if(result)Assert.assertTrue(result);
		return result;
	}
}