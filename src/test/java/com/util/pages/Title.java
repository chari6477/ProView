package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;

/**
 * This class contains all <b>Page Objects</b> related to <b>Title</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Title extends BaseObject
{
	/**
	 * This method constructs the Object of <b>Title</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Title(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Content_XPATH</b>.
	 */
	public WebElement titleContent(){
		return findWebElementFromPropertyName("Title_Content_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Bookmark_AddBtn_ID</b>.
	 */
	public WebElement addBookmarkBtn(){
		return findWebElementFromPropertyName("Title_Bookmark_AddBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 * @return WebElement for the property named <b>Title_Bookmark_Colors_XPATH</b>.
	 */
	public WebElement bookmarkColorOptions(String color){
		return findWebElementFromPropertyName("Title_Bookmark_Colors_XPATH", color);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 * @return WebElement for the property named <b>Title_Bookmark_ExistingOneWithColor_XPATH</b>.
	 */
	public WebElement existingBookmarksOfColor(String color){
		return findWebElementFromPropertyName("Title_Bookmark_ExistingOneWithColor_XPATH", color);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_BookMark_DescriptionTextFld_XPATH</b>.
	 */
	public WebElement bookmarkDescriptionTextFld(){
		return findWebElementFromPropertyName("Title_BookMark_DescriptionTextFld_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Bookmark_ClearDescriptonBtn_ID</b>.
	 */
	public WebElement clearBookmarkDescriptionBtn(){
		return findWebElementFromPropertyName("Title_Bookmark_ClearDescriptonBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Bookmark_SaveBtn_XPATH</b>.
	 */
	public WebElement bookmarkSaveBtn(){
		return findWebElementFromPropertyName("Title_Bookmark_SaveBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Bookmark_CloseBtn_XPATH</b>.
	 */
	public WebElement bookmarkCloseBtn(){
		return findWebElementFromPropertyName("Title_Bookmark_CloseBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param option Should be any one of the following- <b>Highlight, Add Note, Attach Displaced Annotation and Share</b>
	 * @return WebElement for the property named <b>Title_SelectedTextContextMenu_Options_XPATH</b>.
	 */
	public WebElement selectedTextContextMenu(String option){
		return findWebElementFromPropertyName("Title_SelectedTextContextMenu_Options_XPATH", option);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 * @return WebElement for the property named <b>Title_Highlight_Colors_XPATH</b>.
	 */
	public WebElement highlightWithColor(String color){
		return findWebElementFromPropertyName("Title_Highlight_Colors_XPATH", color);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param highlightText Should be a valid text on the page.
	 * @return WebElement for the property named <b>Title_Highlight_ExistingOne_XPATH</b>.
	 */
	public WebElement existingHighlights(String highlightText){
		return findWebElementFromPropertyName("Title_Highlight_ExistingOne_XPATH", highlightText);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Note_CreateNoteFromHighlightBtn_XPATH</b>.
	 */
	public WebElement createNoteFromHighlightBtn(){
		return findWebElementFromPropertyName("Title_Note_CreateNoteFromHighlightBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Note_TextFld_ID</b>.
	 */
	public WebElement noteTextFld(){
		return findWebElementFromPropertyName("Title_Note_TextFld_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Scrubber_JumpToPageTextFld_ID</b>.
	 */
	public WebElement jumpToPageTextFld(){
		return findWebElementFromPropertyName("Title_Scrubber_JumpToPageTextFld_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Annotation_Displaced_XPATH</b>.
	 */
	public WebElement displacedAnnotation(){
		return findWebElementFromPropertyName("Title_Annotation_Displaced_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Scrubber_NextPageBtn_XPATH</b>.
	 */
	public WebElement nextPageBtn(){
		return findWebElementFromPropertyName("Title_Scrubber_NextPageBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_RunningHeader_ID</b>.
	 */
	public WebElement runningHeader(){
		return findWebElementFromPropertyName("Title_RunningHeader_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Scrubber_PreviousPageBtn_XPATH</b>.
	 */
	public WebElement previousPageBtn(){
		return findWebElementFromPropertyName("Title_Scrubber_PreviousPageBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_BackToLibraryBtn_ID</b>.
	 */
	public WebElement backToLibrary(){
		return findWebElementFromPropertyName("Title_BackToLibraryBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Note_SaveNoteBtn_XPATH</b>.
	 */
	public WebElement saveNoteBtn(){
		return findWebElementFromPropertyName("Title_Note_SaveNoteBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Note_DeleteNoteBtn_XPATH</b>.
	 */
	public WebElement deleteNoteBtn(){
		return findWebElementFromPropertyName("Title_Note_DeleteNoteBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Scrubber_SliderRange_XPATH</b>.
	 */
	public WebElement scrubberRange(){
		return findWebElementFromPropertyName("Title_Scrubber_SliderRange_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_Scrubber_SliderBtn_XPATH</b>.
	 */
	public WebElement scrubberBtn(){
		return findWebElementFromPropertyName("Title_Scrubber_SliderBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_ExtraNav_NextPageBtn_ID</b>.
	 */
	public WebElement extraNavNextPageBtn(){
		return findWebElementFromPropertyName("Title_ExtraNav_NextPageBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_ExtraNav_PreviousPageBtn_ID</b>.
	 */
	public WebElement extraNavPreviousPageBtn(){
		return findWebElementFromPropertyName("Title_ExtraNav_PreviousPageBtn_ID");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 * @return WebElement for the property named <b>Title_Note_Colors_XPATH</b>.
	 */
	public WebElement noteWithColors(String color){
		return findWebElementFromPropertyName("Title_Note_Colors_XPATH", color);
	}
	
	public WebElement okBtn(){
		return findWebElementFromPropertyName("LoanedTitle_OKBtn_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_TrialSection_ToastInstructions_XPATH</b>.
	 */
	public WebElement trialSectionToastInstructions(){
		return findWebElementFromPropertyName("Title_TrialSection_ToastInstructions_XPATH");
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param text Should be a valid text of any compass markers.
	 * @return WebElement for the property named <b>Title_Compass_Markers_XPATH</b>.
	 */
	public WebElement compassMarkersWithTitle(String text){
		return findWebElementFromPropertyName("Title_Compass_Markers_XPATH", text);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param number Should be a valid foot note number.
	 * @return WebElement for the property named <b>Title_FootNotes_XPATH</b>.
	 */
	public WebElement footNotesByNumber(String number){
		return findWebElementFromPropertyName("Title_FootNotes_XPATH", number);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param content Should be a valid text of foot note inside a pop over.
	 * @return WebElement for the property named <b>Title_FootNotes_PopOverContent_XPATH</b>.
	 */
	public WebElement footNotePopOverContent(String content){
		return findWebElementFromPropertyName("Title_FootNotes_PopOverContent_XPATH", content);
	}
	
	/**
	 * Adds bookmark to the content.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 * @param description Valid description to the bookmark.
	 * @throws InterruptedException
	 */
	public void addBookmark(String color, String description) throws InterruptedException
	{
		clickWebElement(addBookmarkBtn());
		clickWebElement(bookmarkColorOptions(color));
		threadWait(2);
		clickWebElement(existingBookmarksOfColor(color));
		enterText(bookmarkDescriptionTextFld(), description);
		clickWebElement(bookmarkSaveBtn());
		threadWait(2);
		clickWebElement(bookmarkCloseBtn());
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Title_InterBookLinking_ContinueBtn_XPATH</b>.
	 */
	public WebElement interBookLinkingContinueBtn(){
		return findWebElementFromPropertyName("Title_InterBookLinking_ContinueBtn_XPATH");
	}
	
	/**
	 * Attaches the Displaced annotations to the title.
	 */
	public void addDisplacedAnnotation()
	{
		clickWebElement(selectedTextContextMenu("Attach Displaced Annotation"));
	}

	public void clickOkBtn(){
		clickWebElement(okBtn());
	}
	/**
	 * Adds Note to the title for a particular text.
	 * @throws InterruptedException
	 */
	public void addeNote() throws InterruptedException
	{
		clickWebElement(selectedTextContextMenu("Add Note"));
	}

	/**
	 * Adds highlight to the title for a particular text.
	 */
	public void addHighlight()
	{
		clickWebElement(selectedTextContextMenu("Highlight"));
	}
	
	/**
	 * Adds note from the highlight.
	 * @param highlightText Should be valid text from the title.
	 * @param noteText Should be description of the note for the highlight.
	 * @throws InterruptedException
	 */
	public void addNoteFromHighlight(String highlightText, String noteText) throws InterruptedException
	{
		Thread.sleep(1000);
		clickWebElement(existingHighlights(highlightText));
		clickWebElement(createNoteFromHighlightBtn());
		addNoteText(noteText);
		Thread.sleep(1000);
		saveNote();
	}
	/**
	 * Adds note description to the note.
	 * @param text Should be description of the note.
	 * @throws InterruptedException
	 */
	public void addNoteText(String text) throws InterruptedException
	{
		enterText(noteTextFld(), text);
	}

	/**
	 * Verifies that the given text is not present.
	 * @param text Should be valid text in the title.
	 */
	public void checkForAbsence(String text)
	{
		Assert.assertFalse(verifyTextOnPage(text));
	}

	/**
	 * Checks for the presence of displaced annotation.
	 */
	public void clickFirstDisplaced()
	{
		clickWebElement(displacedAnnotation());
	}

	/**
	 * Opens the link present in the title.
	 * @param linkText Should be any one of the text present in the title which is click-able.
	 */
	public void clickLink(String linkText)
	{
		currentTab=driver.getWindowHandle();
		clickWebElementByActionsClass(textOnPage(linkText));
		threadWait(5);
		for(String tab:driver.getWindowHandles()){
			System.out.println(tab);
			if(!tab.equalsIgnoreCase(currentTab)){
				driver.switchTo().window(tab);
			}
		}
	}

	/**
	 * Selects an option from the context menu.
	 * @param option Should be any one of the following- <b>Highlight, Add Note, Attach Displaced Annotation and Share</b>.
	 */
	public void clickOption(String option)
	{
		clickWebElement(selectedTextContextMenu(option));
	}

	/**
	 * Select the highlighting color by color name.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 */
	public void highlightColor(String color)
	{
		clickWebElement(highlightWithColor(color));
	}

	/**
	 * Highlights the given text.
	 * @param textToBeHighlighted Should be a valid text in the title.
	 * @throws InterruptedException
	 */
	public void highlightText(String textToBeHighlighted) throws InterruptedException
	{
		for(String handle:driver.getWindowHandles()){
			System.out.println(handle+"Handle");
		}
		threadWait(3);
		selectTextOfWebElement(textOnPage(textToBeHighlighted));
		
		
	}
	
	/**
	 * Performs double click on the text given.
	 * @param text Should be a valid text in the title.
	 */
	public void doubleClickOnText(String text){
		threadWait(3);
		doubleClickOnWebElement(textOnPage(text));
	}

	/**
	 * Used to Jump to a page by using page number.
	 * @param pageNum Should be any one of the valid page numbers.
	 * @throws InterruptedException
	 */
	public void jumpToPage(String pageNum) throws InterruptedException
	{
		enterText(jumpToPageTextFld(), pageNum+Keys.ENTER);
	}

	/**
	 * Clicks on interlinking continue button.
	 */
	public void linkingContinue()
	{
		clickWebElement(interBookLinkingContinueBtn());
	}

	/**
	 * Clicks on next page button.
	 * @throws InterruptedException
	 */
	public void nextPage() throws InterruptedException
	{
		clickWebElement(nextPageBtn());
	}

	/**
	 * Opens or Close running header on top.
	 */
	public void openOrCloseRunningHeader()
	{
		clickWebElement(runningHeader());
		threadWait(2);
	}

	/**
	 * Clicks on previous page button.
	 * @throws InterruptedException
	 */
	public void previousPage() throws InterruptedException
	{
		clickWebElement(previousPageBtn());
		threadWait(2);
	}

	/**
	 * Clicks on return to library button.
	 * @throws InterruptedException
	 */
	public void returnToLibrary() throws InterruptedException
	{
		clickWebElement(backToLibrary());
	}

	/**
	 * Clicks on Save Note button to save the save note.
	 */
	public void saveNote()
	{
		clickWebElement(saveNoteBtn());
	}

	/**
	 * Moves/Slides scrubber to the left.
	 */
	public void scrubberLeft()
	{
		dragAndDrop(scrubberBtn(), extraNavPreviousPageBtn());
	}

	/**
	 * Moves/Slides scrubber to the right.
	 */
	public void scrubberRight()
	{
		dragAndDrop(scrubberBtn(), extraNavNextPageBtn());
	}

	/**
	 * Selects color of note with the given color name.
	 * @param color Should be any one of the following colors - <b>green, blue, yellow, purple, pink and black</b>.
	 */
	public void selectNoteColor(String color)
	{
		clickWebElement(noteWithColors(color));
	}

	/**
	 * Verifies the trail toast of the title.
	 */
	public void verifyTrialToast()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Title_TrialSection_ToastInstructions_XPATH"));
		
	}
	
	/**
	 * Verifies color scheme based on the  given text.
	 * @param colorScheme Should be one of the following - <b>White On Black, Black On White and Black On Grey</b>.
	 * @throws InterruptedException
	 */
	public void verifyColorScheme(String colorScheme) throws InterruptedException
	{
		threadWait(5);
		String bgColor=getCSSValues(titleContent(),"background-color");
		String fontColor=getCSSValues(titleContent(), "color");
		System.out.println("BGColor: "+bgColor+"\tFontColor: "+fontColor);
		switch (colorScheme) {
			case "White On Black":
				if(System.getProperty("Browser").equalsIgnoreCase("firefox")){
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgb(33, 33, 33)"));
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgb(255, 255, 255)"));
				}else{
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgba(33, 33, 33, 1)"));
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgba(255, 255, 255, 1)"));
				}
					
				break;
				
			case "Black On White":
				if(System.getProperty("Browser").equalsIgnoreCase("firefox")){
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgb(33, 33, 33)"));
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgb(255, 255, 255)"));
				}else{
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgba(33, 33, 33, 1)"));
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgba(255, 255, 255, 1)"));
				}
				
				break;
	
			default:
				if(System.getProperty("Browser").equalsIgnoreCase("firefox")){
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgb(33, 33, 33)"));
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgb(240, 237, 229)"));
				}else{
					Assert.assertTrue(fontColor.equalsIgnoreCase("rgba(33, 33, 33, 1)"));
					Assert.assertTrue(bgColor.equalsIgnoreCase("rgba(240, 237, 229, 1)"));
				}
				break;
		}
		
	}

	/**
	 * Verifies compass text with the given text.
	 * @param compassMarkerTitle Should be valid compass text.
	 */
	public void verifyCompassText(String compassMarkerTitle){
		Assert.assertTrue(verifyWebElementIsDisplayed("Title_Compass_Markers_XPATH", compassMarkerTitle));
	}

	/**
	 * Clicks on footnote with the given footnote number.
	 * @param footNoteNumber Should be any one of the valid footnote number.
	 */
	public void clickFootnote(String footNoteNumber)
	{
		clickWebElement(footNotesByNumber(footNoteNumber));
	}

	/**
	 * Verifies footnote popover content with the given text.
	 * @param content Should be valid text of popover content.
	 */
	public void verifyFootnotePopoverContent(String content)
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("Title_FootNotes_PopOverContent_XPATH", content));
	}
}